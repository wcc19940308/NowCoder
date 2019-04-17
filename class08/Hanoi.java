package NowCoder.class08;

/**
 *
 * ��ŵ�����⣬from,to,help3�����ӣ�from����help��to��
 * 1.��1~n-1�ƶ���help��
 * 2.��n�ƶ���to��
 * 3.��1~n-1�ƶ���to��
 *
 */
public class Hanoi {
    // ��from�ϵ�Ԫ�ؽ���help�ƶ���to��
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
