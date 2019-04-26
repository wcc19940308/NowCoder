package NowCoder.swordToOffer;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class PrintMinNumber {
    public static String PrintMinNumber(int [] numbers) {
        String[] str = new String[numbers.length];
        for (int i = 0; i < numbers.length; i++) {
            str[i] = String.valueOf(numbers[i]);
        }
        Arrays.sort(str, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return (o1 + o2).compareTo(o2 + o1);
            }
        });
        String res = "";
        for (String s : str) {
            res += s;
        }
        return res;
    }

    public static void main(String[] args) {
        int[] arr = new int[]{332, 321};
        System.out.println(PrintMinNumber(arr));

    }
}
