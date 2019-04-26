package NowCoder.swordToOffer;

/**
 * 调整数组顺序使奇数位于偶数前面:
 * 输入一个整数数组，实现一个函数来调整该数组中数字的顺序，使得所有的奇数位于数组的前半部分，
 * 所有的偶数位于数组的后半部分，并保证奇数和奇数，偶数和偶数之间的相对位置不变。
 */
public class ReOrderArray {
    // 插入排序或者辅助数组
    public void reOrderArray(int [] array) {
        int n = array.length;
        for (int i = 1; i < n; i++) {
            for (int j = 1; j < i; j++) {
                if (array[j] % 2 != 0 && array[j - 1] % 2 == 0) {
                    swap(array, j, j - 1);
                }
            }
        }
    }

    public void swap(int[] arr, int m, int n) {
        int tmp = arr[m];
        arr[m] = arr[n];
        arr[n] = tmp;
    }
}
