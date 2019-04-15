package NowCoder.class03;

/**
 *
 * 将单链表按某值分成左边小，中间相等，右边大的形式
 * 1.荷兰国旗问题， 将链表节点存放在数组中，通过荷兰国旗问题对数组求解，然后重新组织成链表即可,但是荷兰国旗问题不具有稳定性，并且空间复杂度为O（N）
 * 2.O（1）的空间复杂度，利用6个变量，分别记录小于，等于，大于的头尾节点，最后串起来即可，由于是按照顺序扫描的，因此具备稳定性
 *
 */

public class ListPartition {
    public static class ListNode {
        int val;
        ListNode next;
        public ListNode(int val) {
            this.val = val;
        }
    }

    public static ListNode listPartition1(ListNode head, int num) {
        int cnt = 0;
        ListNode p = head;
        while (p != null) {
            p = p.next;
            cnt++;
        }
        ListNode[] arr = new ListNode[cnt]; // 荷兰国旗问题的数组
        int index = 0;
        while (head != null) {
            arr[index++] = head;
            head = head.next;
        }
        int lo = -1;
        int hi = cnt;
        int cur = lo + 1;
        while (cur < hi) {
            if (arr[cur].val < num) {
                swap(arr, ++lo, cur++);
            } else if (arr[cur].val > num) {
                swap(arr, --hi, cur);
            } else {
                cur++;
            }
        }
        ListNode node = arr[0];
        head = node;
        for (int i = 1; i < arr.length; i++) {
            node.next = arr[i];
            node = node.next;
        }
        node.next = null;
        return head;
    }

    public static ListNode listPartition2(ListNode head, int pivot) {
        ListNode smallHead = null;
        ListNode smallTail = null;
        ListNode equalHead = null;
        ListNode equalTail = null;
        ListNode bigHead = null;
        ListNode bigTail = null;
        while (head != null) {
            ListNode next = head.next;
            head.next = null;
            if (head.val < pivot) {
                if (smallHead == null) {
                    smallHead = head;
                    smallTail = head;
                } else {
                    smallTail.next = head;
                    smallTail = head;
                }
            } else if (head.val == pivot) {
                if (equalHead == null) {
                    equalHead = head;
                    equalTail = head;
                } else {
                    equalTail.next = head;
                    equalTail = head;
                }
            } else {
                if (bigHead == null) {
                    bigHead = head;
                    bigTail = head;
                } else {
                    bigTail.next = head;
                    bigTail = head;
                }
            }
            head = next;
        }

        // 开始将3个链表连接起来
        if (smallHead != null) {
            smallTail.next = equalHead == null ? null : equalHead;
        }
        if (equalHead != null) {
            equalTail.next = bigHead == null ? null : bigHead;
        }
        return smallHead;

    }

    public static void swap(ListNode[] arr, int m, int n) {
        ListNode tmp = arr[m];
        arr[m] = arr[n];
        arr[n] = tmp;
    }

    public static void main(String[] args) {
        ListNode head1 = new ListNode(10);
        ListNode head2 = new ListNode(1);
        ListNode head3 = new ListNode(20);
        ListNode head4 = new ListNode(35);
        head1.next = head2;
        head2.next = head3;
        head3.next = head4;
        ListNode res = listPartition2(head1, 10);
        while (res != null) {
            System.out.println(res.val);
            res = res.next;
        }
    }
}
