package NowCoder.class07;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * n个人分金条，求花费最少铜钱数量
 * 哈夫曼编码的应用，每次取2个最小的合并，然后放回集合，循环，直至集合中只剩1个元素（小根堆的应用）
 * 每次取2个最小的合并，再放回，这就是一种贪心策略
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
