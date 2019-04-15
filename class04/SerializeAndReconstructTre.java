package NowCoder.class04;


import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

/**
 *
 * �����������л��ͷ����л�
 * ֮����ʹ��#ռλ����Ϊ�˷�ֹ��ͬ�ڵ������ɵĲ�ͬ���ṹ�����磺
 *    1         1
 *  1   1          1
 *                     1
 * ��2����ʽ
 * ��ʹ��_��ռλ����Ϊ�˷�ֹ�ڵ���������������������磺
 *    1                12
 * 23               3
 * ������������֣�����123������ʽ
 *
 * ��ô���л�����ô�����л�
 *
 * 1.���������ʽ�������л�
 * 2.����α�����ʽ�������л�
 *
 */
public class SerializeAndReconstructTre {
    public static class TreeNode {
        public int value;
        public TreeNode left;
        public TreeNode right;

        public TreeNode(int data) {
            this.value = data;
        }
    }

    public static String serialByPre(TreeNode root) {
        if (root == null) {
            return "#_";
        }
        String res =  root.value + "_";
        res += serialByPre(root.left);
        res += serialByPre(root.right);
        return res;
    }

    public static Queue<String> deserialByPre(String res) {
        return new LinkedList<>(Arrays.asList(res.split("#")));
    }

    public static TreeNode deserialByPre(Queue<String> queue) {
        String root = queue.poll();
        if (root.equals("#")) {
            return null;
        }
        TreeNode node = new TreeNode(Integer.valueOf(root));
        node.left = deserialByPre(queue);
        node.right = deserialByPre(queue);
        return node;
    }
}
