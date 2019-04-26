package NowCoder.swordToOffer;

import java.util.Arrays;

public class MoreThanHalfNum_Solution {
    public static int MoreThanHalfNum_Solution(int [] array) {
        int candidate = array[0];
        int len = 1;
        for (int i = 1; i < array.length; i++) {
            if (array[i] == candidate) {
                len++;
            } else {
                len--;
                if (len == 0) {
                    candidate = array[i];
                    len = 1;
                }
            }
        }
        int resLength = 0;
        for (int i = 0; i < array.length; i++) {
            if (array[i] == candidate) resLength++;
        }
        return resLength > array.length / 2 ? candidate : 0;
    }

    public static void main(String[] args) {
        int[] arr = new int[]{1, 2, 3, 2, 2, 2, 5, 4, 2};
        System.out.println(MoreThanHalfNum_Solution(arr));
    }
}
