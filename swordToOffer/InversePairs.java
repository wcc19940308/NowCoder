package NowCoder.swordToOffer;

public class InversePairs {
    private static int[] tmp;
    public static int InversePairs(int [] array) {
        tmp = new int[array.length];
        int res = mergeSort(array, 0, array.length - 1);
        res %= 1000000007;
        return res;
    }

    public static int mergeSort(int[] array, int lo, int hi) {
        if (lo == hi) return 0;
        int mid = lo + (hi - lo) / 2;
        return mergeSort(array, lo, mid) + mergeSort(array, mid + 1, hi) + merge(array, lo, mid, hi);
    }

    public static int merge(int[] array, int lo, int mid, int hi) {
        int p1 = lo, p2 = mid + 1;
        int res = 0;
        int i = 0;
        while (p1 <= mid && p2 <= hi) {
            if (array[p1] > array[p2]) {
                res = (res + mid - p1 + 1) % 1000000007;
            }
            tmp[i++] = array[p1] > array[p2] ? array[p2++] : array[p1++];
        }
        while (p1 <= mid) {
            tmp[i++] = array[p1++];
        }
        while (p2 <= hi) {
            tmp[i++] = array[p2++];
        }
        for (int j = 0; j < hi - lo; j++) {
            array[lo + j] = tmp[j];
        }
        return  res;
    }

    public static void main(String[] args) {
        int[] arr = new int[]{1, 2, 3, 4, 5, 6, 7, 0};
        System.out.println(InversePairs(arr));
    }
}
