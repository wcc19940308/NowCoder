package NowCoder.swordToOffer;

public class GetNumberOfK {
    public int GetNumberOfK(int [] array , int k) {
        int rightIndex = getRightIndex(array, k);
        if (rightIndex < 0 || array[rightIndex] != k) return 0;
        int leftIndex = getLeftIndex(array, k);
        return rightIndex - leftIndex + 1;
    }

    public int getLeftIndex(int[] array, int k) {
        int lo = 0, hi = array.length - 1;
        while (lo <= hi) {
            int mid = lo + (hi - lo) / 2;
            if (array[mid] >= k) {
                hi = mid - 1;
            } else {
                lo = mid + 1;
            }
        }
        return lo;
    }

    public int getRightIndex(int[] array, int k) {
        int lo = 0, hi = array.length - 1;
        while (lo <= hi) {
            int mid = lo + (hi - lo) / 2;
            if (array[mid] <= k) {
                lo = mid + 1;
            } else {
                hi = mid - 1;
            }
        }
        return hi;
    }
}
