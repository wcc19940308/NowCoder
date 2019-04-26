package NowCoder.swordToOffer;

import java.util.ArrayList;

/**
 * 二叉树中和为某一值的路径
 * 题目描述
 * 输入一颗二叉树的跟节点和一个整数，打印出二叉树中结点值的和为输入整数的所有路径。
 * 路径定义为从树的根结点开始往下一直到叶结点所经过的结点形成一条路径。
 * (注意: 在返回值的list中，数组长度大的数组靠前)
 *
 * 注意这里的路径就是指的是从根节点为起点到叶节点为终点的路径
 */
public class FindPath {
    public static class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;
        public TreeNode(int val) {
            this.val = val;
        }
    }

    public  ArrayList<ArrayList<Integer>> FindPath(TreeNode root, int target) {
        ArrayList<ArrayList<Integer>> list = new ArrayList<>();
        recursive(root, target, list, new ArrayList<>());
        return list;
    }

    public  void recursive(TreeNode root, int target, ArrayList<ArrayList<Integer>> list, ArrayList<Integer> tmpList) {
        if (root == null) return;
        tmpList.add(root.val);
        target -= root.val;
        if (0 == target && root.left == null && root.right == null) {
            list.add(new ArrayList<>(tmpList));
        }
        recursive(root.left, target, list, tmpList);
        recursive(root.right, target, list, tmpList);
        tmpList.remove(tmpList.size() - 1);
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(10);
        TreeNode left = root.left = new TreeNode(5);
        TreeNode right = root.right = new TreeNode(12);
        TreeNode lleft = left.left = new TreeNode(4);
        TreeNode lright = left.right = new TreeNode(7);
    }
}
