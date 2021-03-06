package com.ywh.ds.queue;

/**
 * 循环队列
 * 队满条件：(tail + 1) % n == head
 * 队空条件：head == tail
 * 元素入队：tail = (tail + 1) % n
 * 元素出队：head = (head + 1) % n
 * 元素个数：head - tail
 *
 * @author ywh
 * @since 2020/10/29/029
 */
public class CircularQueue<T> implements Queue<T> {

    private final Object[] array;

    private final int n;

    private int head = 0;

    private int tail = 0;

    public CircularQueue(int capacity) {
        array = new Object[capacity];
        n = capacity;
    }

    /**
     * 入队
     *
     * @param item
     * @return
     */
    @Override
    public void enqueue(T item) {
        if ((tail + 1) % n == head) {
            throw new RuntimeException();
        }
        array[tail] = item;
        tail = (tail + 1) % n;
    }

    /**
     * 出队
     *
     * @return
     */
    @Override
    public T dequeue() {
        if (head == tail) {
            throw new RuntimeException();
        }
        T ret = (T) array[head];
        head = (head + 1) % n;
        return ret;
    }

    @Override
    public int size() {
        return n;
    }
}
