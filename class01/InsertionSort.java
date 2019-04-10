package NowCoder.class01;

import java.util.Arrays;

// ÿ�δӺ���ǰ��壬����鿴�Ƿ���Ҫ����
// �����ݹ�ģ�ĸ�ʽ�йأ�������������飬��ڶ���forѭ���ǲ���ִ�еģ�O��N����������򣬵ڶ���forѭ����Ҫȫ��ִ�У�O��N^2��
public class InsertionSort {
    public static void insertionSort(int[] arr) {
        int n = arr.length;
        if (arr == null || n < 2) {
            return;
        }
        // ��1λ�ÿ�ʼ��ǰ����,����0
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
