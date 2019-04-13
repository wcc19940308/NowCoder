package NowCoder.class03;

/**
 *
 * ������ʵ�ֶ��У���ѭ������
 *
 * ˫ָ��start��end���ֱ�ͨ�������鳤��curSize����Լ���� ͨ��curSize������start��end֮��Ĺ�ϵ���н���
 * ���end < size ��ô�������������
 * ���size != 0 ��ô������������
 * һ��ʼstart��end��ָ�������0λ��
 *
 */
public class ArrayQueue {
    int[] arr;
    int start, end, curSize;

    public ArrayQueue(int size) {
        if (size < 0) {
            throw new IllegalArgumentException("the size is error");
        }
        arr = new int[size];
        start = 0;
        end = 0;
        curSize = 0;
    }

    public void push(int num) {
        if (curSize == arr.length) {
            throw new IllegalArgumentException("the queue is full");
        }
        curSize++;
        arr[end] = num;
        end = end == arr.length - 1 ? 0 : end + 1;
    }

    public int poll() {
        if (curSize == 0) {
            throw new IllegalArgumentException("the queue is empty");
        }
        curSize--;
        int tmp = start;
        start = start == arr.length - 1 ? 0 : start + 1;
        return arr[start];
    }

    public Integer peek() {
        if (curSize == 0) {
            return null;
        }
        return arr[start];
    }
}
