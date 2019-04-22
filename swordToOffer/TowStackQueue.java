package NowCoder.swordToOffer;

import org.omg.SendingContext.RunTime;

import java.util.Stack;

/**
 * ������ջʵ�ֶ���
 * ������ջ��ʵ��һ�����У���ɶ��е�Push��Pop������ �����е�Ԫ��Ϊint���͡�
 *
 * ����ԭ��
 * 1.stack1�е�Ԫ����Ҫһ���Զ�ѹ�뵽stack2
 * 2.���stack2��Ϊ�յĻ����Ȱ�stack2����
 */
public class TowStackQueue {
    Stack<Integer> stack1 = new Stack<Integer>();
    Stack<Integer> stack2 = new Stack<Integer>();

    public void push(int node) {
        stack1.push(node);
    }

    public int pop() {
        if (!stack2.isEmpty()) {
            return stack2.pop();
        } else {
            if (stack1.isEmpty()) {
                throw new RuntimeException("The queue is empty");
            } else {
                while (!stack1.isEmpty()) {
                    stack2.push(stack1.pop());
                }
                return stack2.pop();
            }
        }
    }
}
