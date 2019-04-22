package NowCoder.advanced_class04;

import NowCoder.class03.ArrayQueue;

import java.util.*;

/**
 * 大楼轮廓：lintCode131
 * 之所以会产生轮廓是因为最大高度发生变化了
 * 最大高度描述轮廓的变化行为，因此需要每次都找到最大高度，于是可以使用TreeMap来做
 * 最后跟踪每个位置的高度变化，生成轮廓线即可
 */
public class BuildingOutline {
    public static class Node {
        // 当前位置，高度，向上还是向下
        public int posi;
        public int h;
        public boolean isUp;

        public Node(int posi, int h, boolean isUp) {
            this.posi = posi;
            this.h = h;
            this.isUp = isUp;
        }
    }
    public List<List<Integer>> buildingOutline(int[][] buildings) {
        Node[] nodes = new Node[buildings.length * 2];
        for (int i = 0; i < buildings.length; i++) {
            // 分别记录起始位置，高度，和方向
            nodes[i * 2] = new Node(buildings[i][0], buildings[i][2], true);
            nodes[i * 2 + 1] = new Node(buildings[i][1], buildings[i][2], false);
        }
        Arrays.sort(nodes, new Comparator<Node>() {
            @Override
            public int compare(Node o1, Node o2) {
                // 先按照位置排序
                if (o1.posi != o2.posi) {
                    return o1.posi - o2.posi;
                }
                // 如果位置相同，优先顺序向下的
                if (o1.isUp != o2.isUp) {
                    return o1.isUp ? -1 : 1;
                }
                return 0;
            }
        });
        // 记录高度和出现次数的map
        TreeMap<Integer, Integer> htMap = new TreeMap<>();
        // pmMap用于画出轮廓线
        TreeMap<Integer, Integer> pmMap = new TreeMap<>();
        for (int i = 0; i < nodes.length; i++) {
            if (nodes[i].isUp) {
                if (!htMap.containsKey(nodes[i].h)) {
                    htMap.put(nodes[i].h, 1);
                } else {
                    htMap.put(nodes[i].h, htMap.get(nodes[i].h) + 1);
                }
            } else {
                if (htMap.containsKey(nodes[i].h)) {
                    if (htMap.get(nodes[i].h) == 1) {
                        htMap.remove(nodes[i].h);
                    } else {
                        htMap.put(nodes[i].h, htMap.get(nodes[i].h) - 1);
                    }
                }
            }
            if (htMap.isEmpty()) {
                pmMap.put(nodes[i].posi, 0);
            } else {
                // 这里的lastKey是htMap的最大的那个节点
                pmMap.put(nodes[i].posi, htMap.lastKey());
            }
        }
        List<List<Integer>> list = new ArrayList<>();
        int start = 0;
        int height = 0;
        // pmMap中位置小的先遍历
        for (Map.Entry<Integer, Integer> entry : pmMap.entrySet()) {
            int curPosition = entry.getKey();
            int curMaxHeight = entry.getValue();
            if (height != curMaxHeight) {
                if (height != 0) {
                    List<Integer> newRecord = new ArrayList<>();
                    newRecord.add(start);
                    newRecord.add(curPosition);
                    newRecord.add(height);
                    list.add(newRecord);
                }
                start = curPosition;
                height = curMaxHeight;
            }
        }
        return list;
    }

    public static void main(String[] args) {

    }
}
