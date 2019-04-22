package NowCoder.swordToOffer;

import org.omg.SendingContext.RunTime;

import java.util.Stack;

/**
 * 用两个栈实现队列
 * 用两个栈来实现一个队列，完成队列的Push和Pop操作。 队列中的元素为int类型。
 *
 * 两个原则：
 * 1.stack1中的元素需要一次性都压入到stack2
 * 2.如果stack2不为空的话，先把stack2弹完
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
