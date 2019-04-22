package NowCoder.advanced_class04;

import java.util.HashMap;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Set;

/**
 * LFU算法，2个双向链表，1个链表记录使用的次数，1个链表记录相应次数下的节点有哪些
 */
public class LFUCache {
    class KeyNode {
        int key;
        int val;
        int freq;
        public KeyNode (int key, int val) {
            this.key = key;
            this.val = val;
            this.freq = 1;
        }
    }
    class FreqNode {
        int freq;
        FreqNode prev;
        FreqNode next;
        Set<KeyNode> set; // keep the insertion order
        public FreqNode (int freq, FreqNode prev, FreqNode next) {
            this.freq = freq;
            this.prev = prev;
            this.next = next;
            // 尾插法
            set = new LinkedHashSet<>();
        }
    }
    int capacity;
    Map<Integer, KeyNode> keyMap;
    Map<Integer, FreqNode> freqMap;
    FreqNode head;
    public LFUCache(int capacity) {
        head = null;
        keyMap = new HashMap<>();
        freqMap = new HashMap<>();
        this.capacity = capacity;
    }

    public int get(int key) {
        if (keyMap.containsKey(key)) {
            KeyNode keyNode = keyMap.get(key);
            int val = keyNode.val;
            increase(key, val);
            return val;
        }
        return -1;
    }

    public void put(int key, int val) {
        if (this.capacity == 0) return;
        if (keyMap.containsKey(key)) {
            increase(key, val);
            return;
        }
        if (keyMap.size() == this.capacity) {
            removeKeyNode(head);
        }
        insertKeyNode(key, val);
    }

    // helper function
    // increase freq of key, update val if necessary - yes
    public void increase(int key, int val) {
        KeyNode keynode = keyMap.get(key);
        // update val
        keynode.val = val;
        FreqNode freqnode = freqMap.get(keynode.freq);
        keynode.freq += 1;
        FreqNode nextFreqNode = freqnode.next;
        if (nextFreqNode == null) {
            nextFreqNode = new FreqNode(keynode.freq, freqnode, null);
            freqnode.next = nextFreqNode;
            freqMap.put(keynode.freq, nextFreqNode);
        }
        if (nextFreqNode != null && nextFreqNode.freq > keynode.freq) {
            nextFreqNode = insertFreqNodePlus1(keynode.freq, freqnode);
        }
        // 如果下一个freqNode不为空，且下一个freqNode的频率就是+1后的频率
        unlinkKey(keynode, freqnode);
        linkKey(keynode, nextFreqNode);
    }

    // remove the head's oldest node - yes
    public void removeKeyNode(FreqNode fnode) {
        // head中最上面的那个节点
        KeyNode knode = fnode.set.iterator().next();
        unlinkKey(knode, freqMap.get(knode.freq));
        keyMap.remove(knode.key);
    }
    // Inserts a new KeyNode<key, value> with freq 1. - yes
    public void insertKeyNode(int key, int val) {
        KeyNode keynode = new KeyNode(key, val);
        keyMap.put(key, keynode);
        if (!freqMap.containsKey(1)) {
            FreqNode freqnode = new FreqNode(1, null, head);
            freqnode.next = head;
            if (head != null)   head.prev = freqnode;
            head = freqnode;
            freqMap.put(1, freqnode);
        }
        linkKey(keynode, freqMap.get(1));
    }
    // insert a new freqnode with new freq after given "freqnode" - yes
    public FreqNode insertFreqNodePlus1(int freq, FreqNode freqnode) {
        FreqNode newfnode = new FreqNode(freq, freqnode, freqnode.next);
        freqMap.put(freq, newfnode);
        if (freqnode.next != null)  freqnode.next.prev = newfnode;
        freqnode.next = newfnode;
        return newfnode;
    }
    // Unlink keyNode from freqNode - yes
    public void unlinkKey(KeyNode keynode, FreqNode freqnode) {
        freqnode.set.remove(keynode);
        if (freqnode.set == null || freqnode.set.size() == 0)     deleteFreqNode(freqnode);
    }
    // Link keyNode to freqNode - yes
    public void linkKey(KeyNode keynode, FreqNode freqnode) {
        freqnode.set.add(keynode);
    }
    // delete freqnode if there is no appending keynode under this freq - yes
    public void deleteFreqNode(FreqNode freqnode) {
        FreqNode prev = freqnode.prev, next = freqnode.next;
        if (prev != null)   prev.next = next;
        if (next != null)   next.prev = prev;
        if (head == freqnode)   head = next;
        freqMap.remove(freqnode.freq);
    }
}