package NowCoder.class05;

import java.util.HashMap;
import java.util.Map;

/**
 *
 * ���RandomPoll�ṹ����������
 * insert(key)����ĳ��key���뵽�ýṹ���������ظ����롣
 * delete(key)����ԭ���ڽṹ�е�ĳ��key�Ƴ���
 * getRandom()���ȸ���������ؽṹ�е��κ�һ��key
 *
 * ʹ��2��HashMap��һ��map��¼key����ţ���һ��map��¼��ź�key
 * ��ˣ������ʱ��һ�β���2��map������size++����ôgetRandom()��ʱ��ֻ��ҪMath.random()����0��size���������ֱ�ӻ�����е�key����
 * ����Ϊ�˱�֤delete֮�󲻲����ն����ܹ��������Ȼ�������ģ������һ����¼����ɾ������������¼���Դ�����֤��¼��Ȼ��������(ע�ⲻҪ����)
 *
 */
public class RandomPool {

    public static Map<String, Integer> stringMap = new HashMap<>();
    public static Map<Integer, String> indexMap = new HashMap<>();
    public static int size = 0;

    public static void insert(String key) {
        if (!stringMap.containsKey(key)) {
            stringMap.put(key, size);
            indexMap.put(size, key);
            size++;
        }
    }

    public static void delete(String key) {
        // �ҵ�Ҫɾ�����Ǹ�key��Ӧ�����
        int index = stringMap.get(key);
        // �ҵ�Ҫ�������Ǹ�string
        String string = indexMap.get(--size);
        stringMap.put(string, index);
        indexMap.put(index, string);
        stringMap.remove(key);
        indexMap.remove(size);
    }

    public static String getRandom() {
        if (size == 0) {
            return null;
        }
        int index = (int) (Math.random() * size);
        return indexMap.get(index);
    }

    public static void main(String[] args) {

    }
}
