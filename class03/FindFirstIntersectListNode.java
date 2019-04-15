package NowCoder.class03;

/**
 * 有关链表相交的一系列问题
 * 判断链表是否有环
 * 1.使用HashSet，遍历链表，放入HashSet，一旦发现HashSet中某个节点存在，那么代表这个节点就是环的入口；若为空，则不存在环
 * 2.快慢双指针
 *
 * 如何判断2个链表是否相交
 * 1.将链表1的值都放入HashSet，遍历链表2，如果链表2在HashSet中，那么第一个出现的节点就是2个链表的交点； 否则，不相交
 * 2.2个链表分别记录长度，以及最后一个节点，可以先通过判断2个链表的最后一个节点是否相同来判断2个链表是否相较，如果相交的话短的链表再走长度之差步然后一起走即可
 *
 * 因此，判断2个链表相交，需要先判断2个链表是否有环：
 * 1.2个链表都无环，判断2个无环链表是否相交
 * 2.2个链表都有环，判断2个有环链表是否相交
 * 3.2个链表1个有环，1个无环，那么这2个链表一定不相交
 */
public class FindFirstIntersectListNode {
    public static class ListNode {
        int val;
        ListNode next;
        public ListNode(int val) {
            this.val = val;
        }
    }

    public static ListNode getIntersectListNode(ListNode head1, ListNode head2) {
        ListNode loop1 = findLoop(head1);
        ListNode loop2 = findLoop(head2);
        if (loop1 == null && loop2 == null) {
            return noLoop(head1, head2);
        } else if (loop1 != null && loop2 != null) {
            return bothLoop(head1, head2);
        } else {
            return null;
        }

    }

    // 判断链表是否有环
    public static ListNode findLoop(ListNode head) {
        if (head == null || head.next == null) {
            return null;
        }
        ListNode slow = head, fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast) {
                break;
            }
        }
        if (slow != fast) return null; // 链表无环
        fast = head;
        while (slow != fast) {
            slow = slow.next;
            fast = fast.next;
        }
        return slow; // 返回环的入口
    }

    // 无环链表找入口
    public static ListNode noLoop(ListNode head1, ListNode head2) {
        if (head1 == null || head2 == null) {
            return null;
        }
        ListNode cur1 = head1, cur2 = head2;
        int n = 0;
        while (cur1 != null) {
            n++;
            cur1 = cur1.next;
        }
        while (cur2 != null) {
            n--;
            cur2 = cur2.next;
        }

        // 这里再判断一下，如果2个链表的终点不一样的话，那么这2个链表一定不想交
        if (cur1 != cur2) {
            return null;
        }
        // cur1代表长的链表， cur2代表短的链表
        cur1 = n > 0 ? head1 : head2;
        cur2 = cur1 == head1 ? head2 : head1;
        n = Math.abs(n);
        while (n-- > 0) {
            cur1 = cur1.next;
        }
        while (cur1 != cur2) {
            cur1 = cur1.next;
            cur2 = cur2.next;
        }
        return cur1;
    }

    public static ListNode bothLoop(ListNode head1, ListNode head2) {
        ListNode loop1 = findLoop(head1);
        ListNode loop2 = findLoop(head2);
        ListNode cur1 = null;
        ListNode cur2 = null;
        // 注意这里不能复用无环链表的判断，可能死循环，要把判断的边界条件设置为环的入口点
        if (loop1 == loop2) {
            cur1 = head1;
            cur2 = head2;
            int n = 0;
            while (cur1 != loop1) {
                n++;
                cur1 = cur1.next;
            }
            while (cur2 != loop2) {
                n--;
                cur2 = cur2.next;
            }
            cur1 = n > 0 ? head1 : head2;
            cur2 = cur1 == head1 ? head2 : head1;
            n = Math.abs(n);
            while (n-- > 0) {
                cur1 = cur1.next;
            }
            while (cur1 != cur2) {
                cur1 = cur1.next;
                cur2 = cur2.next;
            }
            return cur1;
        } else {
            cur1 = loop1.next;
            while (cur1 != loop1) {
                if (cur1 == loop2) {
                    return loop1;
                }
                cur1 = cur1.next;
            }
            return null;
        }
    }


    public static void main(String[] args) {
        // 1->2->3->4->5->6->7->null
        ListNode head1 = new ListNode(1);
        head1.next = new ListNode(2);
        head1.next.next = new ListNode(3);
        head1.next.next.next = new ListNode(4);
        head1.next.next.next.next = new ListNode(5);
        head1.next.next.next.next.next = new ListNode(6);
        head1.next.next.next.next.next.next = new ListNode(7);

        // 0->9->8->6->7->null
        ListNode head2 = new ListNode(0);
        head2.next = new ListNode(9);
        head2.next.next = new ListNode(8);
        head2.next.next.next = head1.next.next.next.next.next; // 8->6
        System.out.println(getIntersectListNode(head1, head2).val);

        // 1->2->3->4->5->6->7->4...
        head1 = new ListNode(1);
        head1.next = new ListNode(2);
        head1.next.next = new ListNode(3);
        head1.next.next.next = new ListNode(4);
        head1.next.next.next.next = new ListNode(5);
        head1.next.next.next.next.next = new ListNode(6);
        head1.next.next.next.next.next.next = new ListNode(7);
        head1.next.next.next.next.next.next = head1.next.next.next; // 7->4

        // 0->9->8->2...
        head2 = new ListNode(0);
        head2.next = new ListNode(9);
        head2.next.next = new ListNode(8);
        head2.next.next.next = head1.next; // 8->2
        System.out.println(getIntersectListNode(head1, head2).val);

        // 0->9->8->6->4->5->6..
        head2 = new ListNode(0);
        head2.next = new ListNode(9);
        head2.next.next = new ListNode(8);
        head2.next.next.next = head1.next.next.next.next.next; // 8->6
        System.out.println(getIntersectListNode(head1, head2).val);

    }



}
