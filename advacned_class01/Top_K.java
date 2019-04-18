package NowCoder.advacned_class01;

import java.util.Arrays;

/**
 * 寻找无序数组中最中最小的k个数
 * topK问题，可以使用堆结构O（nlogk）或者BFPRTO（n）
 */
public class Top_K {
    public static int[] getMinKNumByHeap(int[] arr, int k) {
        int[] res = new int[k];
        for (int i = 0; i < k; i++) {
            heapInsert(res, arr[i], i);
        }
        for (int i = k; i < arr.length; i++) {
            if (arr[i] < res[0]) {
                res[0] = arr[i];
                heapify(res, 0, k);
            }
        }
        return res;
    }

    // 大顶堆
    public static void heapInsert(int[] arr, int value, int index) {
        arr[index] = value;
        while (arr[index] > arr[(index - 1) / 2]) {
            swap(arr, index, (index - 1) / 2);
            index = (index - 1) / 2;
        }
    }

    public static void heapify(int[] arr, int index, int size) {
        int left = 2 * index + 1;
        while (left < size) {
            int largest = (arr[left + 1] > arr[left]) && left + 1 < size ? left + 1 : left;
            if (arr[index] > arr[largest]) break;
            swap(arr, index, largest);
            index = largest;
            left = 2 * index + 1;
        }
    }

    public static void swap(int[] arr, int m, int n) {
        int tmp = arr[m];
        arr[m] = arr[n];
        arr[n] = tmp;
    }

    public static void main(String[] args) {
        int[] arr = {6, 9, 1, 3, 1, 2, 2, 5, 6, 1, 3, 5, 9, 7, 2, 5, 6, 1, 9};
        System.out.println(Arrays.toString(getMinKNumByHeap(arr, 3)));

    }
}
