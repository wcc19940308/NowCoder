package NowCoder.advanced_class06;

/**
 * Լɪ������
 * ÿ�νе����Ϊm�ľ�ɱ����Ȼ����һ����1��ʼ���½к�O(m * n)
 */
public class JosephusKill {
    public class Node {
        public int val;
        public Node next;

        public Node(int val) {
            this.val = val;
        }
    }

    public Node josephusKil(Node head, int m) {
        if (head == null || head.next == null || m < 1) {
            return head;
        }
        Node last = head;
        // ��Ŀǰλ�õļ���
        int count = 0;
        // �ҵ����������е����һ���ڵ�
        while (last.next != head) {
            last = last.next;
        }
        // ��������ʣ��ڵ����1����ʱ��
        while (last != head) {
            if (++count == m) {
                last.next = head.next;
                count = 0;
            } else {
                last = last.next;
            }
            head = last.next;
        }
        return head;
     }

    public static void main(String[] args) {

    }
}
