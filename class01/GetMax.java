package NowCoder.class01;

/**
 *
 * �ݹ鷽�������ֵ������˼��ǳ���Ҫ���ݹ������ߺ��ұߵ����ֵ��Ȼ������ߵĽϴ��ߣ��ݹ��Ϊֻʣ1������ʱ��ֹͣ
 *
 */
public class GetMax {
    public static int getMax(int[] arr, int L, int R) {

        if (L == R) {
            return arr[L];
        }

        int mid = L + (R - L) / 2;
        int left = getMax(arr, L, mid);
        int right = getMax(arr, mid + 1, R);
        return Math.max(left, right);
    }

    public static void main(String[] args) {
        int[] arr = new int[]{121111, 1, 2, 3, 45, 65, 2323};
        System.out.println(getMax(arr, 0, arr.length - 1));
    }
}
