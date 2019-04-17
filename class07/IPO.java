package NowCoder.class07;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 *
 * leetcode 502
 * һ���������飬һ���������飬k����������������Ŀ����W���������ʽ�����һ����Ŀ��ͬʱ��������������Ŀ
 * ���������ܵõ�����Ǯ
 * ʹ��2���ѣ�1��С���ѣ�1������ѣ������Ѻ�������֯��1������
 * ��ʼʱ�����ݻ��ѵĴ�С��֯С���ѣ������ж������С���ѣ���С������ȡ������С�������ʽ�W����Ŀ��������������С��֯�Ĵ������
 * ÿ��ȡ��������еĶѶ�Ԫ�أ�Ȼ�������ʽ�����ӣ���ʱ��ȡ��С�����л���С�������ʽ�W����Ŀ���������У�ֱ���ﵽk����Ŀ���ߴ����Ϊ��
 *
 */
public class IPO {

    public static class Money {
        int capital;
        int profit;

        public Money(int capital, int profit) {
            this.capital = capital;
            this.profit = profit;
        }
    }

    public static int findMaximizedCapital(int k, int W, int[] Profits, int[] Capital) {
        int n = Capital.length;
        Money[] money = new Money[n];
        for (int i = 0; i < n; i++) {
            money[i] = new Money(Capital[i], Profits[i]);
        }
        // ���ջ��Ѵ�С����
        PriorityQueue<Money> minConstQueue = new PriorityQueue<>(new Comparator<Money>() {
            @Override
            public int compare(Money o1, Money o2) {
                return o1.capital - o2.capital;
            }
        });
        // ��������Ӵ�С
        PriorityQueue<Money> maxProfitQueue = new PriorityQueue<>(new Comparator<Money>() {
            @Override
            public int compare(Money o1, Money o2) {
                return o2.profit - o1.profit;
            }
        });
        for (int i = 0; i < money.length; i++) {
            minConstQueue.offer(money[i]);
        }
        for (int i = 0; i < k; i++) {
            while (!minConstQueue.isEmpty() && minConstQueue.peek().capital <= W) {
                maxProfitQueue.offer(minConstQueue.poll());
            }
            if (maxProfitQueue.isEmpty()) {
                return W;
            }
            W += maxProfitQueue.poll().profit;
        }
        return W;
    }

    public static void main(String[] args) {
        int[] profits = new int[]{1, 2, 3};
        int[] costs = new int[]{0, 1, 1};
        int k = 2;
        int W = 0;
        System.out.println(findMaximizedCapital(k, W, profits, costs));
    }
}
