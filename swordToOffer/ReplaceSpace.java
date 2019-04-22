package NowCoder.swordToOffer;

/**
 * �滻�ո�
 * ��ʵ��һ����������һ���ַ����е�ÿ���ո��滻�ɡ�%20�������磬���ַ���ΪWe Are Happy.�򾭹��滻֮����ַ���ΪWe%20Are%20Happy��
 *
 * ��չ�ַ������飬�������ո����������θ�ֵ����
 */
public class ReplaceSpace {
    public static String replaceSpace(StringBuffer str) {
        int spaceCount = 0;
        String s = str.toString();
        for (int i = 0; i < s.length(); i++) {
            if (' ' == s.charAt(i)) spaceCount++;
        }
        char[] chars = new char[str.length() + 2 * spaceCount];
        int index = chars.length - 1;
        for (int i = str.length() - 1; i >= 0; i--) {
            if (s.charAt(i) != ' ') {
                chars[index--] = s.charAt(i);
            } else {
                chars[index--] = '0';
                chars[index--] = '2';
                chars[index--] = '%';
            }
        }
        return new String(chars);
    }

    public static void main(String[] args) {
        StringBuffer sb = new StringBuffer();
        sb.append("We Are Happy");
        System.out.println(replaceSpace(sb));

    }
}
