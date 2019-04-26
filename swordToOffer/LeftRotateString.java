package NowCoder.swordToOffer;

public class LeftRotateString {
    public static String LeftRotateString(String str,int n) {
        if (str == null || str.length() == 0 || n < 0) return "";
        int k = n % str.length();
        String res = str;
        res += res;
        return res.substring(n, n + str.length());
    }

    public static void main(String[] args) {
        String s = "abcXYZdef";
        System.out.println(LeftRotateString(s, 3));
    }

}
