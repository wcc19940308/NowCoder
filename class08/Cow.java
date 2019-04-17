package NowCoder.class08;

/**
 * ĸţÿ����һֻĸţ���³�����ĸţ�ɳ������Ҳ��ÿ����һֻ
 * ĸţ�����費��������N���ĸţ��������
 * F(n) = F(n - 1) + F(n - 3) ����� = ȥ��� + 3��ǰ������
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
