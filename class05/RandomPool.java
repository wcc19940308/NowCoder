package NowCoder.class05;

import java.util.HashMap;
import java.util.Map;

/**
 *
 * 设计RandomPoll结构，可以做到
 * insert(key)：将某个key加入到该结构，做到不重复加入。
 * delete(key)：将原本在结构中的某个key移除。
 * getRandom()：等概率随机返回结构中的任何一个key
 *
 * 使用2个HashMap，一个map记录key和序号，另一个map记录序号和key
 * 因此，插入的时候一次插入2个map，并且size++，那么getRandom()的时候，只需要Math.random()生成0到size的随机数，直接获得其中的key即可
 * 但是为了保证delete之后不产生空洞，能够让序号仍然是连续的，让最后一条记录补足删除掉的那条记录，以此来保证记录仍然是连续的(注意不要出错)
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
        // 找到要删除的那个key对应的序号
        int index = stringMap.get(key);
        // 找到要交换的那个string
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
