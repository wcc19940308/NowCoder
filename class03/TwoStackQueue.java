package NowCoder.class03;


import java.util.Stack;

/**
 *
 * ��2��ջ��ʵ�ֶ���,1��pushջ��1��popջ��pushջ����ѹ�룬popջ����ȡ����������ѭ2��ԭ��
 * 1. pushջһ������popջ����
 * 2. ���popջ���滹������Ԫ�أ���ʱpushջ������popջ����Ԫ��
 *
 */
public class TwoStackQueue {
    Stack<Integer> pushStack;
    Stack<Integer> popStack;

    public TwoStackQueue() {
        pushStack = new Stack<>();
        popStack = new Stack<>();
    }

    public void push(int num) {
        pushStack.push(num);
    }

    public int pop() {
        if (pushStack.isEmpty() && popStack.isEmpty()) {
            throw new RuntimeException("The Stack is empty");
        } else if (popStack.isEmpty()) {
            while (!pushStack.isEmpty()) {
                popStack.push(pushStack.pop());
            }
        }
        return popStack.pop();
    }

    public int peek() {
        if (pushStack.isEmpty() && popStack.isEmpty()) {
            throw new RuntimeException("The Stack is empty");
        } else if (popStack.isEmpty()) {
            while (!pushStack.isEmpty()) {
                popStack.push(pushStack.pop());
            }
        }
        return popStack.peek();
    }
}
