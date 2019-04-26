package NowCoder.swordToOffer;

public class ReverseSentence {
    public static String ReverseSentence(String str) {
        char[] chars = str.toCharArray();
        String tmp = "", res = "";
        for (int i = 0; i < chars.length; i++) {
            if (chars[i] == ' ') {
                res = " " + tmp + res;
                tmp = "";
            } else {
                tmp += chars[i];
            }
        }
        // 最后的如果不是空格的话还要再拼接上
        if (tmp.length() != 0) res = tmp + res;
        return res;
    }

    public static void main(String[] args) {
        String s = "student. a am I";
        String res = ReverseSentence(s);
        System.out.println(res);
    }
}
