package NowCoder.advanced_class02;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 * ���ɴ������ֵ����
 * ά��˫�˶���ͷ��㲻���ڣ����Ҷ����е�����ֵ��Ӧ��ֵ���򼴿�
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
            // ���ͷ��������
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
