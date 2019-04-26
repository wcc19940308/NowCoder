package NowCoder.swordToOffer;

/**
 * ��������˳��ʹ����λ��ż��ǰ��:
 * ����һ���������飬ʵ��һ�����������������������ֵ�˳��ʹ�����е�����λ�������ǰ�벿�֣�
 * ���е�ż��λ������ĺ�벿�֣�����֤������������ż����ż��֮������λ�ò��䡣
 */
public class ReOrderArray {
    // ����������߸�������
    public void reOrderArray(int [] array) {
        int n = array.length;
        for (int i = 1; i < n; i++) {
            for (int j = 1; j < i; j++) {
                if (array[j] % 2 != 0 && array[j - 1] % 2 == 0) {
                    swap(array, j, j - 1);
                }
            }
        }
    }

    public void swap(int[] arr, int m, int n) {
        int tmp = arr[m];
        arr[m] = arr[n];
        arr[n] = tmp;
    }
}
