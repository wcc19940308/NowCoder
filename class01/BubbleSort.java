package NowCoder.class01;

import java.util.Arrays;

public class BubbleSort {
    public static void bubbleSort(int[] arr) {
        int n = arr.length;
        if (arr == null || n < 2) {
            return;
        }
        for (int i = n - 1; i > 0; i--) {
            for (int j = 0; j < i; j++) {
                if (arr[j] > arr[j + 1]) {
                    swap(arr, j, j + 1);
                }
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
        bubbleSort(arr);
        System.out.println(Arrays.toString(arr));
    }
}
