package NowCoder.class04;

/**
 *
 * ��ֽ��Ϸ:һ��ֽ�������ϵ�����1�£�1�����µ��ۺۣ���2�£�2�����µ��ۺۣ�1�����ϵ��ۺۣ��ʵ�n�£����ϵ����ۺ۵����
 * ����һ����������Ӧ���⣬��1�£����£����԰�������µĽڵ��������ڵ㣬��2�£������ϣ�ÿ��1�£����˸��ڵ㣬������ԭ�ȵĻ����Ϸ��������ۺ��� = 2n-1
 * ����ÿ�ζ������1��1�µ��ۺۣ��������ۺ����ϣ����ۺ����£���˿��԰����ۺ����������������ۺ�����������
 *
 */
public class PaperFolding {
    public static void printAllFolds(int N) {
        printProcess(N, 1, true);
    }

    public static void printProcess(int N, int cur, boolean flag) {
        if (cur > N) {
            return;
        }
        printProcess(N, cur + 1, true);
        System.out.println(flag ? "down " : "up ");
        printProcess(N, cur + 1, false);
    }

    public static void main(String[] args) {
        printAllFolds(2);
    }
}
