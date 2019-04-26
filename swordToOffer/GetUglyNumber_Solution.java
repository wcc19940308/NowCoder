package NowCoder.swordToOffer;

import java.util.ArrayList;
import java.util.List;

public class GetUglyNumber_Solution {
    public static int GetUglyNumber_Solution(int index) {
        if (index <= 1) return index;
        List<Integer> list = new ArrayList<>();
        list.add(1);
        int i2 = 0, i3 = 0, i5 = 0;
        for (int i = 1; i < index; i++) {
            int res1 = list.get(i2) * 2;
            int res3 = list.get(i3) * 3;
            int res5 = list.get(i5) * 5;

            int min = Math.min(res1, Math.min(res3, res5));
            list.add(min);
            if (min == res1) i2++;
            if (min == res3) i3++;
            if (min == res5) i5++;
        }
        return list.get(index - 1);
    }

    public static void main(String[] args) {
        int i = GetUglyNumber_Solution(11);
        System.out.println(i);
    }
}
