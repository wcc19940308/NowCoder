package NowCoder.advanced_class06;

/**
 * 数组arr全是正数，一个正数aim，求累加和等于aim的最长子数组
 * 双指针:小于等于右边扩，大于左边扩（因为全是正数，单调性，没有0， 所以可以不用hash表）
 * 这样做能找到从0开始以数组中每个元素作为第一个元素能够找到的等于aim的最长子数组
 * （因为都是正数，所以如果存在，那么以每个下标开头的累加和等于aim的子数组一定只有一个）
 */
public class LongestSumSubArrayLengthInPositiveArray {
    public static int getMaxLength(int[] arr, int aim) {
        if (arr == null || arr.length == 0 || aim < 0) {
            return 0;
        }
        int n = arr.length;
        int sum = arr[0];
        int len = 1;
        int lo = 0, hi = 0;
        while (hi < n) {
            if (sum == aim) {
                len = Math.max(len, hi - lo + 1);
                sum -= arr[lo++];
            } else if (sum < aim) {
                hi++;
                if (hi == n) break;
                sum += arr[hi];
            } else {
                sum -= arr[lo++];
            }
        }
        return len;
    }
}
