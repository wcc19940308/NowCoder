package NowCoder.swordToOffer;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * ��β��ͷ��ӡ����
 * ����һ������������ֵ��β��ͷ��˳�򷵻�һ��ArrayList��
 */
public class PrintListFromTailToHead {
    public class ListNode {
        int val;
        ListNode next = null;
        ListNode(int val) {
            this.val = val;
        }
    }
    public ArrayList<Integer> printListFromTailToHead(ListNode listNode) {
        List<Integer> list = new ArrayList<>();
        if (listNode == null) {
            return (ArrayList<Integer>) list;
        }
        Stack<Integer> stack = new Stack<>();
        while (listNode != null) {
            stack.push(listNode.val);
            listNode = listNode.next;
        }
        while (!stack.isEmpty()) {
            list.add(stack.pop());
        }
        return (ArrayList<Integer>) list;
    }
}
