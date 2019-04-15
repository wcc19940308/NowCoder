package NowCoder.class02;

import java.util.Arrays;

/**
 *
 * 荷兰国旗问题：给定一个数num，将数组中划分成3部分，小于num的部分，等于num的部分，大于num的部分
 * less,cur,more 3个下标，遍历数组，如果值小于num，则和less+1互换，如果等于num，继续下一个，如果大于num，则和more-1互换
 * 相当于不断扩大小于和大于的区域，中间的部分就是等于的区域部分
 * 当cur == more的时候，停止
 *
 */
public class DutchFlag {
    // 左闭右闭
    public static int[] partition(int[] arr, int lo, int hi, int num) {
        int less = lo - 1; // 小于区域
        int more = hi + 1; // 大于区域
        int cur = lo;
        while (cur < more) {
            if (arr[cur] < num) {
                swap(arr, ++less, cur++);
            } else if (arr[cur] > num) {
                swap(arr, --more, cur); // 注意这里cur不同++
            } else {
                cur++;
            }
        }
        return new int[]{less + 1, more - 1};
    }

    public static void swap(int[] arr, int m, int n) {
        int tmp = arr[m];
        arr[m] = arr[n];
        arr[n] = tmp;
    }

    public static void main(String[] args) {
        int[] arr = new int[]{1, 6, 2, 5, 7, 1, 10, 22};
        partition(arr, 0, arr.length - 1, 10);
        System.out.println(Arrays.toString(arr));

    }
}
