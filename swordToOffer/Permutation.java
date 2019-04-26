package NowCoder.swordToOffer;

import java.util.ArrayList;
import java.util.Arrays;

public class Permutation {
    public static ArrayList<String> Permutation(String str) {
        char[] chars = str.toCharArray();
        Arrays.sort(chars);
        ArrayList<String> list = new ArrayList<>();
        boolean[] used = new boolean[str.length()];
        if (str == null || str.length() == 0) {
            return list;
        }
        recursive(chars, new StringBuilder(), list, used);
        return list;
    }

    public static void recursive(char[] chars, StringBuilder sb, ArrayList<String> list, boolean[] used) {
        if (sb.length() == chars.length) {
            list.add(sb.toString());
        }
        for (int i = 0; i < chars.length; i++) {
            if (used[i] || (i > 0 && chars[i] == chars[i - 1] && !used[i-1])) {
                continue;
            }
            sb.append(chars[i]);
            used[i] = true;
            recursive(chars, sb, list, used);
            used[i] = false;
            sb.setLength(sb.length() - 1);
        }
    }

    public static void main(String[] args) {
        String str = "122";
        System.out.println(Permutation(str));
    }
}
