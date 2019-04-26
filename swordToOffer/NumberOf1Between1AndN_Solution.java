package NowCoder.swordToOffer;

/**
 * ������1���ֵĴ�������1��n������1���ֵĴ�����
 * ��Ŀ����
 * ���1~13��������1���ֵĴ���,�����100~1300��������1���ֵĴ�����Ϊ�����ر�����һ��1~13�а���1��������1��10��11��12��13��˹�����6��,
 * ���Ƕ��ں�����������û���ˡ�
 * ACMerϣ�����ǰ����,������������ձ黯,���Ժܿ���������Ǹ�����������1���ֵĴ�������1 �� n ��1���ֵĴ�������
 *
 * leetcode 233
 * https://www.cnblogs.com/grandyang/p/4629032.html
 * https://leetcode.com/problems/number-of-digit-one/discuss/64390/AC-short-Java-solution
 *
 * ��N = abcde ,����abcde�ֱ�Ϊʮ�����и�λ�ϵ����֡�
 * ���Ҫ�����λ��1���ֵĴ�������Ҫ�ܵ�3�����Ӱ�죺��λ�ϵ����֣���λ���£���λ�������֣���λ���ϣ���λ�������֡�
 * �� �����λ������Ϊ0����λ�Ͽ��ܳ���1�Ĵ����ɸ���λ���������磺12013�������֪����λ����1����������ǣ�100~199��1100~1199,2100~2199����...��11100~11199��һ��1200�������Կ������ɸ���λ���֣�12�����������ҵ��ڸ���λ���֣�12������ ��ǰλ����100����
 * �� �����λ������Ϊ1����λ�Ͽ��ܳ���1�Ĵ��������ܸ���λӰ�컹�ܵ�λӰ�졣���磺12113�������֪����λ�ܸ�λӰ����ֵ�����ǣ�100~199��1100~1199,2100~2199����....��11100~11199��һ��1200�������������һ�������ҵ��ڸ���λ���֣�12������ ��ǰλ����100������ͬʱ�����ܵ�λӰ�죬��λ����1������ǣ�12100~12113,һ��114�������ڵ�λ���֣�113��+1��
 * �� �����λ�����ִ���1��2~9�������λ�ϳ���1��������ɸ���λ����������12213�����λ����1������ǣ�100~199,1100~1199��2100~2199��...��11100~11199,12100~12199,һ����1300�������ҵ��ڸ���λ����+1��12+1�����Ե�ǰλ����100����
 */
public class NumberOf1Between1AndN_Solution {
    public int NumberOf1Between1AndN_Solution(int n) {
        int res = 0;
        int i = 1; // ��ǰλ��
        while ((n / i) > 0) {
            int current = (n / i) % 10;
            int before = (n / i) / 10;
            int after = n - (n / i) * i;
            if (current == 0) {
                res += before * i;
            } else if (current == 1) {
                res += before * i + (after + 1);
            } else if (current >= 2) {
                res += (before + 1) * i;
            }
            i *= 10;
        }
        return res;
    }
}