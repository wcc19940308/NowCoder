package NowCoder.class03;

/**
 *
 * �жϵ������Ƿ�Ϊ��������ṹ
 * ����ָ�룬�ҵ��е�λ�ã���ת��벿��������ǰ�벿������һһ�Ƚϣ����ǵý�����ָ�
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
    // O��1�������ķ�ʽ�ж�
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
        // ����ע��javaֵ���ݵĿӣ�n1��Ϊ����������ֻ���ں������ù����иı��ˣ�����Ҫ�����ص�pre��ֵ��n1
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
