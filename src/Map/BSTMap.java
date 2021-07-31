package Map;

import binarySearchTree.BST;

public class BSTMap<K extends Comparable<K>,V> implements Map<K,V> {
    private class Node{
        public K key;
        public V value;
        public Node left, right;

        public Node(K key,V value){
            this.key = key;
            this.value = value;
            left = null;
            right = null;
        }
    }

    private Node root;
    private int size;

    public BSTMap(){
        size = 0;
        root = null;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public int getSize() {
        return size;
    }
    @Override
    public void add(K key, V value) {
        root = add(root,key,value);
    }

    private Node add(Node node,K key,V value){
        if(node == null){
            size++;
            return new Node(key,value);
        }
        if(node.key.compareTo(key) < 0){
            node.right = add(node.right,key,value);
        }else if(node.key.compareTo(key) > 0){
            node.left = add(node.left,key,value);
        }else{
            node.value = value;
        }
        return node;
    }

    private Node getNode(Node node,K key){
        if(node == null){
            return null;
        }
        if(key.compareTo(node.key) < 0){
            return getNode(node.left,key);
        }else if(key.compareTo(node.key) > 0){
            return getNode(node.right,key);
        }else{
            return node;
        }
    }

    @Override
    public boolean contains(K key) {
        return getNode(root,key) != null;
    }


    @Override
    public void set(K key, V newValue) {
        Node node = getNode(root,key);
        if(node == null){
            throw new IllegalArgumentException(key + "doesn't exist.");
        }
        node.value = newValue;
    }

    @Override
    public V get(K key) {
        Node node = getNode(root,key);
        return node != null ? node.value : null;
    }

    @Override
    public V remove(K key) {
        Node node = getNode(root,key);
        if(node != null){
            root = remove(root,key);
            return node.value;
        }
        return null;
    }

    private Node remove(Node node,K key){
        if(node == null){
            return null;
        }

        if(key.compareTo(node.key) > 0){
            node.right = remove(node.right,key);
            return node;
        }else if(key.compareTo(node.key) < 0){
            node.left = remove(node.left,key);
            return node;
        }else{
            //待删除节点左子树为空
            if(node.left == null){
                Node rightNode = node.right;
                node.right = null;
                size--;
                return rightNode;
            }else if(node.right == null){
                Node leftNode = node.left;
                node.left = null;
                size--;
                return leftNode;
            }else{
                Node successor = minimun(node.right);
                successor.right = removeMin(node.right);
                successor.left = node.left;
                node.left = node.right = null;
                size--;
                return node;
            }
        }

    }

    private Node minimun(Node node){
        if(node.left == null){
            return node;
        }
        return minimun(node.left);
    }

    public Node minimun(){
        if(size == 0){
            throw new IllegalArgumentException("BST is empty");
        }
        Node e = minimun(root);
        return e;
    }

    //删除二分搜索树最小值
    public Node removeMin(){
        Node e = minimun();
        root = removeMin(root);
        return e;
    }

    //删除二分搜索树最小值，并返回删除后的二分搜索树的根
    private Node removeMin(Node node){
        if(node.left == null){
            Node rightNode = node.right;
            node.right = null;
            size--;
            return rightNode;
        }
        node.left = removeMin(node.left);
        return node;
    }

}
