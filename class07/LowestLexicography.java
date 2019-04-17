package NowCoder.class07;

import java.util.Arrays;
import java.util.Comparator;

/**
 * ���ַ�����������ƴ�ӳɵ���ĸ����С���ַ�����������Կ����ǱȽ�ÿ���ַ������ֵ��򣬵������Ǵ���ģ���ȷ������Ҫ�Ƚ�2���ַ���������ǰ��ʱ����ֵ����С
 * ����Ƚϲ��Ծ���̰�Ĳ���
 *
 * ̰��ֻ��һ�ֽ������Ĳ��ԣ������ÿ�������Ž⣬�Ӷ��ó�ȫ�ֵ����Ž⡣
 * ̰�ĵ�֤�����ѣ�����ͨ������������֤̰�Ĳ��Ե���ȷ��
 */
public class LowestLexicography {
    public static String lowsetLexicography(String[] strs) {
        Arrays.sort(strs, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return (o1 + o2).compareTo(o2 + o1);
            }
        });
        String res = "";
        for (String str : strs) {
            res += str;
        }
        return res;
    }

    public static void main(String[] args) {
        String[] strs1 = { "jibw", "ji", "jp", "bw", "jibw" };
        System.out.println(lowsetLexicography(strs1));

        String[] strs2 = { "ba", "b" };
        System.out.println(lowsetLexicography(strs2));
    }
}
