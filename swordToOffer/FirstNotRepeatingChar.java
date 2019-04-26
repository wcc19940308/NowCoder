package NowCoder.swordToOffer;

import java.util.LinkedHashMap;
import java.util.Map;

public class FirstNotRepeatingChar {
    public static int FirstNotRepeatingChar(String str) {
        Map<Character, Integer> map = new LinkedHashMap<>();
        char[] chars = str.toCharArray();
        for (char ch : chars) {
            map.put(ch, map.getOrDefault(ch, 0) + 1);
        }

        for (int i = 0; i < chars.length; i++) {
            if (map.get(chars[i]) == 1) {
                return i;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        String s = "google";
        int i = FirstNotRepeatingChar(s);
        System.out.println(i);
    }
}
