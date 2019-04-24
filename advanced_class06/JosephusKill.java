package NowCoder.advanced_class06;

/**
 * 约瑟夫环问题
 * 每次叫到编号为m的就杀掉，然后下一个从1开始重新叫号O(m * n)
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
        // 到目前位置的计数
        int count = 0;
        // 找到环形链表中的最后一个节点
        while (last.next != head) {
            last = last.next;
        }
        // 当链表中剩余节点多余1个的时候
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
