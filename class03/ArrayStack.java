package NowCoder.class03;

/**
 *
 * ������ʵ��ջ
 * �����׶���Ϊջ�ף�β����Ϊջ��
 * ͨ��һ��indexָ����ָ����һ��Ӧ�ò����λ��
 *
 */
public class ArrayStack {
    int[] arr;
    int index;
    int size;

    public ArrayStack(int size) {
        if (size < 0) {
            throw new IllegalArgumentException("stack size is error");
        }
        this.index = 0;
        this.size = size;
        arr = new int[size];
    }

    public void push(int num) {
        if (index == size) {
            throw new IllegalArgumentException("stack is full");
        }
        arr[index++] = num;
    }

    public Integer pop() {
        if (index == 0) {
            throw new IllegalArgumentException("stack is empty");
        }
        return arr[--index];
    }

    public Integer peek() {
        if (index == 0) {
            return null;
        }
        return arr[index - 1];
    }
}
