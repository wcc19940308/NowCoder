package NowCoder.class01;

/**
 *
 * 递归方法求最大值：分治思想非常重要，递归求解左边和右边的最大值，然后求二者的较大者，递归基为只剩1个数的时候停止
 *
 */
public class GetMax {
    public static int getMax(int[] arr, int L, int R) {

        if (L == R) {
            return arr[L];
        }

        int mid = L + (R - L) / 2;
        int left = getMax(arr, L, mid);
        int right = getMax(arr, mid + 1, R);
        return Math.max(left, right);
    }

    public static void main(String[] args) {
        int[] arr = new int[]{121111, 1, 2, 3, 45, 65, 2323};
        System.out.println(getMax(arr, 0, arr.length - 1));
    }
}
