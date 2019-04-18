package NowCoder.advacned_class01;

/**
 * �������㷨
 * 1.���İ뾶����
 * 2.���л��İ뾶�еĻ����ұ߽磨���Ե�ǰ�ַ�Ϊ�����ܹ���������ҵ�λ�ã�
 * 3.�����ұ߽�����ģ����絽����������ұ߽������λ�ã�
 *
 * Ϊ�˴�����ż���ĵ�������Ƚ�ԭ�ַ������д���
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
