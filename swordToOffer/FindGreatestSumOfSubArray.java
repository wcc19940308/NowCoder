package NowCoder.swordToOffer;

/**
 * ���������������
 * ̰�Ĳ���
 */
public class FindGreatestSumOfSubArray {
    public int FindGreatestSumOfSubArray(int[] array) {
        if (array == null || array.length == 0) return 0;
        int max = Integer.MIN_VALUE;
        int sum = array[0];
        for (int i = 1; i < array.length; i++) {
            sum = sum < 0 ? array[i] : sum + array[i];
            max = Math.max(sum, max);
        }
        return max;
    }
}
