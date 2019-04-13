package NowCoder.class03;


import java.util.Stack;

/**
 *
 * 用2个栈来实现队列,1个push栈，1个pop栈，push栈用于压入，pop栈用于取出，必须遵循2个原则
 * 1. push栈一次性往pop栈倒完
 * 2. 如果pop栈里面还有其他元素，此时push栈不能往pop栈倒入元素
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
