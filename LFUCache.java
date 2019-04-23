package NowCoder;

import java.util.HashMap;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Set;

public class LFUCache {
    public static class KeyNode {
        int key;
        int val;
        int freq;

        public KeyNode(int key, int val) {
            this.key = key;
            this.val = val;
            this.freq = 1;
        }
    }

    public static class FreqNode {
        int freq;
        FreqNode pre;
        FreqNode next;
        Set<KeyNode> set;

        public FreqNode(int freq, FreqNode pre, FreqNode next) {
            this.freq = freq;
            this.pre = pre;
            this.next = next;
            set = new LinkedHashSet<>();
        }
    }

    int capacity;
    FreqNode head;
    Map<Integer, KeyNode> keyMap;
    Map<Integer, FreqNode> freqMap;

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
        }
        return -1;
    }
    public void put(int key, int value) {
        if (this.capacity == 0) return;
        if (keyMap.containsKey(key)) {
            increase(key, value);
            return;
        }
        if (keyMap.size() == this.capacity) {
            removeKeyNode(head);
        }
        insertKeyNode(key, value);
    }

    public void increase(int key, int val) {
        KeyNode keyNode = keyMap.get(key);
        keyNode.val = val;
        keyNode.freq += 1;
        FreqNode freqNode = freqMap.get(key);
        FreqNode nextFreqNode = freqNode.next;
        if (nextFreqNode == null) {
            // 这里同理已经把newFreNode的pre赋值了
            nextFreqNode = new FreqNode(keyNode.freq, freqNode, null);
            freqNode.next = nextFreqNode;
            freqMap.put(keyNode.freq, nextFreqNode);
        }
        if (nextFreqNode != null && nextFreqNode.freq > keyNode.freq) {
            nextFreqNode = insertFreqNodePlus1(keyNode.freq, freqNode);
        }
        unlinkKey(keyNode, freqNode);
        linkKey(keyNode, nextFreqNode);
    }

    public FreqNode insertFreqNodePlus1(int freq, FreqNode freqNode) {
        // 这里的构造函数已经把newFreqNode的pre和next进行了引用赋值
        FreqNode newFreqNode = new FreqNode(freq, freqNode, freqNode.next);
        freqMap.put(freq, newFreqNode);
        // 所以这里只需要再连接2个引用即可
        if (freqNode.next != null) freqNode.next.pre = newFreqNode;
        freqNode.next = newFreqNode;
        return newFreqNode;
    }

    public void unlinkKey(KeyNode keyNode, FreqNode freqNode) {
        freqNode.set.remove(keyNode);
        if (freqNode.set == null || freqNode.set.size() == 0) deleteFreqNode(freqNode);
    }

    public void linkKey(KeyNode keyNode, FreqNode freqNode) {
        freqNode.set.add(keyNode);
    }

    public void deleteFreqNode(FreqNode freqNode) {
        FreqNode prev = freqNode.pre, next = freqNode.next;
        if (prev != null) prev.next = next;
        if (next != null) next.pre = prev;
        // 因为head前面是没有元素的
        if (head == freqNode) head = next;
        freqMap.remove(freqNode.freq);
    }

    public void removeKeyNode(FreqNode freqNode) {
        KeyNode keyNode = head.set.iterator().next();
        unlinkKey(keyNode, freqMap.get(keyNode.freq));
        keyMap.remove(keyNode);
    }

    public void insertKeyNode(int key, int val) {
        KeyNode keyNode = new KeyNode(key, val);
        keyMap.put(key, keyNode);
        if (!freqMap.containsKey(1)) {
            FreqNode freqNode = new FreqNode(1, null, head);
            if (head != null) head.pre = freqNode;
            head = freqNode;
            freqMap.put(1, freqNode);
        }
        linkKey(keyNode, freqMap.get(1));

    }
}
