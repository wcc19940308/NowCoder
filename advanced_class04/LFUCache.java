package NowCoder.advanced_class04;

import java.util.HashMap;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Set;

/**
 * LFU�㷨��2��˫������1�������¼ʹ�õĴ�����1�������¼��Ӧ�����µĽڵ�����Щ
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
            // β�巨
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
        // û����һ��Ƶ�ʵĽڵ㣬��ô���½�
        if (nextFreqNode == null) {
            // ����ͬ���Ѿ���newFreNode��pre��ֵ��
            nextFreqNode = new FreqNode(keynode.freq, freqnode, null);
            freqnode.next = nextFreqNode;
            freqMap.put(keynode.freq, nextFreqNode);
        }
        // �������һ��Ƶ�ʵĽڵ㣬����������1����ô���м����
        if (nextFreqNode != null && nextFreqNode.freq > keynode.freq) {
            nextFreqNode = insertFreqNodePlus1(keynode.freq, freqnode);
        }
        // ��key��ԭ����FreqNode��set���ƶ�����һ��FreqNode�е�set
        unlinkKey(keynode, freqnode);
        linkKey(keynode, nextFreqNode);
    }

    // remove the head's oldest node - yes
    public void removeKeyNode(FreqNode fnode) {
        // head����������Ǹ��ڵ�
        KeyNode knode = fnode.set.iterator().next();
        // ��knode��map�Ͷ�Ӧ��freqNode��set���Ƴ�
        unlinkKey(knode, freqMap.get(knode.freq));
        keyMap.remove(knode.key);
    }
    // Inserts a new KeyNode<key, value> with freq 1. - yes
    public void insertKeyNode(int key, int val) {
        // �����½ڵ㣬�ֱ���2��map�м���,��������head
        KeyNode keynode = new KeyNode(key, val);
        keyMap.put(key, keynode);
        if (!freqMap.containsKey(1)) {
            FreqNode freqnode = new FreqNode(1, null, head);
            //freqnode.next = head;
            if (head != null)   head.prev = freqnode;
            head = freqnode;
            freqMap.put(1, freqnode);
        }
        // ��freqMap��set�м���
        linkKey(keynode, freqMap.get(1));
    }
    // insert a new freqnode with new freq after given "freqnode" - yes
    public FreqNode insertFreqNodePlus1(int freq, FreqNode freqnode) {
        // ����Ĺ��캯���Ѿ���newFreqNode��pre��next���������ø�ֵ
        FreqNode newfnode = new FreqNode(freq, freqnode, freqnode.next);
        freqMap.put(freq, newfnode);
        // ��������ֻ��Ҫ������2�����ü���
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