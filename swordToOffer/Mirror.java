package NowCoder.swordToOffer;

public class Mirror {
    public static class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;

        public TreeNode(int val) {
            this.val = val;
        }
    }
    public void Mirror(TreeNode root) {
        recursive(root);
    }

    public TreeNode recursive(TreeNode root) {
        if (root == null) return null;
        TreeNode left = recursive(root.left);
        TreeNode right = recursive(root.right);
        root.right = left;
        root.left = right;
        return root;
    }

}
