package NowCoder.class03;

import java.util.HashMap;
import java.util.Map;

/**
 *
 * ��������ĸ��ƣ� ��Ҫ�ǽ���Ͻڵ���½ڵ�Ķ�Ӧ��ϵ�������ǹ�ϣ������ֱ���ýṹ��ϵ��ʡ�ռ�
 * 1.���ù�ϣ����ԭʼ�����ÿ���ڵ���Ϊ������Ӧ�ģ���ÿ��ԭʼ����Ľڵ㿽��һ�����ɵĽڵ���Ϊֵ���д洢����ô���ı����ù�ϵ��ʱ��ֻ��Ҫ֪���������ù�ϵ����
 * ʱ�临�Ӷ�ΪO��N��
 * 2.��1֪����������Ҫ���ù�ϣ����������Ͻڵ�֮��Ķ�Ӧ��ϵ����ˣ����ǽ��������ڵ������뵽ԭ�����У����½ڵ����Ͻڵ�֮��ļ��Ϊ1���Դ��������ϣ���м�
 * ��ֵ֮��Ķ�Ӧ��ϵ��ͬ���ģ��½ڵ���Ը���-1ǰ��λ�õ��Ͻڵ�����ù�ϵ��ȷ����������ù�ϵ������½ڵ�Ͽ�������֯����
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
        // ���������Ĳ���
        while (cur != null) {
            next = cur.next;
            cur.next = new ListNode(cur.val);
            cur.next.next = next;
            cur = next;
        }

        // ��������������ù�ϵ
        cur = head;
        ListNode curCopy = null;
        // һ��ȡ2���ڵ㣬1���Ͻڵ㣬1���½ڵ�
        while (cur != null) {
            next = cur.next.next;
            curCopy = cur.next;
            // �½ڵ��rand�����Ͻڵ��randָ�����һ���ڵ�
            curCopy.rand = cur.rand != null ? cur.rand.next : null;
            cur = next;
        }

        // �ؽ��½ڵ�
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
