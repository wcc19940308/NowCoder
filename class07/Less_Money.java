package NowCoder.class07;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * n���˷ֽ������󻨷�����ͭǮ����
 * �����������Ӧ�ã�ÿ��ȡ2����С�ĺϲ���Ȼ��Żؼ��ϣ�ѭ����ֱ��������ֻʣ1��Ԫ�أ�С���ѵ�Ӧ�ã�
 * ÿ��ȡ2����С�ĺϲ����ٷŻأ������һ��̰�Ĳ���
 */
public class Less_Money {
    public static int lessMoney(int[] arr) {
        int res = 0;
        PriorityQueue<Integer> queue = new PriorityQueue<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o1 - o2;
            }
        });
        for (int i : arr) {
            queue.offer(i);
        }
        while (queue.size() != 1) {
            Integer poll1 = queue.poll();
            Integer poll2 = queue.poll();
            int cur = poll1 + poll2;
            res += cur;
            queue.offer(cur);
        }
        return res;
    }

    public static void main(String[] args) {
        int[] arr = new int[]{10, 20, 30};
        System.out.println(lessMoney(arr));

    }
}
