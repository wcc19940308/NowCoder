package NowCoder.class08;

/**
 *
 * 汉诺塔问题，from,to,help3个杆子，from借助help到to上
 * 1.将1~n-1移动到help上
 * 2.将n移动到to上
 * 3.将1~n-1移动到to上
 *
 */
public class Hanoi {
    // 将from上的元素借助help移动到to上
    public static void hanoi(int n, String from, String to, String help) {
        if (n == 1) {
            System.out.println("Move 1 from " + from + " to " + to + " by " + help);
        } else {
            hanoi(n - 1, from, help, to);
            System.out.println("Move " + n + " from " + from + " to " + to + " by " + help);
            hanoi(n - 1, help, to, from);
        }
    }

    public static void main(String[] args) {
        hanoi(3, "left", "right", "mid");
    }
}
