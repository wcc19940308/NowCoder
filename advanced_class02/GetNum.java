package NowCoder.advanced_class02;

import java.util.Deque;
import java.util.LinkedList;

/**
 * 最大值减去最小值小于等于num的子数组数量, O(N)
 * 一共有(1+n)n/2个子数组（子数组是连续的）
 * 1.暴力解O（n^3）
 * 2.当max(arr[i...j]) - min(arr[i...j]) <= num时，对于i...j的子集一定也满足
 * 当max(arr[i...j]) - min(arr[i...j]) > num时, 对于i...j向两边扩展的集合也一定大于num
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
