package NowCoder.class03;

/**
 * �й������ཻ��һϵ������
 * �ж������Ƿ��л�
 * 1.ʹ��HashSet��������������HashSet��һ������HashSet��ĳ���ڵ���ڣ���ô��������ڵ���ǻ�����ڣ���Ϊ�գ��򲻴��ڻ�
 * 2.����˫ָ��
 *
 * ����ж�2�������Ƿ��ཻ
 * 1.������1��ֵ������HashSet����������2���������2��HashSet�У���ô��һ�����ֵĽڵ����2������Ľ��㣻 ���򣬲��ཻ
 * 2.2������ֱ��¼���ȣ��Լ����һ���ڵ㣬������ͨ���ж�2����������һ���ڵ��Ƿ���ͬ���ж�2�������Ƿ���ϣ�����ཻ�Ļ��̵��������߳���֮�Ȼ��һ���߼���
 *
 * ��ˣ��ж�2�������ཻ����Ҫ���ж�2�������Ƿ��л���
 * 1.2�������޻����ж�2���޻������Ƿ��ཻ
 * 2.2�������л����ж�2���л������Ƿ��ཻ
 * 3.2������1���л���1���޻�����ô��2������һ�����ཻ
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

    // �ж������Ƿ��л�
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
        if (slow != fast) return null; // �����޻�
        fast = head;
        while (slow != fast) {
            slow = slow.next;
            fast = fast.next;
        }
        return slow; // ���ػ������
    }

    // �޻����������
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

        // �������ж�һ�£����2��������յ㲻һ���Ļ�����ô��2������һ�����뽻
        if (cur1 != cur2) {
            return null;
        }
        // cur1���������� cur2����̵�����
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
        // ע�����ﲻ�ܸ����޻�������жϣ�������ѭ����Ҫ���жϵı߽���������Ϊ������ڵ�
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
