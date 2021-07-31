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

    //获取链表中某一位置的元素
    public E get(int index){
        if(index < 0 || index > size){
            throw new IllegalArgumentException("Add failed. Index is illegal.");
        }
        Node cur = dummyhead.next;
        for (int i = 0; i < index;i++){
            cur = cur.next;
        }
        return cur.e;
    }

    //获取链表中第一个元素
    public E getFirst(){
        return get(0);
    }

    //获取链表中最后一个元素
    public E getLast(){
        return get(size - 1);
    }

    //修改链表中某一个元素
    public void set(E e,int index){
        if(index < 0 || index >= size){
            throw new IllegalArgumentException("Add failed. Index is illegal.");
        }
        Node cur = dummyhead.next;
        for (int i = 0;i < index;i++){
            cur = cur.next;
        }
        cur.e = e;
    }

    //查找链表中是否包含元素e
    public boolean contains(E e){
        Node cur = dummyhead.next;
        while(cur != null){
            if(cur.e.equals(e)){
                return true;
            }
            cur = cur.next;
        }
        return false;
    }

    //从链表中删除元素
    public E remove(int index){
        if(index < 0 || index >= size){
            throw new IllegalArgumentException("Remove failed. Index is illegal.");
        }
        Node prev = dummyhead;
        for (int i = 0;i < index;i++){
            prev = prev.next;
        }
        Node delNode = prev.next;
        prev.next = delNode.next;
        delNode.next = null;
        size--;
        return delNode.e;
    }

    public E removeFirst(){
        return remove(0);
    }

    public E removeLast(){
        return remove(size - 1);
    }

    public void removeElement(E e){
        Node prev = dummyhead;
        while(prev.next != null){
            if(prev.next.e.equals(e)){
                break;
            }
            prev = prev.next;
        }

        if(prev.next != null) {
            Node delNode = prev.next;
            prev.next = delNode.next;
            delNode = null;
            size--;
        }
    }

    @Override
    public String toString(){
        StringBuilder res = new StringBuilder();
        for (Node cur = dummyhead.next;cur != null;cur = cur.next){
            res.append(cur + "->");
        }
        res.append("NULL");
        return res.toString();
    }

    public static void main(String[] args) {
        LinkedList<Integer> linkedList = new LinkedList<Integer>();
        for (int i = 0;i < 5;i++){
            linkedList.addFirst(i);
            System.out.println(linkedList);
        }
        linkedList.add(666,2);
        System.out.println(linkedList);
        linkedList.remove(2);
        System.out.println(linkedList);
        linkedList.removeFirst();
        System.out.println(linkedList);
        linkedList.removeLast();
        System.out.println(linkedList);
    }
}
