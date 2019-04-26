package NowCoder.swordToOffer;

public class FindFirstCommonNode {
    public static class ListNode {
        int val;
        ListNode next = null;

        ListNode(int val) {
            this.val = val;
        }
    }

    public static ListNode FindFirstCommonNode(ListNode pHead1, ListNode pHead2) {
        if (pHead1 == null || pHead2 == null) {
            return null;
        }
        ListNode p1 = pHead1, p2 = pHead2;
        int count = 0;
        while (p1 != null) {
            p1 = p1.next;
            count++;
        }
        while (p2 != null) {
            p2 = p2.next;
            count--;
        }
        p1 = count > 0 ? pHead1 : pHead2; // 让p1指向长的那个链表
        p2 = p1 == pHead1 ? pHead2 : pHead1;
        count = Math.abs(count);
        while (count-- > 0) {
            p1 = p1.next;
        }
        while (p1 != p2) {
            p1 = p1.next;
            p2 = p2.next;
        }
        return p1;
    }

    public static void main(String[] args) {
        ListNode l1 = new ListNode(1);
        ListNode l2 = new ListNode(2);
        ListNode l3 = new ListNode(3);
        l1.next = l3;
        l2.next = l3;
        System.out.println(FindFirstCommonNode(l1,l2).val);
    }
}
