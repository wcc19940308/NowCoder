package NowCoder.swordToOffer;

import java.util.ArrayList;
import java.util.List;

public class FindContinuousSequence {
    public static ArrayList<ArrayList<Integer>> FindContinuousSequence(int sum) {
        ArrayList<ArrayList<Integer>> list = new ArrayList<>();
        int lo = 1, hi = 2;
        int curSum = lo + hi;
        while (lo < (sum + 1) / 2) {
            if (curSum == sum) {
                ArrayList<Integer> tmpList = new ArrayList<>();
                for (int i = lo; i <= hi; i++) {
                    tmpList.add(i);
                }
                list.add(tmpList);
                hi++;
                curSum += hi;
            } else if (curSum < sum) {
                hi++;
                curSum += hi;
            } else if (curSum > sum) {
                curSum -= lo;
                lo++;
            }
        }
        return list;
    }

    public static void main(String[] args) {
        System.out.println(FindContinuousSequence(10));
    }
}
