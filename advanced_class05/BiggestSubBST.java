package NowCoder.advanced_class05;

import sun.reflect.generics.tree.ReturnType;

/**
 * 求树的最大搜索二叉子树（必须是子树，即头结点出发的下面一定都要包含，否则称之为拓扑结构）
 * 分情况讨论：
 * 1.最大搜索二叉树在左子树
 * 2.最大搜索二叉树在右子树
 * 3.最大搜索二叉树是自己
 * 通过收集信息来判断，于是需要：
 *  1.左树最大搜索二叉子树大小
 *  2.右树最大搜索二叉子树头部
 *  3.左树最大搜索二叉子树头部
 *  4.右树最大搜索二叉子树头部
 *  5.左树最大搜索二叉子树的最大
 *  6.右树最大搜索二叉子树的最小
 * 将结构统一化：
 *  1.二叉搜索树大小
 *  2.二叉搜索树头部
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
        // 用于记录二叉搜索树大小，最小值，最大值,共用res数组来来记录各树的信息
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
