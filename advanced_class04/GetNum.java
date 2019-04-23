package NowCoder.advanced_class04;

import java.util.Deque;
import java.util.LinkedList;

/**
 * ��ʽ�ַ�����ֵ
 * ͨ�������ӹ��̣����ؽ��������Ӧ��λ�ü������¼���
 */
public class GetNum {
    public static int getValue(String exp) {
        return value(exp.toCharArray(), 0)[0];
    }

    public static int[] value(char[] chars, int i) {
        Deque<String> deq = new LinkedList<>();
        int pre = 0;
        int[] bra = null;
        while (i < chars.length && chars[i] != ')') {
            if (chars[i] >= '0' & chars[i] <= '9') {
                pre = pre * 10 + chars[i++] - '0';
            } else if (chars[i] != '(') {
                // һ���Լ���һ�������ַ��ͷ����ַ��������ͷ�Ǹ��ŵĻ������0 -
                addNum(deq, pre);
                deq.addLast(String.valueOf(chars[i++]));
                pre = 0;
            } else {
                bra = value(chars, i + 1);
                // �������м���Ľ������
                pre = bra[0];
                // �������ŵ�λ�ü�����ʼ����
                i = bra[1] + 1;
            }
        }
        addNum(deq, pre);
        return new int[]{getNum(deq), i};
    }

    public static void addNum(Deque<String> deque, int num) {
        if (!deque.isEmpty()) {
            int cur = 0;
            String top = deque.pollLast();
            if (top.equals("+") || top.equals("-")) {
                deque.addLast(top);
            } else {
                cur = Integer.valueOf(deque.pollLast());
                num = top.equals("*") ? (cur * num) : (cur / num);
            }
        }
        deque.addLast(String.valueOf(num));
    }

    // �����������,������ֻʣ��+-���ȼ������ݣ����㲢�ҷ��ؽ��
    public static int getNum(Deque<String> deque) {
        int res = 0;
        boolean add = true;
        String cur = null;
        int num = 0;
        while (!deque.isEmpty()) {
            cur = deque.pollFirst();
            if (cur.equals("+")) {
                add = true;
            } else if (cur.equals("-")) {
                add = false;
            } else {
                num = Integer.valueOf(cur);
                res += add ? num : (-num);
            }
        }
        return res;
    }

    public static void main(String[] args) {
        String s = "(-3*4)+5";
        int value = getValue(s);
        System.out.println(value);
    }
}
