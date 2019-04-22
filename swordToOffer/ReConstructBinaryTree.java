package NowCoder.swordToOffer;

/**
 * 重建二叉树：
 * 输入某二叉树的前序遍历和中序遍历的结果，请重建出该二叉树。假设输入的前序遍历和中序遍历的结果中都不含重复的数字。
 * 例如输入前序遍历序列{1,2,4,7,3,5,6,8}和中序遍历序列{4,7,2,1,5,3,8,6}，则重建二叉树并返回。
 */
public class ReConstructBinaryTree {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }
    public TreeNode reConstructBinaryTree(int [] pre,int [] in) {
        if (pre.length == 0 || in.length == 0 || pre == null || in == null) {
            return null;
        }
        TreeNode res = recursive(pre, 0, pre.length - 1, in, 0, in.length - 1);
        return res;
    }

    public TreeNode recursive(int[] pre, int preStart, int preEnd, int[] in, int inStart, int inEnd) {
        if (preStart > preEnd || inStart > inEnd) {
            return null;
        }
        int val = pre[preStart];
        TreeNode root = new TreeNode(val);
        int index = 0;
        // 在中序遍历的序列中找到pre[0]的位置
        for (int i = inStart; i < in.length; i++) {
            if (in[i] == val) {
                index = i;
                break;
            }
        }
        root.left = recursive(pre, preStart + 1, preStart + index - inStart, in, inStart, index - 1);
        root.right = recursive(pre, preStart + index - inStart + 1, preEnd, in, index + 1, inEnd);
        return root;
    }
}
