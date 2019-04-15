package NowCoder.class03;

import java.util.HashMap;
import java.util.Map;

/**
 *
 * 复杂链表的复制， 主要是解决老节点和新节点的对应关系，不管是哈希表，还是直接用结构关系节省空间
 * 1.利用哈希表，将原始链表的每个节点作为键，相应的，将每个原始链表的节点拷贝一份生成的节点作为值进行存储，那么，改变引用关系的时候只需要知道键的引用关系即可
 * 时间复杂度为O（N）
 * 2.由1知道，我们需要利用哈希表来解决新老节点之间的对应关系，因此，考虑将各拷贝节点间隔插入到原链表中，让新节点与老节点之间的间隔为1，以此来代替哈希表中键
 * 与值之间的对应关系，同样的，新节点可以根据-1前面位置的老节点的引用关系来确定自身的引用关系，最后将新节点断开重新组织即可
 *
 */
public class CopyListWithRand {
    public static class ListNode {
        int val;
        ListNode next;
        ListNode rand;
        public ListNode(int val) {
            this.val = val;
        }
    }

    public static ListNode copyListWithRand1(ListNode head) {
        Map<ListNode, ListNode> map = new HashMap<>();
        ListNode cur = head;
        while (cur != null) {
            map.put(cur, new ListNode(cur.val));
            cur = cur.next;
        }
        cur = head;
        while (cur != null) {
            map.get(cur).next = map.get(cur.next);
            map.get(cur).rand = map.get(cur.rand);
        }
        return map.get(head);
    }

    public static ListNode copyListWithRand2(ListNode head) {
        if (head == null) {
            return null;
        }
        ListNode cur = head;
        ListNode next;
        // 完成新链表的插入
        while (cur != null) {
            next = cur.next;
            cur.next = new ListNode(cur.val);
            cur.next.next = next;
            cur = next;
        }

        // 处理新链表的引用关系
        cur = head;
        ListNode curCopy = null;
        // 一次取2个节点，1个老节点，1个新节点
        while (cur != null) {
            next = cur.next.next;
            curCopy = cur.next;
            // 新节点的rand就是老节点的rand指向的下一个节点
            curCopy.rand = cur.rand != null ? cur.rand.next : null;
            cur = next;
        }

        // 重建新节点
        cur = head;
        ListNode res = head.next;
        while (cur != null) {
            next = cur.next.next;
            curCopy = cur.next;
            cur.next = next;
            curCopy.next = next != null ? next.next : null;
            cur = next;
        }
        return res;
    }
}
