package NowCoder.advanced_class04;

import java.util.HashMap;
import java.util.Map;

/**
 * һ��ԭ���⣺����������⣬˼�� �������е�ÿ��Ԫ�ؽ�β�����
 * δ�����������ۼӺ�Ϊ����ֵ���������
 * �����������ÿ��λ�ý�β���ۼӺ�Ϊ����ֵ���������
 * ˼·��
 * ����iλ�ã���0��iλ�õ��ۼӺ�Ϊsum����Ҫ��iλ�ý�β���ۼӺ�Ϊtarget��������飬ֻҪ�����0��kλ�õ�һ���ۼӺ�Ϊsum - target��λ��k���ɣ���ôk+1 ~ iλ�þ���
 * iλ�ý�β���ۼӺ�Ϊtarget��������飨Ҳ���ܲ��Ǵ�0λ�ÿ�ʼ�ģ�
 */
public class MaxLength {
    public int maxLength(int[] arr, int target) {
        // map��¼�ۼӺ͵�һ�γ��ֵ�λ��
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, -1);
        int sum = 0, maxLen = 0;
        for (int i = 0; i < arr.length; i++) {
            sum += arr[i];
            // ��ʾ��sum - target + 1 �� i���ۼӺ�Ϊtarget
            if (map.containsKey(sum - target)) {
                maxLen = Math.max(maxLen, i - map.get(sum - target));
            }
            // ��һ�γ�������ۼӺ͵�λ��
            if (!map.containsKey(sum)) {
                map.put(sum, i);
            }
        }
        return maxLen;
    }
}
