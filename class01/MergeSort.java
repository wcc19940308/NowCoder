package NowCoder.class01;

import java.util.Arrays;

/**
 *
 * 左闭右闭的归并排序, 分治思想
 *
 */
public class MergeSort {
    public static void mergeSort(int[] arr) {
        int n = arr.length;
        if (arr == null || n < 2) {
            return;
        }
        sortProcess(arr, 0, n - 1);
    }

    public static void sortProcess(int[] arr, int lo, int hi) {
        // 只有1个数
        if (lo == hi) {
            return;
        }
        int mid = lo + ((hi - lo) >> 1);
        sortProcess(arr,lo, mid);
        sortProcess(arr, mid + 1, hi);
        merge(arr, lo, mid, hi);
    }

    public static void merge(int[] arr, int lo, int mid, int hi) {
        int i = 0;
        int p1 = lo;
        int p2 = mid + 1;
        int[] p = new int[hi - lo + 1];
        while (p1 <= mid && p2 <= hi) {
            p[i++] = arr[p1] < arr[p2] ? arr[p1++] : arr[p2++];
        }
        while (p1 <= mid) {
            p[i++] = arr[p1++];
        }
        while (p2 <= hi) {
            p[i++] = arr[p2++];
        }
        for (i = 0; i < p.length; i++) {
            arr[lo + i] = p[i];
        }
    }

    public static void main(String[] args) {
        int arr[] = new int[]{6, 3, 8, 2, 5, 9, 5, 1, 7};
        mergeSort(arr);
        System.out.println(Arrays.toString(arr));
    }
}
