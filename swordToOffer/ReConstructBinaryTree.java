package NowCoder.swordToOffer;

/**
 * �ؽ���������
 * ����ĳ��������ǰ���������������Ľ�������ؽ����ö����������������ǰ���������������Ľ���ж������ظ������֡�
 * ��������ǰ���������{1,2,4,7,3,5,6,8}�������������{4,7,2,1,5,3,8,6}�����ؽ������������ء�
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
        // ������������������ҵ�pre[0]��λ��
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
