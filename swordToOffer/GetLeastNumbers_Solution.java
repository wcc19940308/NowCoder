package NowCoder.swordToOffer;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.PriorityQueue;

public class GetLeastNumbers_Solution {
    public ArrayList<Integer> GetLeastNumbers_Solution(int[] input, int k) {
        ArrayList<Integer> list = new ArrayList<>();
        if (input == null || input.length == 0 || k < 0 || k > input.length) {
            return list;
        }
        PriorityQueue<Integer> queue = new PriorityQueue<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2 - o1;
            }
        });
        for (int i = 0; i < k; i++) {
            queue.offer(input[i]);
        }
        for (int i = k; i < input.length; i++) {
            if (input[i] < queue.peek()) {
                queue.poll();
                queue.offer(input[i]);
            }
        }

        while (!queue.isEmpty()) {
            list.add(queue.poll());
        }
        return list;
    }
}
