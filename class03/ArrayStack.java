package NowCoder.class03;

/**
 *
 * 用数组实现栈
 * 数组首端作为栈底，尾端作为栈顶
 * 通过一个index指针来指向下一个应该插入的位置
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
