package NowCoder.swordToOffer;

/**
 * �����������ĺ����������
 * ��Ŀ����:
 * ����һ���������飬�жϸ������ǲ���ĳ�����������ĺ�������Ľ����
 * ����������Yes,�������No���������������������������ֶ�������ͬ��
 *
 * �ݹ飬�����Σ�����ж��Ƿ���������
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
        // �ҵ��������ĵ�һ���ڵ�
        for (; i < end; i++) {
            if (sequence[i] > sequence[end]) break;
        }
        for (int j = i; j < end; j++) {
            if (sequence[j] < sequence[end]) return false;
        }
        return isBST(sequence, start, i - 1) && isBST(sequence, i, end - 1);
    }
}
