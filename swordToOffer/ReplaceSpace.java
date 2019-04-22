package NowCoder.swordToOffer;

/**
 * 替换空格：
 * 请实现一个函数，将一个字符串中的每个空格替换成“%20”。例如，当字符串为We Are Happy.则经过替换之后的字符串为We%20Are%20Happy。
 *
 * 扩展字符串数组，遍历出空格数量，依次赋值即可
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
