package NowCoder.class01;

/**
 *
 * �������Ե�����
 * �����С������һ����С������������ұ߱���ߴ����������ô����Ծ��������߱��ұߴ������
 *
 */
public class ReverseOrder {
    public static int reverseOrder(int[] arr) {
        int n = arr.length;
        if (arr == null || n < 2) {
            return 0;
        }
        return mergeSort(arr, 0, n - 1);
    }

    public static int mergeSort(int[] arr, int lo, int hi) {
        if (lo == hi) {
            return 0;
        }
        int mid = lo + (hi - lo) / 2;
        return mergeSort(arr, lo, mid) + mergeSort(arr, mid + 1, hi) + merge(arr, lo, mid, hi);
    }

    public static int merge(int[] arr, int lo, int mid,int hi) {
        int res = 0;
        int i = 0, p1 = lo, p2 = mid + 1;
        int[] p = new int[hi - lo + 1];
        while (p1 <= mid && p2 <= hi) {
            // ����Ե����������߱��ұߴ������
            res += arr[p1] > arr[p2] ? mid - p1 + 1 : 0;
            // �������Щ�����
            if (arr[p1] > arr[p2]) {
                for (int j = p1; j <= mid; j++) {
                    System.out.println(arr[j] + "," + arr[p2]);
                }
            }
//            if (arr[p1] > arr[p2]) {
//                System.out.println(arr[p1] + "," + arr[p2]);
//            }
            p[i++] = arr[p1] < arr[p2] ? arr[p1++] : arr[p2++];
        }
        while (p1 <= mid) {
            p[i++] = arr[p1++];
        }
        while (p2 <= hi) {
            p[i++] = arr[p2++];
        }
        for (i = 0; i < p.length; i++) {
            arr[lo + i] = p[i];
        }
        return res;
    }

    public static void main(String[] args) {
        int[] arr = new int[]{7, 5, 6, 4};
        int res = reverseOrder(arr);
        System.out.println(res);
    }
}
