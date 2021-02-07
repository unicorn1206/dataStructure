package LinkedList;

import queue.ArrayQueue;
import queue.Queue;

public class LinkedListQueue<E> implements Queue<E> {

    private class Node{
        public E e;
        public Node next;

        public Node(E e, Node next){
            this.e = e;
            this.next = next;
        }

        public Node(E e){
            this(e,null);
        }

        public Node(){
            this(null,null);
        }

        @Override
        public String toString(){
            return e.toString();
        }
    }

    private Node head , tail;
    private int size;

    public LinkedListQueue(){
        head = null;
        tail = null;
        size = 0;
    }

    @Override
    public int getSize() {
        return 0;
    }

    @Override
    public boolean isEmpty() {
        return false;
    }

    @Override
    public void enqueue(E e) {
        if(tail == null){
            tail = new Node(e);
            head = tail;
        }else{
            tail.next = new Node(e);
            tail = tail.next;
        }
        size++;
    }

    @Override
    public E dequeue() {
        if (isEmpty()){
            throw new IllegalArgumentException("can not dequeue from an empty queue");
        }
        Node resNode = head;
        head = head.next;
        resNode.next = null;
        //链表中只有一个元素的情况
        if (head == null){
            tail = null;
        }
        size--;
        return resNode.e;
    }

    @Override
    public E getFront() {
        if (isEmpty()){
            throw new IllegalArgumentException("can not dequeue from an empty queue");
        }
        return head.e;
    }

    @Override
    public String toString(){
        StringBuilder res = new StringBuilder("Queue: front ");
        Node cur = head;
        while(cur !=null){
            res.append(cur + "->");
            cur = cur.next;
        }

        res.append("NULL tail");
        return res.toString();
    }

    public static void main(String[] args) {
        LinkedListQueue<Integer> queue = new LinkedListQueue<Integer>();
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
