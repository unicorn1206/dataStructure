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

    private Node head;
    private int size;

    public LinkedList(){
        head = null;
        size = 0;
    }

    public int getSize(){
        return size;
    }

    public boolean isEmpty(){
        return size == 0;
    }

    //在链表头添加新的元素E
    public void addFirst(E e){
//        Node node = new Node(e);
//        node.next = head;
//        head = node;
        head = new Node(e,head);
        size++;
    }

    //在链表的index位置添加新元素
    public void add(E e,int index){
        if(index < 0 || index > size){
            throw new IllegalArgumentException("Add failed. Index is illegal.");
        }
        if(index == 0){
            addFirst(e);
        }else{
            Node prev = head;
            for (int i = 0; i < index - 1; i++) {
                prev = prev.next;
            }
            Node node = new Node(e,prev.next);
            prev.next = node;
            size++;
        }
    }

    //在链表尾部添加元素
    public void addLast(E e){
        add(e,size);
    }


}
