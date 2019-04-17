package NowCoder.class08;

/**
 * 母牛每年生一只母牛，新出生的母牛成长三年后也能每年生一只
 * 母牛，假设不会死。求N年后，母牛的数量。
 * F(n) = F(n - 1) + F(n - 3) 今年的 = 去年的 + 3年前新生的
 */
public class Cow {
    public static int getCowCount(int n) {
        if (n == 1 || n == 2 || n == 3) {
            return n;
        }
        int res = 3;
        int pre = 2;
        int prepre = 1;
        int tmp1 = 0;
        int tmp2 = 0;
        for (int i = 4; i <= n; i++) {
            tmp1 = res;
            tmp2 = pre;
            res = res + prepre;
            prepre = tmp2;
            pre = tmp1;
        }
        return res;
    }
    public static void main(String[] args) {

    }
}
