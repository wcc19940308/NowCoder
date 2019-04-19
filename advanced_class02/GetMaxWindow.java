package NowCoder.advanced_class02;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 * 生成窗口最大值数组
 * 维护双端队列头结点不过期，并且队列中的索引值对应的值降序即可
 */
public class GetMaxWindow {
    public static ArrayList<Integer> maxInWindows(int [] num, int size){
        ArrayList<Integer> list = new ArrayList<>();
        if (size == 0) {
            return list;
        }
        Deque<Integer> deque = new LinkedList<>();
        for (int i = 0; i < num.length; i++) {
            while (!deque.isEmpty() && num[deque.peekLast()] <= num[i]) {
                deque.pollLast();
            }
            deque.addLast(i);
            // 如果头结点过期了
            if (deque.peekFirst() <= i - size) {
                deque.pollFirst();
            }
            if (i >= size - 1) {
                list.add(num[deque.peekFirst()]);
            }
        }
        return list;
    }

    public static void main(String[] args) {
        int[] arr = new int[]{2, 3, 4, 2, 6, 2, 5, 1};
        int size = 3;
        System.out.println(maxInWindows(arr,size));
    }
}
