package NowCoder.class02;

import java.util.Arrays;

/**
 *
 * ������ţ�С�ڵ���num�ķ�����ߣ����ڵķ����ұ�
 * ʹ�ú��������Ż���С��num�ķ���ߣ�����num�ķ��м䣬���ڵķ����ұߣ��ݹ����������֣�����ʡȥ�м䲿�ֵ���������������
 * �������ÿ��ֻȷ��1��������˺�����������Ż�Ч��
 *
 * ������Ŷ�������������Ч���������룬����������������ǵ�һ�����������һ��������ôÿ�λ��ֺ��ʣ��T��n-1�����˻���O��N^2��
 * ��ѡȡ�����պ������һ�������ߵ�һ���������������ѡȡ
 *
 */
public class QucikSort {
    public static void quickSort(int[] arr, int lo, int hi) {
        // ������жϿ��Ա�ֻ֤�з��ص�����Ч�����ʱ��Ż���У����lo>hi�򲻻����
        if (lo < hi) {
            swap(arr, lo + (int) (Math.random() * (hi - lo + 1)), hi);
            int[] res = partition(arr, lo, hi);
            quickSort(arr, lo, res[0] - 1);
            quickSort(arr, res[1] + 1, hi);
        }
    }

    public static int[] partition(int[] arr, int lo, int hi) {
        int less = lo - 1;
        // ע�����ﲻ��hi+1,��һ��ʼarr[hi]�Ѿ�����more�ķ�Χ���ˣ��������Ҫ����һ��swap
        // ��Ȼ����ʹ��more = hi + 1��ʡȥ����swap�����ǻ���Ҫһ��int num = arr[hi]
        int more = hi + 1;
        //int num = arr[hi];
        int cur = lo;
        while (cur < more) {
            // �����ǽ������е����һ��Ԫ��ѡ�����
            if (arr[cur] < arr[hi]) {
                swap(arr, ++less, cur++);
            } else if (arr[cur] > arr[hi]) {
                swap(arr, --more, cur);
            } else {
                cur++;
            }
        }
        // ��Ϊmore�ǲ�����ǰ���ŵģ�����ֻҪ��hi��more����λ�ã����ɰ�num�ŵ��м�������
        swap(arr, more, hi);
        // ���ص��������ͷ��β��λ��
        return new int[]{less + 1, more};
    }

    public static void swap(int arr[], int m, int n) {
        int tmp = arr[m];
        arr[m] = arr[n];
        arr[n] = tmp;
    }

    public static void main(String[] args) {
        int[] arr = new int[]{9, 8, 6, 5, 3, 1, 2};
        quickSort(arr, 0, arr.length - 1);
        System.out.println(Arrays.toString(arr));
    }
}
