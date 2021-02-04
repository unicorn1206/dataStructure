package LinkedList;

public class LinkedList<E> {

    private class Node{
        public E e;
        public Node next;

        public Node(E e,Node next){
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

    private Node dummyhead;
    private int size;

    public LinkedList(){
        dummyhead = new Node(null,null);
        size = 0;
    }

    public int getSize(){
        return size;
    }

    public boolean isEmpty(){
        return size == 0;
    }

    //在链表的index位置添加新元素
    public void add(E e,int index){
        if(index < 0 || index > size){
            throw new IllegalArgumentException("Add failed. Index is illegal.");
        }

        Node prev = dummyhead;
        for (int i = 0; i < index; i++) {
            prev = prev.next;
        }
        Node node = new Node(e,prev.next);
        prev.next = node;
        size++;
    }

    public void addFirst(E e) {
        add(e,0);
    }

    //在链表尾部添加元素
    public void addLast(E e){
        add(e,size);
    }


}
