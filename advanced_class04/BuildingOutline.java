package NowCoder.advanced_class04;

import NowCoder.class03.ArrayQueue;

import java.util.*;

/**
 * ��¥������lintCode131
 * ֮���Ի������������Ϊ���߶ȷ����仯��
 * ���߶����������ı仯��Ϊ�������Ҫÿ�ζ��ҵ����߶ȣ����ǿ���ʹ��TreeMap����
 * ������ÿ��λ�õĸ߶ȱ仯�����������߼���
 */
public class BuildingOutline {
    public static class Node {
        // ��ǰλ�ã��߶ȣ����ϻ�������
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
            // �ֱ��¼��ʼλ�ã��߶ȣ��ͷ���
            nodes[i * 2] = new Node(buildings[i][0], buildings[i][2], true);
            nodes[i * 2 + 1] = new Node(buildings[i][1], buildings[i][2], false);
        }
        Arrays.sort(nodes, new Comparator<Node>() {
            @Override
            public int compare(Node o1, Node o2) {
                // �Ȱ���λ������
                if (o1.posi != o2.posi) {
                    return o1.posi - o2.posi;
                }
                // ���λ����ͬ������˳�����µ�
                if (o1.isUp != o2.isUp) {
                    return o1.isUp ? -1 : 1;
                }
                return 0;
            }
        });
        // ��¼�߶Ⱥͳ��ִ�����map
        TreeMap<Integer, Integer> htMap = new TreeMap<>();
        // pmMap���ڻ���������
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
                // �����lastKey��htMap�������Ǹ��ڵ�
                pmMap.put(nodes[i].posi, htMap.lastKey());
            }
        }
        List<List<Integer>> list = new ArrayList<>();
        int start = 0;
        int height = 0;
        // pmMap��λ��С���ȱ���
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
