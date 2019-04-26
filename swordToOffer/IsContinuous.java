package NowCoder.swordToOffer;

import java.util.Arrays;

public class IsContinuous {
    public static boolean isContinuous(int [] numbers) {
        if (numbers == null || numbers.length == 0) return false;
        Arrays.sort(numbers);
        int n = numbers.length;
        int zeroNumber = 0;
        int needZero = 0;
        for (int i = 0; i < n; i++) {
            if (numbers[i] == 0) zeroNumber++;
        }
        for (int i = zeroNumber; i < n - 1; i++) {
            if (numbers[i] == numbers[i + 1]) {
                return false;
            }
            if (numbers[i + 1] - numbers[i] > 1) {
                needZero += numbers[i + 1] - numbers[i] - 1;
            }
        }
        if (needZero > zeroNumber) return false;
        return true;
    }

    public static void main(String[] args) {
        int[] arr = new int[]{0, 3, 1, 6, 4};
        System.out.println(isContinuous(arr));

    }
}
