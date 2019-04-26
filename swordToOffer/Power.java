package NowCoder.swordToOffer;

/**
 * 数值的整数次方:
 * 给定一个double类型的浮点数base和int类型的整数exponent。求base的exponent次方。
 */
public class Power {
    boolean flag = false;
    public double Power(double base, int exponent) {
        if (base == 0.0 && exponent < 0) {
            flag = true;
            return 0;
        }
        int absExponent = Math.abs(exponent);
        double res = calculate(base, absExponent);
        return res;
    }

    public double calculate(double base, int exponent) {
        if (exponent == 0) return 1;
        if (exponent == 1) return base;
        double res = 1.0;
        res *= calculate(base, exponent >> 1);
        if (exponent % 2 != 0) res *= base;
        return res;
    }
}
