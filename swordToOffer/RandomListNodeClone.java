package NowCoder.swordToOffer;

import java.util.HashMap;
import java.util.Map;

/**
 * ��������ĸ���
 * ��Ŀ����
 * ����һ����������ÿ���ڵ����нڵ�ֵ���Լ�����ָ�룬һ��ָ����һ���ڵ㣬��һ������ָ��ָ������һ���ڵ㣩�����ؽ��Ϊ���ƺ��������head��
 * ��ע�⣬���������벻Ҫ���ز����еĽڵ����ã�������������ֱ�ӷ��ؿգ�
 *
 * 1.HashMap,ԭ����ڵ��������ڵ�һһ��Ӧ
 * 2.O��1���ռ临�Ӷ�
 */
public class RandomListNodeClone {
    public static class RandomListNode {
        int label;
        RandomListNode next = null;
        RandomListNode random = null;

        RandomListNode(int label) {
            this.label = label;
        }
    }
    public RandomListNode Clone(RandomListNode pHead){
        Map<RandomListNode, RandomListNode> map = new HashMap<>();
        RandomListNode p = pHead;
        while (pHead != null) {
            RandomListNode newHead = new RandomListNode(pHead.label);
            map.put(pHead, newHead);
            pHead = pHead.next;
        }
        for (RandomListNode node : map.keySet()) {
            map.get(node).next = map.get(node.next);
            map.get(node).random = map.get(node.random);
        }
        return map.get(p);
    }

    public RandomListNode Clone2(RandomListNode pHead) {
        if (pHead == null) return null;
        RandomListNode p = pHead;
        // ���²�����ͷ������ԭ����
        while (p != null) {
            RandomListNode next = p.next;
            RandomListNode newHead = new RandomListNode(p.label);
            newHead.next = next;
            p.next = newHead;
            p = next;
        }

        // ����Randomָ��
        p = pHead;
        while (p != null) {
            RandomListNode next = p.next.next;
            if (p.random != null)
                p.next.random = p.random.next;
            p = next;
        }

        p = pHead;
        RandomListNode res = pHead.next;
        RandomListNode curCopy = null;
        while (p != null) {
            RandomListNode next = p.next.next;
            // ����ǵ�curCopyҲҪ�������
            curCopy = p.next;
            p.next = next;
            // ���ﻹҪע���п�
            curCopy.next = next != null ? next.next : null;
            p = next;
        }
        return res;
    }
}
