package NowCoder.class04;


import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

/**
 *
 * 二叉树的序列化和反序列化
 * 之所以使用#占位，是为了防止相同节点所构成的不同树结构，比如：
 *    1         1
 *  1   1          1
 *                     1
 * 这2种形式
 * 而使用_来占位，是为了防止节点中数字相连的情况，比如：
 *    1                12
 * 23               3
 * 如果不加以区分，会变成123这种形式
 *
 * 怎么序列化就怎么反序列化
 *
 * 1.先序遍历方式进行序列化
 * 2.按层次遍历方式进行序列化
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
