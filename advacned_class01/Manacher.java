package NowCoder.advacned_class01;

/**
 * 马拉车算法
 * 1.回文半径数组
 * 2.所有回文半径中的回文右边界（即以当前字符为中心能够到达的最右的位置）
 * 3.回文右边界的中心（最早到达这个回文右边界的中心位置）
 *
 * 为了处理奇偶回文的情况，先将原字符串进行处理
 */
public class Manacher {
    public static char[] mamacherString(String str) {
        char[] charArr = str.toCharArray();
        char[] res = new char[charArr.length * 2 + 1];
        int index = 0;
        for (int i = 0; i < res.length; i++) {
            res[i] = (i & 1) == 0 ? '#' : charArr[index++];
        }
        return res;
    }

    public static int maxLcpLength(String str) {
        if (str.length() == 0 || str == null) {
            return 0;
        }
        char[] charArr = mamacherString(str);
        int[] pArr = new int[charArr.length];
        int max = Integer.MIN_VALUE;
        int index = -1;
        int pR = -1;
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
            max = Math.max(max, pArr[i]);
        }
        return max - 1;
    }

    public static void main(String[] args) {
        String str1 = "abc1234321ab";
        System.out.println(maxLcpLength(str1));
    }
}
