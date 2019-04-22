package NowCoder.advanced_class05;

public class DiameterofBinaryTree {
  public class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;

      TreeNode(int x) {
          val = x;
      }
  }

    public int diameterOfBinaryTree(TreeNode root) {
        // res数组代表到目前为止最长的距离
        int[] res = new int[1];
        recursive(root, res);
        return res[0];
    }

    public int recursive(TreeNode root, int[] res) {
        if (root == null) {
            res[0] = 0;
            return 0;
        }
        int left = recursive(root.left, res);
        int leftMaxLength = res[0];
        int right = recursive(root.right, res);
        int rightMaxLength = res[0];
        int curLength = left + right + 1;
        res[0] = Math.max(curLength, Math.max(leftMaxLength, rightMaxLength));
        return Math.max(left, right) + 1;
    }
}
