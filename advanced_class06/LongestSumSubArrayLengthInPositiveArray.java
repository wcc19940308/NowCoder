package NowCoder.advanced_class06;

/**
 * ����arrȫ��������һ������aim�����ۼӺ͵���aim���������
 * ˫ָ��:С�ڵ����ұ������������������Ϊȫ�������������ԣ�û��0�� ���Կ��Բ���hash��
 * ���������ҵ���0��ʼ��������ÿ��Ԫ����Ϊ��һ��Ԫ���ܹ��ҵ��ĵ���aim���������
 * ����Ϊ��������������������ڣ���ô��ÿ���±꿪ͷ���ۼӺ͵���aim��������һ��ֻ��һ����
 */
public class LongestSumSubArrayLengthInPositiveArray {
    public static int getMaxLength(int[] arr, int aim) {
        if (arr == null || arr.length == 0 || aim < 0) {
            return 0;
        }
        int n = arr.length;
        int sum = arr[0];
        int len = 1;
        int lo = 0, hi = 0;
        while (hi < n) {
            if (sum == aim) {
                len = Math.max(len, hi - lo + 1);
                sum -= arr[lo++];
            } else if (sum < aim) {
                hi++;
                if (hi == n) break;
                sum += arr[hi];
            } else {
                sum -= arr[lo++];
            }
        }
        return len;
    }
}
