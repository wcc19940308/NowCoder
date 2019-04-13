package NowCoder.class03;

/**
 *
 * 用数组实现队列，即循环数组
 *
 * 双指针start和end，分别通过与数组长度curSize进行约束， 通过curSize变量将start和end之间的关系进行解耦
 * 如果end < size 那么可以往里面插入
 * 如果size != 0 那么可以往外拿数
 * 一开始start和end都指向数组的0位置
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
