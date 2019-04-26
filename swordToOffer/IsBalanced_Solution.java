package NowCoder.swordToOffer;

public class IsBalanced_Solution {
    public static class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;
        public TreeNode(int val) {
            this.val = val;
        }
    }

//    public static boolean IsBalanced_Solution(TreeNode root) {
//        // 记录树的高度，最小值，最大值信息
//        int[] res = new int[3];
//        boolean ans = recursive(root, res);
//        return ans;
//    }
//
//    public static boolean recursive(TreeNode root, int[] res) {
//        if (root == null) {
//            res[0] = 0;
//            res[1] = Integer.MAX_VALUE;
//            res[2] = Integer.MIN_VALUE;
//            return true;
//        }
//        boolean left = recursive(root.left, res);
//        if (!left) return false;
//        int leftHeight = res[0];
//        int leftMin = res[1];
//        int leftMax = res[2];
//        boolean right = recursive(root.right, res);
//        if (!right) return false;
//        int rightHeight = res[0];
//        int rightMin = res[1];
//        int rightMax = res[2];
//        if (Math.abs(leftHeight - rightHeight) >1) return false;
//        res[0] = Math.max(leftHeight, rightHeight) + 1;
//        res[1] = Math.min(root.val, Math.min(leftMin, rightMin));
//        res[2] = Math.max(root.val, Math.max(leftMax, rightMax));
//        return root.val > leftMax && root.val < rightMin && left && right;
//    }

    public boolean IsBalanced_Solution(TreeNode root) {
        return isBalanced(root) != -1;
    }

    public int isBalanced(TreeNode root) {
        if (root == null) return 0;
        int left = isBalanced(root.left);
        if (left == -1) return -1;
        int right = isBalanced(root.right);
        if (right == -1) return -1;
        return Math.abs(left - right) > 1 ? -1 : Math.max(left, right) + 1;
    }
}
