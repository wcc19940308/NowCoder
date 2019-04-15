package NowCoder.class02;

import java.util.Arrays;

/**
 *
 * �����������⣺����һ����num���������л��ֳ�3���֣�С��num�Ĳ��֣�����num�Ĳ��֣�����num�Ĳ���
 * less,cur,more 3���±꣬�������飬���ֵС��num�����less+1�������������num��������һ�����������num�����more-1����
 * �൱�ڲ�������С�ںʹ��ڵ������м�Ĳ��־��ǵ��ڵ����򲿷�
 * ��cur == more��ʱ��ֹͣ
 *
 */
public class DutchFlag {
    // ����ұ�
    public static int[] partition(int[] arr, int lo, int hi, int num) {
        int less = lo - 1; // С������
        int more = hi + 1; // ��������
        int cur = lo;
        while (cur < more) {
            if (arr[cur] < num) {
                swap(arr, ++less, cur++);
            } else if (arr[cur] > num) {
                swap(arr, --more, cur); // ע������cur��ͬ++
            } else {
                cur++;
            }
        }
        return new int[]{less + 1, more - 1};
    }

    public static void swap(int[] arr, int m, int n) {
        int tmp = arr[m];
        arr[m] = arr[n];
        arr[n] = tmp;
    }

    public static void main(String[] args) {
        int[] arr = new int[]{1, 6, 2, 5, 7, 1, 10, 22};
        partition(arr, 0, arr.length - 1, 10);
        System.out.println(Arrays.toString(arr));

    }
}
