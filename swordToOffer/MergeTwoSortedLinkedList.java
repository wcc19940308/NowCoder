package NowCoder.swordToOffer;

public class MergeTwoSortedLinkedList {
    public class ListNode {
        int val;
        ListNode next = null;

        ListNode(int val) {
            this.val = val;
        }
    }

    public ListNode Merge(ListNode list1, ListNode list2) {
        ListNode newHead = new ListNode(0);
        ListNode head = newHead;
        while (list1 != null && list2 != null) {
            int val = list1.val <= list2.val ? list1.val : list2.val;
            ListNode node = new ListNode(val);
            head.next = node;
            head = node;
            if (val == list1.val) {
                list1 = list1.next;
            } else {
                list2 = list2.next;
            }
        }
        if (list1 != null) {
            head.next = list1;
        }
        if (list2 != null) {
            head.next = list2;
        }
        return newHead.next;
    }
}
