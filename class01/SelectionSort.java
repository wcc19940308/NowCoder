package NowCoder.class01;

import java.util.Arrays;

// 0-N-1λ������С����0λ�ý�����1-N-1λ������С����1λ�ý��� ������
public class SelectionSort {
    public static void selectionSort(int[] arr) {
        int n = arr.length;
        if (arr == null || n < 2) {
            return;
        }
        // �ҵ�iλ������С�����±�
        for (int i = 0; i < n; i++) {
            int minIndex = i;
            for (int j = i + 1; j < n; j++) {
                minIndex = arr[j] < arr[minIndex] ? j : minIndex;
            }
            swap(arr, i, minIndex);
        }
    }

    public static void swap(int[] arr, int m, int n) {
        int tmp = arr[m];
        arr[m] = arr[n];
        arr[n] = tmp;
    }

    public static void main(String[] args) {
        int[] arr = new int[]{9, 8, 6, 5, 3, 1, 2};
        selectionSort(arr);
        System.out.println(Arrays.toString(arr));
    }
}
