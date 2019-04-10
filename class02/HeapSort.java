package NowCoder.class02;

import java.util.Arrays;

/**
 *
 * 堆排序，数组的物理存储结构，完全二叉树的逻辑存储结构
 * 贪心问题
 *
 */
public class HeapSort {
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

    // 上滤
    public static void heapInsert(int[] arr, int index) {
        // 如果到了0位置，那么自然也不满足循环的条件，因此会跳出循环
        while (arr[index] > arr[(index - 1) / 2]) {
            swap(arr, index, (index - 1) / 2);
            index = (index - 1) / 2;
        }
    }

    // 下滤， 0-size-1的位置形成堆，由于index的值发生改变需要下滤，即size用于表示标识是否越界
    public static void heapify(int[] arr, int index, int size) {
        int left = 2 * index + 1;
        while (left < size) {
            // 取出左右孩子中大的那个下标
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
