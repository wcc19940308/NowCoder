package NowCoder.class07;

import java.util.Arrays;
import java.util.Comparator;

/**
 * 求字符串数组所能拼接成的字母序最小的字符串，排序策略可以是比较每个字符串的字典序，但是这是错误的，正确的是需要比较2个字符串各自在前的时候的字典序大小
 * 这里比较策略就是贪心策略
 *
 * 贪心只是一种解决问题的策略，即求出每步的最优解，从而得出全局的最优解。
 * 贪心的证明较难，可以通过对数器来验证贪心策略的正确性
 */
public class LowestLexicography {
    public static String lowsetLexicography(String[] strs) {
        Arrays.sort(strs, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return (o1 + o2).compareTo(o2 + o1);
            }
        });
        String res = "";
        for (String str : strs) {
            res += str;
        }
        return res;
    }

    public static void main(String[] args) {
        String[] strs1 = { "jibw", "ji", "jp", "bw", "jibw" };
        System.out.println(lowsetLexicography(strs1));

        String[] strs2 = { "ba", "b" };
        System.out.println(lowsetLexicography(strs2));
    }
}
