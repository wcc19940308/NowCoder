package NowCoder.class03;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 *
 * ��2��������ʵ��1��ջ�ṹ
 * �����ʱ�򶼽�dataջ�����Ƿ��ص�ʱ�򣬽������n-1������helpջ��data�е�����Ǹ�һ������ֵ��Ȼ��ı�data��help֮�������
 *     data          help
 *   1 2 3 4 5
 *    5            1 2 3 4
 *   1 2 3 4          5
 */
public class TwoQueueStack {
    Queue<Integer> data;
    Queue<Integer> help;

    public TwoQueueStack() {
        data = new LinkedList<>();
        help = new LinkedList<>();
    }

    public void push(int num) {
        data.offer(num);
    }

    public int pop() {
        if (data.isEmpty()) {
            throw new RuntimeException("Stack is Empty");
        }
        while (data.size() > 1) {
            help.offer(data.poll());
        }
        int res = data.poll();
        swap();
        return res;
    }

    public int peek() {
        if (data.isEmpty()) {
            throw new RuntimeException("Stack is Empty");
        }
        while (data.size() > 1) {
            help.offer(data.poll());
        }
        int res = data.poll();
        help.offer(res);
        swap();
        return res;
    }

    public void swap() {
        Queue<Integer> tmp = data;
        data = help;
        help = tmp;
    }
}
