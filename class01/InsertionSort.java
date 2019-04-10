package NowCoder.class01;

import java.util.Arrays;

// 每次从后往前审插，逐个查看是否需要交换
// 与数据规模的格式有关，如果是有序数组，则第二个for循环是不用执行的，O（N）；如果逆序，第二个for循环需要全部执行，O（N^2）
public class InsertionSort {
    public static void insertionSort(int[] arr) {
        int n = arr.length;
        if (arr == null || n < 2) {
            return;
        }
        // 从1位置开始往前插入,而非0
        for (int i = 1; i < n; i++) {
            for (int j = i - 1; j >= 0 && arr[j] > arr[j + 1]; j--) {
                swap(arr, j, j + 1);
            }
        }
    }

    public static void swap(int[] arr, int m, int n) {
        int tmp = arr[m];
        arr[m] = arr[n];
        arr[n] = tmp;
    }

    public static void main(String[] args) {
        int[] arr = new int[]{9, 8, 6, 5, 3, 1, 2};
        insertionSort(arr);
        System.out.println(Arrays.toString(arr));
    }
}
