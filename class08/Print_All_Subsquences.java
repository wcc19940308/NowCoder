package NowCoder.class08;

/**
 *
 * 打印所有子序列
 *
 */
public class Print_All_Subsquences {
    public static void printAllSub(char[] str, int i, String res) {
        if (str.length == i) {
            System.out.println(res);
            return;
        }
        printAllSub(str, i + 1, res);
        printAllSub(str, i + 1, res + str[i]);
    }

    public static void main(String[] args) {
        printAllSub("abc".toCharArray(), 0, "");
    }
}
