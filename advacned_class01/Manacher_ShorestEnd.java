package NowCoder.advacned_class01;

/**
 * ���ַ����������������ַ���ʹ�����ַ�������Ϊ���Ĵ�
 * Manacher��Ӧ�ã��ڱ�֤�������һ���ַ�������£���֮ǰ����������Ӵ��Ĳ��ֽ������򣬾���Ӧ����ӵĲ���
 * �������Ҽ�����İ뾶��ʱ��һ�����İ뾶���ҵ��pR == charArr.length����˵�����뱧�������һ���ַ�������İ뾶�Ѿ��ҵ���
 * ֱ���˳������̣����ظ���ӵ��ַ������ɡ�
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
                // ���ﷵ�صľ�����iΪ���ĵ������Ĵ��ĳ���+1
                resIndex = pArr[i];
                break;
            }
        }
        // �����res�������ǰ���ǲ��ֵĳ���
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
