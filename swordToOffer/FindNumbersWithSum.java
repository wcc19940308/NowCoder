package NowCoder.swordToOffer;

import java.util.ArrayList;

public class FindNumbersWithSum {
    public static ArrayList<Integer> FindNumbersWithSum(int[] array, int sum) {
        ArrayList<Integer> list = new ArrayList<>();
        int lo = 0, hi = array.length - 1;
        while (lo < hi) {
            int curSum = array[lo] + array[hi];
            if (curSum == sum) {
                list.add(array[lo]);
                list.add(array[hi]);
                break;
            } else if (curSum < sum) {
                lo++;
            } else if (curSum > sum) {
                hi--;
            }
        }
        return list;
    }

    public static void main(String[] args) {
        int[] arr = new int[]{1, 2, 4, 7, 11, 15};
        System.out.println(FindNumbersWithSum(arr, 15));
    }
}
