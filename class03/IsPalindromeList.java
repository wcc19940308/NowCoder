package NowCoder.class03;

/**
 *
 * 判断单链表是否为回文链表结构
 * 快慢指针，找到中点位置，反转后半部分链表，与前半部分链表一一比较，最后记得将链表恢复
 *
 */
public class IsPalindromeList {
    public static class ListNode {
        int val;
        ListNode next;
        public ListNode(int val) {
            this.val = val;
        }
    }
    // O（1）方法的方式判断
    public static boolean isPalindrome(ListNode head) {
        if (head == null || head.next == null) {
            return true;
        }
        ListNode n1 = head, n2 = head;
        boolean res = true;
        while (n2.next != null && n2.next.next != null) {
            n1 = n1.next;
            n2 = n2.next.next;
        }
        n2 = n1.next;
        n1.next = null;
        // 这里注意java值传递的坑，n1作为参数拷贝，只是在函数调用过程中改变了，还需要将返回的pre赋值给n1
        n1 = reverseList(n2, n1);
        n2 = head;
        ListNode n3 = n1;
        while (n1 != null && n2 != null) {
            if (n1.val != n2.val) {
                res = false;
                break;
            }
            n1 = n1.next;
            n2 = n2.next;
        }
        n1 = n3.next;
        n3.next = null;
        reverseList(n1, n3);
        return res;
    }

    public static ListNode reverseList(ListNode head, ListNode pre) {
        ListNode next = null;
        while (head != null) {
            next = head.next;
            head.next = pre;
            pre = head;
            head = next;
        }
        return pre;
    }


    public static void main(String[] args) {
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(2);
        ListNode node4 = new ListNode(1);
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        System.out.println(isPalindrome(node1));
        while (node1 != null) {
            System.out.println(node1.val);
            node1 = node1.next;
        }
    }
}
