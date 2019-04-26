package NowCoder.swordToOffer;

import java.util.HashMap;
import java.util.Map;

/**
 * 复杂链表的复制
 * 题目描述
 * 输入一个复杂链表（每个节点中有节点值，以及两个指针，一个指向下一个节点，另一个特殊指针指向任意一个节点），返回结果为复制后复杂链表的head。
 * （注意，输出结果中请不要返回参数中的节点引用，否则判题程序会直接返回空）
 *
 * 1.HashMap,原链表节点和新链表节点一一对应
 * 2.O（1）空间复杂度
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
        // 将新产生的头结点放入原链表
        while (p != null) {
            RandomListNode next = p.next;
            RandomListNode newHead = new RandomListNode(p.label);
            newHead.next = next;
            p.next = newHead;
            p = next;
        }

        // 处理Random指针
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
            // 这里记得curCopy也要随机跟进
            curCopy = p.next;
            p.next = next;
            // 这里还要注意判空
            curCopy.next = next != null ? next.next : null;
            p = next;
        }
        return res;
    }
}
