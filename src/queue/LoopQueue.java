package queue;

public class LoopQueue<E> implements Queue<E> {
    private E[] data;
    private int front,tail;
    private int size;

    private LoopQueue(int capacity){
        data = (E[])new Object[capacity + 1];
        front = 0;
        tail = 0;
        size = 0;
    }

    public LoopQueue(){
        this(10);
    }

    //用户实际指定的容量
    public int getCapacity(){
        return data.length - 1;
    }

    @Override
    public int getSize() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return front == tail;
    }

    @Override
    public void enqueue(E e) {
        //队列是否已满
        if((tail + 1) % data.length == front){
            resize(getCapacity() * 2);
        }else{
            data[tail] = e;
            tail = (tail + 1) % size;
        }
    }

    private void resize(int newCapacity) {
        E[] newData = (E[])new Object[newCapacity + 1];
    }

    @Override
    public E dequeue() {
        return null;
    }

    @Override
    public E getFront() {
        return null;
    }
}
