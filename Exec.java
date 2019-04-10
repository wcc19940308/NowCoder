package NowCoder;

import java.util.Arrays;

public class Exec {

    public static void heapSort(int[] arr) {
        int size = arr.length;
        for (int i = 0; i < size; i++) {
            heapInsert(arr, i);
        }
        swap(arr, 0, --size);
        while (size > 0) {
            heapify(arr, 0, size);
            swap(arr, 0, --size);
        }
    }

    public static void heapInsert(int[] arr, int index) {
        while (arr[index] > arr[(index - 1) / 2]) {
            swap(arr, index, (index - 1) / 2);
            index = (index - 1) / 2;
        }
    }

    public static void heapify(int[] arr, int index, int size) {
        int left = index * 2 + 1;
        while (left < size) {
            int largest = left + 1 < size && arr[left + 1] > arr[left]
                    ? left + 1
                    : left;
            if (arr[index] > arr[largest]) break;
            swap(arr, index, largest);
            index = largest;
            left = index * 2 + 1;
        }
    }

    public static void swap(int[] arr, int m, int n) {
        int tmp = arr[m];
        arr[m] = arr[n];
        arr[n] = tmp;
    }

    public static void main(String[] args) {
        int[] arr = new int[]{9, 8, 6, 5, 3, 1, 2};
        heapSort(arr);
        System.out.println(Arrays.toString(arr));
    }
}
