package NowCoder.advacned_class01;

/**
 * 判断1棵树是否是另一棵树的子树也可以用KMP来解决：
 * 序列化2棵树，使用KMP比较字符串是否匹配
 */
public class KMP {
    public static int getIndexOf(char[] str1, char[] str2) {
        if (str1 == null || str2 == null || str2.length < 1 || str1.length < str2.length) {
            return -1;
        }
        int[] next = getNextArray(str2);
        int s1 = 0, s2 = 0;
        while (s1 < str1.length && s2 < str2.length) {
            if (str1[s1] == str2[s2]) {
                s1++;
                s2++;
            } else if (next[s2] == -1) {
                s1++;
            } else {
                s2 = next[s2];
            }
        }
        return s2 == str2.length ? s1 - s2 : -1;
    }

    public static int[] getNextArray(char[] str2) {
        if (str2.length == 1) {
            return new int[]{-1};
        }
        int n = str2.length;
        int[] next = new int[n];
        next[0] = -1;
        next[1] = 0;
        int pos = 2;
        int cn = 0;
        while (pos < n) {
            if (str2[pos - 1] == str2[cn]) {
                next[pos++] = ++cn;
            } else if (cn > 0) {
                cn = next[cn];
            } else {
                next[pos++] = 0;
            }
        }
        return next;
    }

    public static void main(String[] args) {
        char[] s1 = "12345".toCharArray();
        char[] s2 = "3".toCharArray();
        int indexOf = getIndexOf(s1, s2);
        System.out.println(indexOf);

    }
}
