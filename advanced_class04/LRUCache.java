package NowCoder.advanced_class04;

import java.util.HashMap;
import java.util.Map;

class LRUCache {
    class LinkNode {
        // 这里之所以还有个键是为了能够在map中找到相应的最后一个Node并且删除
        public int key;
        public int value;
        public LinkNode pre;
        public LinkNode next;

        public LinkNode(int key, int value) {
            this.key = key;
            this.value = value;
        }
    }

    int capacity, count;
    LinkNode head, tail;
    // map里面存的是该节点的地址，因此对map进行修改，会直接影响到对应的双向链表中的节点
    Map<Integer, LinkNode> map;

    public LRUCache(int capacity) {
        count = 0;
        this.capacity = capacity;
        head = new LinkNode(0, 0);
        tail = new LinkNode(0, 0);
        head.next = tail;
        head.pre = null;
        tail.pre = tail;
        tail.next = null;
        map = new HashMap<>();
    }

    public void addToHead(LinkNode node) {
//        node.next = head.next;
//        head.next.pre = node;
//        head.next = node;
//        node.pre = head;
        LinkNode next = head.next;
        node.next = next;
        next.pre = node;
        node.pre = head;
        head.next = node;
    }

    public void removeNode(LinkNode node) {
//        node.pre.next = node.next;
//        node.next.pre = node.pre;
        LinkNode pre = node.pre;
        LinkNode next = node.next;
        pre.next = next;
        next.pre = pre;
    }

    public void removeTail() {
//        tail.pre = tail.pre.pre;
//        tail.pre.next = tail;
        LinkNode pre = tail.pre.pre;
        pre.next = tail;
        tail.pre = pre;
    }

    public int get(int key) {
        if (map.containsKey(key)) {
            LinkNode node = map.get(key);
            removeNode(node);
            addToHead(node);
            return node.value;
        }
        return -1;
    }

    public void put(int key, int value) {
        if (map.containsKey(key)) {
            LinkNode node = map.get(key);
            node.value = value;
            removeNode(node);
            addToHead(node);
        } else {
            LinkNode node = new LinkNode(key, value);
            map.put(key, node);
            if (count == capacity) {
                map.remove(tail.pre.key); // 这里记得要删掉对应的键
                removeNode(tail.pre);
                addToHead(node);
            } else {
                addToHead(node);
                count++;
            }
        }
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */