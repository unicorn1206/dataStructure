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
        }
        data[tail] = e;
        tail = (tail + 1) % data.length;
        size++;
    }

    private void resize(int newCapacity) {
        E[] newData = (E[])new Object[newCapacity + 1];
        for(int i = 0;i < size;i++){
            newData[i] = data[(i + front) % data.length];
        }
        data = newData;
        front = 0;
        tail = size;
    }

    @Override
    public E dequeue() {
        if(isEmpty()){
            throw new IllegalArgumentException("queue is empty.");
        }
        E result = data[front];
        data[front] = null;
        front = (front + 1) % data.length;
        size--;
        if(size == getCapacity() / 4 && getCapacity() / 2 != 0){
            resize(getCapacity() / 2);
        }
        return result;
    }

    @Override
    public E getFront() {
        if(isEmpty()){
            throw new IllegalArgumentException("queue is empty.");
        }
        return data[front];
    }

    @Override
    public String toString(){
        StringBuffer sb = new StringBuffer();
        sb.append(String.format("size=%d,capacity=%d\n",size,getCapacity()));
        sb.append("LoopQueue:front [");
        for (int i = front; i != tail; i = (i + 1) % data.length) {
            sb.append(data[i]);
            if(i != (tail - 1) % data.length){
                sb.append(", ");
            }
        }
        sb.append("] tail");
        return sb.toString();
    }

    public static void main(String[] args) {
        LoopQueue<Integer> queue = new LoopQueue<>();
        for (int i = 0;i < 10;i++){
            queue.enqueue(i);
            System.out.println(queue.toString());

            if(i % 3 == 2){
                queue.dequeue();
                System.out.println(queue.toString());
            }
        }
    }
}
