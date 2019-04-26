package NowCoder.swordToOffer;

public class StrToInt {
    public static int StrToInt(String str) {
        int k = 0;
        int flag = 0;
        for (int i = 0; i < str.length(); i++) {
            if (i == 0 && (str.charAt(i) == '-' || str.charAt(i) == '+')) {
                flag = str.charAt(i) == '-' ? -1 : 1;
                continue;
            }
            if (Character.isDigit(str.charAt(i))) {
                k = k * 10 + str.charAt(i) - '0';
            } else {
                return 0;
            }
        }
        return flag == -1 ? -k : k;
    }

    public static void main(String[] args) {
        String str = "+123";
        System.out.println(StrToInt(str));
    }
}
