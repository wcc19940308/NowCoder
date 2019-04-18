package NowCoder.advacned_class01;

/**
 * 判断1棵树是否为另一棵树的子树
 * 将2棵树分别序列化，然后使用KMP比较其中1棵子树是否为另一棵树的子串
 */
public class KMP_T1SubtreeEqualsT2 {
    public static class Node {
        int val;
        Node left;
        Node right;

        public Node(int val) {
            this.val = val;
        }
    }

    public static boolean judgeEqual(Node head1, Node head2) {
        String s1 = serialPre(head1);
        String s2 = serialPre(head2);
        int res = getIndexOf(s1, s2);
        return res != -1;
    }

    public static String serialPre(Node head) {
        if (head == null) {
            return "#_";
        }
        String res = head.val + "_";
        res += serialPre(head.left);
        res += serialPre(head.right);
        return res;
    }

    public static int getIndexOf(String str1, String str2) {
        int[] next = getNext(str2);
        int s1 = 0, s2 = 0;
        while (s1 < str1.length() && s2 < str2.length()) {
            if (str1.charAt(s1) == str2.charAt(s2)) {
                s1++;
                s2++;
            } else if (next[s2] == -1) {
                s1++;
            } else {
                s2 = next[s2];
            }
        }
        return s2 == str2.length() ? s1 - s2 : -1;
    }

    public static int[] getNext(String str2) {
        int n = str2.length();
        int[] next = new int[n];
        next[0] = -1;
        next[1] = 0;
        int pos = 2;
        int cn = 0;
        while (pos < n) {
            // next[cn]单调递减，cn最后必收敛于0
            if (str2.charAt(pos - 1) == str2.charAt(cn)) {
                next[pos++] = cn++;
            } else if (cn > 0) {
                cn = next[cn];
            } else {
                next[pos++] = 0;
            }
        }
        return next;
    }

    public static void main(String[] args) {
        Node t1 = new Node(1);
        t1.left = new Node(2);
        t1.right = new Node(3);
        t1.left.left = new Node(4);
        t1.left.right = new Node(5);
        t1.right.left = new Node(6);
        t1.right.right = new Node(7);
        t1.left.left.right = new Node(8);
        t1.left.right.left = new Node(9);

        Node t2 = new Node(2);
        t2.left = new Node(4);
        t2.left.right = new Node(8);
        t2.right = new Node(5);
        t2.right.left = new Node(9);

        System.out.println(judgeEqual(t1, t2));

    }
}
