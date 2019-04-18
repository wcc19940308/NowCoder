package NowCoder.advacned_class01;

/**
 * 在字符串的最后添加最少字符，使整个字符串都成为回文串
 * Manacher的应用，在保证包含最后一个字符的情况下，将之前不是最长回文子串的部分进行逆序，就是应该添加的部分
 * 即从左到右计算回文半径的时候，一旦回文半径最右到达（pR == charArr.length），说明必须抱哈年最后一个字符的最长回文半径已经找到，
 * 直接退出检查过程，返回该添加的字符串即可·
 */
public class Manacher_ShorestEnd {
    public static char[] manacherString(String str) {
        char[] charArr = str.toCharArray();
        char[] res = new char[charArr.length * 2 + 1];
        int index = 0;
        for (int i = 0; i < res.length; i++) {
            res[i] = (i & 1) == 0 ? '#' : charArr[index++];
        }
        return res;
    }

    public static String manacher_shorestEnd(String str) {
        if (str == null || str.length() == 0) {
            return "";
        }
        char[] charArr = manacherString(str);
        int[] pArr = new int[charArr.length];
        int index = -1;
        int pR = -1;
        int max = Integer.MIN_VALUE;
        int resIndex = 0;
        for (int i = 0; i != charArr.length; i++) {
            pArr[i] = pR > i ? Math.min(pArr[2 * index - i], pR - i) : 1;
            while (i + pArr[i] < charArr.length && i - pArr[i] > -1) {
                if (charArr[i + pArr[i]] == charArr[i - pArr[i]]) {
                    pArr[i]++;
                } else {
                    break;
                }
            }
            if (i + pArr[i] > pR) {
                pR = i + pArr[i];
                index = i;
            }
            if (pR == charArr.length) {
                // 这里返回的就是以i为中心的最大回文串的长度+1
                resIndex = pArr[i];
                break;
            }
        }
        // 这里的res数组就是前面那部分的长度
        char[] res = new char[(str.length() - resIndex + 1)];
        for (int i = 0; i < res.length; i++) {
            res[res.length - i - 1] = charArr[2 * i + 1];
        }
        return String.valueOf(res);
    }

    public static void main(String[] args) {
        String s = "abc12321";
        System.out.println(manacher_shorestEnd(s));
    }
}
