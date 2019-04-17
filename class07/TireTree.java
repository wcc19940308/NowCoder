package NowCoder.class07;

/**
 *
 * ǰ׺��,�ܹ�ͳ��ĳ���ַ����ֵĴ�����end���������ܹ�ͳ��ĳ��ǰ׺���ֵĴ�����path��
 *
 */
public class TireTree {
    public static class TireNode {
        public int path;
        public int end;
        public TireNode[] nexts;

        public TireNode() {
            path = 0;
            end = 0;
            nexts = new TireNode[26];
        }
    }

    public static TireNode root;
    public TireTree() {
        root = new TireNode();
    }


    public static void insert(String word) {
        TireNode node = root;
        for (char ch : word.toCharArray()) {
            if (node.nexts[ch - 'a'] == null) {
                node.nexts[ch - 'a'] = new TireNode();
            }
            node = node.nexts[ch - 'a'];
            node.path++;
        }
        node.end++;
    }

    public static void delete(String word) {
        if (search(word) != 0) {
            TireNode node = root;
            for (char ch : word.toCharArray()) {
                if ((--node.nexts[ch - 'a'].path) == 0) {
                    node.nexts[ch - 'a'] = null;
                    return;
                }
                node = node.nexts[ch - 'a'];
            }
            node.end--;
        }
    }

    public static int search(String word) {
        TireNode node = root;
        for (char ch : word.toCharArray()) {
            if (node.nexts[ch - 'a'] == null) {
                return 0;
            }
            node = node.nexts[ch - 'a'];
        }
        return node.end;
    }

    public static int prefixNumber(String pre) {
        TireNode node = root;
        for (char ch : pre.toCharArray()) {
            if (node.nexts[ch - 'a'] == null) {
                return 0;
            }
            node = node.nexts[ch - 'a'];
        }
        return node.path;
    }

    public static void main(String[] args) {
        TireTree tireTree = new TireTree();
        tireTree.insert("abc");
        tireTree.insert("abc");
        tireTree.insert("a");
        System.out.println(tireTree.prefixNumber("a"));
    }
}
