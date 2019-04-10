package NowCoder.class02;

import java.util.Arrays;

/**
 *
 * 经典快排：小于等于num的放在左边，大于的放在右边
 * 使用荷兰国旗优化：小于num的放左边，等于num的放中间，大于的放在右边，递归左右两部分，可以省去中间部分等于区域的排序过程
 * 经典快拍每次只确定1个数，因此荷兰国旗会有优化效果
 *
 * 经典快排对于有序和逆序的效果都不理想，如果划分区域正好是第一个（或者最后一个），那么每次划分后会剩余T（n-1），退化成O（N^2）
 * 即选取的轴点刚好是最后一个，或者第一个，所以引入随机选取
 *
 */
public class QucikSort {
    public static void quickSort(int[] arr, int lo, int hi) {
        // 这里的判断可以保证只有返回的是有效区域的时候才会进行，如果lo>hi则不会进行
        if (lo < hi) {
            swap(arr, lo + (int) (Math.random() * (hi - lo + 1)), hi);
            int[] res = partition(arr, lo, hi);
            quickSort(arr, lo, res[0] - 1);
            quickSort(arr, res[1] + 1, hi);
        }
    }

    public static int[] partition(int[] arr, int lo, int hi) {
        int less = lo - 1;
        // 注意这里不是hi+1,即一开始arr[hi]已经划入more的范围内了，所以最后还要进行一次swap
        // 当然可以使用more = hi + 1，省去最后的swap，但是还需要一个int num = arr[hi]
        int more = hi + 1;
        //int num = arr[hi];
        int cur = lo;
        while (cur < more) {
            // 这里是将数组中的最后一个元素选做轴点
            if (arr[cur] < arr[hi]) {
                swap(arr, ++less, cur++);
            } else if (arr[cur] > arr[hi]) {
                swap(arr, --more, cur);
            } else {
                cur++;
            }
        }
        // 因为more是不断向前扩张的，所以只要将hi和more交换位置，即可把num放到中间区域中
        swap(arr, more, hi);
        // 返回等于区域的头和尾的位置
        return new int[]{less + 1, more};
    }

    public static void swap(int arr[], int m, int n) {
        int tmp = arr[m];
        arr[m] = arr[n];
        arr[n] = tmp;
    }

    public static void main(String[] args) {
        int[] arr = new int[]{9, 8, 6, 5, 3, 1, 2};
        quickSort(arr, 0, arr.length - 1);
        System.out.println(Arrays.toString(arr));
    }
}
