package NowCoder.class05;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 *
 * ���鼯��Ӧ��
 * �����ж�2���ڵ��Ƿ���ͨ�����ߺϲ�2���ڵ����ڵļ���(��ʼ����ʱ�����һ�����õ���������)
 * �Ż��㣺һ��ǣ��������Ѱ���Ĺ��̣��ͽ�������ƽ��,��·���Ż�
 *
 */
public class UnionFindSet {
    public static class Node {

    }

    public static Map<Node, Node> fatherMap = new HashMap<>();
    public static Map<Node, Integer> sizeMap = new HashMap<>();
    public static void makeSet(List<Node> list) {
        fatherMap.clear();
        sizeMap.clear();
        for (Node node : list) {
            fatherMap.put(node, node);
            sizeMap.put(node, 1);
        }
    }

    public static Node findHead(Node node) {
        Node father = fatherMap.get(node);
        if (father != node) {
            findHead(father);
        }
        fatherMap.put(node, father);
        return father;
    }

    public static boolean isSameSet(Node node1, Node node2) {
        return findHead(node1) == findHead(node2);
    }

    public static void union(Node node1, Node node2) {
        if (node1 == null || node2 == null) {
            return;
        }
        if (node1 != node2) {
            int size1 = sizeMap.get(node1);
            int size2 = sizeMap.get(node2);
            Node father1 = fatherMap.get(node1);
            Node father2 = fatherMap.get(node2);
            if (size1 <= size1) {
                fatherMap.put(father1, father2);
                sizeMap.put(father2, size1 + size2);
            } else {
                fatherMap.put(father2, father1);
                sizeMap.put(father1, size1 + size2);
            }
        }
    }
}
