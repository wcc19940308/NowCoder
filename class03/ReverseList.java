package NowCoder.class03;

/**
 * 反转单向链表，反转双向链表
 */
public class ReverseList {
    public static class ListNode {
        int val;
        ListNode next;
        public ListNode(int val) {
            this.val = val;
        }
    }

    public static ListNode reverseSingleList(ListNode head) {
        ListNode pre = null, next = null;
        while (head != null) {
            next = head.next;
            head.next = pre;
            pre = head;
            head = next;
        }
        return pre;
    }

    public static class DoubleListNode {
        int val;
        DoubleListNode pre;
        DoubleListNode next;

        public DoubleListNode(int val) {
            this.val = val;
        }
    }

    public static DoubleListNode reverseDoubleList(DoubleListNode head) {
        DoubleListNode pre = null, next = null;
        while (head != null) {
            next = head.next;
            head.next = pre;
            head.pre = next;
            pre = head;
            head = next;
        }
        return pre;
    }

    public static void main(String[] args) {
        DoubleListNode node1 = new DoubleListNode(1);
        DoubleListNode node2 = new DoubleListNode(2);
        DoubleListNode node3 = new DoubleListNode(3);
        node1.next = node2;
        node2.pre = node1;
        node2.next = node3;
        node3.pre = node2;
        DoubleListNode doubleListNode = reverseDoubleList(node1);
        while (doubleListNode != null) {
            System.out.println(doubleListNode.val);
            doubleListNode = doubleListNode.next;
        }
    }
}
