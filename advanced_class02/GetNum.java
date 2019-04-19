package NowCoder.advanced_class02;

import java.util.Deque;
import java.util.LinkedList;

/**
 * ���ֵ��ȥ��СֵС�ڵ���num������������, O(N)
 * һ����(1+n)n/2�������飨�������������ģ�
 * 1.������O��n^3��
 * 2.��max(arr[i...j]) - min(arr[i...j]) <= numʱ������i...j���Ӽ�һ��Ҳ����
 * ��max(arr[i...j]) - min(arr[i...j]) > numʱ, ����i...j��������չ�ļ���Ҳһ������num
 */
public class GetNum {
    public static int getNum(int[] arr, int num) {
        if (arr.length == 0 || arr == null) {
            return 0;
        }
        Deque<Integer> maxDequeue = new LinkedList<>();
        Deque<Integer> minDequeue = new LinkedList<>();
        int lo = 0, hi = 0;
        int n = arr.length;
        int res = 0;
        while (lo < n) {
            while (hi < n) {
                if (!maxDequeue.isEmpty() && arr[maxDequeue.peekLast()] <= arr[hi]) {
                    maxDequeue.pollLast();
                }
                maxDequeue.addLast(hi);
                if (!minDequeue.isEmpty() && arr[minDequeue.peekLast()] >= arr[hi]) {
                    minDequeue.pollLast();
                }
                minDequeue.addLast(hi);
                if (maxDequeue.peekFirst() - minDequeue.peekFirst() > num) {
                    break;
                }
                hi++;
            }
            if (lo == minDequeue.peekFirst()) {
                minDequeue.pollFirst();
            }
            if (lo == maxDequeue.peekFirst()) {
                maxDequeue.pollFirst();
            }
            res += hi - lo;
            lo++;
        }
        return res;
    }
}
