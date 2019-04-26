package NowCoder.swordToOffer;

public class FindKthToTail {

    public class ListNode {
        int val;
        ListNode next = null;
        ListNode(int val) {
            this.val = val;
        }
    }
    public ListNode FindKthToTail(ListNode head,int k) {
        if (head == null || k <= 0) {
            return null;
        }
        ListNode p1 = head;
        int len = 0;
        while (p1 != null) {
            p1 = p1.next;
            len++;
        }
        if (len < k) return null;
        p1 = head;
        ListNode p2 = head;
        while (k-- > 0) {
            p1 = p1.next;
        }
        while (p1 != null) {
            p1 = p1.next;
            p2 = p2.next;
        }
        return p2.next;
    }
}
