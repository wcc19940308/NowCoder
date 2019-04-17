package NowCoder.class07;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 *
 * leetcode 502
 * 一个花费数组，一个利润数组，k代表最多可以做的项目数，W代表启动资金在做一个项目的同时不能做其他的项目
 * 求最后最多能得到多少钱
 * 使用2个堆，1个小根堆，1个大根堆，将花费和利润组织成1个对象
 * 开始时，根据花费的大小组织小根堆，将所有对象放入小根堆，从小根堆中取出花费小于启动资金W的项目，放入根据利润大小组织的大根堆中
 * 每次取出大根堆中的堆顶元素，然后启动资金会增加，这时再取出小根堆中花费小于启动资金W的项目放入大根堆中，直到达到k个项目或者大根堆为空
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
        // 按照花费从小到大
        PriorityQueue<Money> minConstQueue = new PriorityQueue<>(new Comparator<Money>() {
            @Override
            public int compare(Money o1, Money o2) {
                return o1.capital - o2.capital;
            }
        });
        // 按照收益从大到小
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
