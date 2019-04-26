package NowCoder.swordToOffer;

/**
 * 二叉搜索树的后序遍历序列
 * 题目描述:
 * 输入一个整数数组，判断该数组是不是某二叉搜索树的后序遍历的结果。
 * 如果是则输出Yes,否则输出No。假设输入的数组的任意两个数字都互不相同。
 *
 * 递归，分三段，逐段判断是否满足条件
 */
public class VerifySquenceOfBST {
    public boolean VerifySquenceOfBST(int[] sequence) {
        if (sequence == null || sequence.length == 0) {
            return false;
        }
        boolean res = isBST(sequence, 0, sequence.length - 1);
        return res;
    }

    public boolean isBST(int[] sequence, int start, int end) {
        if (start >= end) return true;
        int i = start;
        // 找到右子树的第一个节点
        for (; i < end; i++) {
            if (sequence[i] > sequence[end]) break;
        }
        for (int j = i; j < end; j++) {
            if (sequence[j] < sequence[end]) return false;
        }
        return isBST(sequence, start, i - 1) && isBST(sequence, i, end - 1);
    }
}
