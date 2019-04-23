package NowCoder;

import java.util.Deque;
import java.util.LinkedList;

public class GetNum {
    public static int getValue(String exp) {
        int[] res = value(exp.toCharArray(), 0);
        return res[0];
    }

    // 递归求解chars中的元素从i位置开始计算所得的表达式值,res[0]为所得结果，res[1]为)的下一个位置
    public static int[] value(char[] chars, int i) {
        Deque<String> deque = new LinkedList<>();
        int[] bra = new int[2];
        int pre = 0;
        while (i < chars.length && chars[i] != ')') {
            if (chars[i] >= '0' && chars[i] <= '9') {
                pre = pre * 10 + chars[i++] - '0';
            } else if (chars[i] != '(') {
                addNum(deque, pre);
                deque.addLast(String.valueOf(chars[i++]));
                pre = 0;
            } else {
                bra = value(chars, i + 1);
                pre = bra[0];
                i = bra[1] + 1;
            }
        }
        addNum(deque, pre);
        return new int[]{getNum(deque), i};
    }

    public static void addNum(Deque<String> deque, int num) {
        if (!deque.isEmpty()) {
            String last = deque.pollLast();
            if (last.equals("+") || last.equals("-")) {
                deque.addLast(last);
            } else {
                int lastNum = Integer.valueOf(deque.pollLast());
                num = last.equals("*") ? (num * lastNum) : (lastNum / num);
            }
        }
        deque.addLast(String.valueOf(num));
    }

    public static int getNum(Deque<String> deque) {
        int res = 0;
        boolean add = true;
        while (!deque.isEmpty()) {
            String first = deque.pollFirst();
            if (first.equals("+")) {
                add = true;
            } else if (first.equals("-")) {
                add = false;
            } else {
                int num = Integer.valueOf(first);
                res += add ? num : (-num);
            }
        }
        return res;
    }

    public static void main(String[] args) {
        String s = "-3*4+5";
        System.out.println(getValue(s));
    }
}
