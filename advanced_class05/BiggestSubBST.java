package NowCoder.advanced_class05;

import sun.reflect.generics.tree.ReturnType;

/**
 * �������������������������������������ͷ������������һ����Ҫ�����������֮Ϊ���˽ṹ��
 * ��������ۣ�
 * 1.���������������������
 * 2.���������������������
 * 3.����������������Լ�
 * ͨ���ռ���Ϣ���жϣ�������Ҫ��
 *  1.���������������������С
 *  2.�������������������ͷ��
 *  3.�������������������ͷ��
 *  4.�������������������ͷ��
 *  5.������������������������
 *  6.�����������������������С
 * ���ṹͳһ����
 *  1.������������С
 *  2.����������ͷ��
 *  3.Min, Max
 */
public class BiggestSubBST {
    public static class Node {
        int val;
        Node left;
        Node right;

        public Node(int val) {
            this.val = val;
        }
    }

    public Node biggestSubBST(Node head) {
        // ���ڼ�¼������������С����Сֵ�����ֵ,����res����������¼��������Ϣ
        int[] res = new int[3];
        Node node = getSubBST(head, res);
        return node;
    }

    public Node getSubBST(Node head, int[] res) {
        if (head == null) {
            res[0] = 0;
            res[1] = Integer.MAX_VALUE;
            res[2] = Integer.MIN_VALUE;
        }
        int value = head.val;
        Node left = head.left;
        Node right = head.right;
        Node leftSubBST = getSubBST(head.left, res);
        int leftSize = res[0];
        int leftMin = res[1];
        int leftMax = res[2];
        Node rightSubBST = getSubBST(head.right, res);
        int rightSize = res[0];
        int rightMin = res[1];
        int rightMax = res[2];
        res[1] = Math.min(head.val, Math.min(leftMin, rightMin));
        res[2] = Math.max(head.val, Math.max(leftMax, rightMax));
        if (value > leftMax && value < rightMin && left == leftSubBST && right == rightSubBST) {
            res[0] = leftSize + 1 + rightSize;
            return head;
        }
        res[0] = leftSize > rightSize ? leftSize : rightSize;
        return leftSize > rightSize ? leftSubBST : rightSubBST;
    }
}
