package NowCoder.swordToOffer;

public class Fibonacci {
    public int Fibonacci(int n) {
        if (n == 0 || n == 1) {
            return n;
        }
        int prepre = 0;
        int pre = 1;
        for (int i = 2; i <= n; i++) {
            int tmp = pre;
            pre = pre + prepre;
            prepre = tmp;
        }
        return pre;
    }
}
