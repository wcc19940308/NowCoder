package NowCoder.swordToOffer;

public class FindNumsAppearOnce {
    public static void FindNumsAppearOnce(int [] array,int num1[] , int num2[]) {
        int xor = 0;
        for (int i = 0; i < array.length; i++) {
            xor ^= array[i];
        }
        int firstIndex = 0;
        while (xor != 0) {
            if ((xor & 1) == 1) {
                break;
            }
            xor >>>= 1;
            firstIndex++;
        }
        int xor1 = 0, xor2 = 0;
        for (int i = 0; i < array.length; i++) {
            if (((array[i] >>> firstIndex) & 1) == 0) {
                xor1 ^= array[i];
            } else {
                xor2 ^= array[i];
            }
        }
        num1[0] = xor1;
        num2[0] = xor2;
    }

    public static void main(String[] args) {
        int[] array = new int[]{2,4,3,};

    }
}
