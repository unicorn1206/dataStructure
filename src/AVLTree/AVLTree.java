package AVLTree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;


public class AVLTree<K extends Comparable<K>,V> {
    private class Node{
        public K key;
        public V value;
        public Node left, right;
        public int height;

        public Node(K key,V value){
            this.key = key;
            this.value = value;
            left = null;
            right = null;
            height = 1;
        }
    }

    public int size;
    public Node root;

    public AVLTree(){
        size = 0;
        root = null;
    }

    public int size(){
        return size;
    }

    public boolean isEmpty(){
        return size == 0;
    }

    //看二分搜索树中是否包含元素e
    public boolean contains(K key){
        return contains(root,key);
    }

    //看以node为根的二分搜索树中是否包含元素e，递归算法
    private boolean contains(Node node,K key){
        if(node == null){
            return false;
        }

        if(key.compareTo(node.key) == 0){
            return true;
        }else if(key.compareTo(node.key) < 0){
            return contains(node.left,key);
        }else{
            return contains(node.right,key);
        }

    }

    //二分搜索树的前序遍历
    public void traversePreOrder(){
        traversePreOrder(root);
    }

    //前序遍历以node为根的二分搜索树，递归算法
    private void traversePreOrder(Node node){
        if(node == null){
            return;
        }
        System.out.println(node.key);
        traversePreOrder(node.left);
        traversePreOrder(node.right);
    }

    public void preOrderNR(){
        Stack<Node> stack = new Stack<Node>();
        stack.push(root);
        while(!stack.isEmpty()){
            Node cur = stack.pop();
            System.out.println(cur.key);

            if(cur.right != null){
                stack.push(cur.right);
            }
            if(cur.left != null) {
                stack.push(cur.left);
            }
        }
        

    }

    //二分搜索树的中序遍历
    public void inOrder(){
        inOrder(root);
    }

    //中序遍历以node为根的二分搜索树，递归算法
    private void inOrder(Node node){
        if(node == null){
            return;
        }
        inOrder(node.left);
        System.out.println(node.key);
        inOrder(node.right);
    }

    //二分搜索树的后序遍历
    public void postOrder(){
        postOrder(root);
    }

    //后序遍历以node为根的二分搜索树，递归算法
    private void postOrder(Node node){
        if(node == null){
            return;
        }
        postOrder(node.left);
        postOrder(node.right);
        System.out.println(node.key);
    }

    //层序遍历：广度优先遍历
    public void levelOrder(){
        Queue<Node> queue = new LinkedList<Node>();
        queue.add(root);
        while(!queue.isEmpty()){
            Node cur = queue.remove();
            System.out.println(cur.key);

            if(cur.left != null){
                queue.add(cur.left);
            }
            if(cur.right != null) {
                queue.add(cur.right);
            }
        }
    }

    //寻找二分搜索树的最小元素
    public K minimun(){
        if(size == 0){
            throw new IllegalArgumentException("BST is empty");
        }
        Node e = minimun(root);
        return e.key;
    }

    private Node minimun(Node node){
        if(node.left == null){
            return node;
        }
        return minimun(node.left);
    }

    //寻找二分搜索树的最大元素
    public K maximun(){
        if(size == 0){
            throw new IllegalArgumentException("BST is empty");
        }
        Node e = maximun(root);
        return e.key;
    }

    private Node maximun(Node node){
        if(node.right == null){
            return node;
        }
        return maximun(node.right);
    }

    //删除二分搜索树最小值
    public K removeMin(){
        K key= minimun();
        root = removeMin(root);
        return key;
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

    //从二分搜索树中删除任意元素E
    public void remove(K key){
        root = remove(root,key);
    }

    //删除以node为根的二分搜索树中值为e的节点，返回删除后的二分搜索树的根
    private Node remove(Node node,K key){
        if(node == null){
            return null;
        }else if(key.compareTo(node.key) < 0){
            node.left = remove(node.left,key);
            return node;
        }else if(key.compareTo(node.key) > 0){
            node.right = remove(node.right,key);
            return node;
        }else{ //e = node.e
            //待删除节点左子树为空
            if(node.left == null){
                Node rightNode = node.right;
                node.right = null;
                size--;
                return rightNode;
            }
            //待删除节点右子树为空
            if(node.right == null){
                Node leftNode = node.left;
                node.left = null;
                size--;
                return leftNode;
            }

            //待删除节点左右子树均不为空
            //找到比待删除节点大的最小的节点，即待删除节点右子树中最小的节点
            //用这个节点顶替待删除节点的位置
            Node successor = minimun(node.right);
            successor.left = node.left;
            successor.right = removeMin(node.right);

            node.left = node.right = null;
            return successor;
        }
    }

    //删除二分搜索树最大值
    public K removeMax(){
        K maximun = maximun();
        removeMax(root);
        return maximun;
    }

    //删除二分搜索树最大值，并返回删除后的二分搜索树的根
    public Node removeMax(Node node){
        if(node.right == null){
            Node leftNode = node.left;
            node.left = null;
            size--;
            return leftNode;
        }
        node.right = removeMax(node.right);
        return node;
    }

    @Override
    public String toString(){
        StringBuilder res = new StringBuilder();
        generateBSTString(root,0,res);
        return res.toString();
    }

    private void generateBSTString(Node node,int depth,StringBuilder res){
        if(node == null){
            res.append(generateDepthString(depth) + "NULL\n");
            return;
        }
        res.append(generateDepthString(depth) + node.key + "\n");
        generateBSTString(node.left,depth + 1,res);
        generateBSTString(node.right,depth + 1,res);
    }

    private String generateDepthString(int depth) {
        StringBuilder res = new StringBuilder();
        for (int i = 0; i < depth; i++) {
           res.append("--");
        }
        return res.toString();
    }

    //获得node节点的高度
    private int getHeight(Node node){
        if(node == null){
            return 0;
        }
        return node.height;
    }

    //获得节点node的平衡因子
    private int getBalanceFactor(Node node){
        if(node == null){
            return 0;
        }
        return getHeight(node.left) - getHeight(node.right);
    }

    //判断该二叉树是否是一颗二分搜索树
    public boolean isBST(){
        ArrayList<K> keys = new ArrayList<>();
        inOrder(root,keys);
        for(int i = 1;i < keys.size();i++){
            if(keys.get(i - 1).compareTo(keys.get(i)) > 0){
                return false;
            }
        }
        return true;
    }

    //判断该二叉树是不是平衡二叉树
    public boolean isBalanced(){
        return isBalanced(root);
    }

    private boolean isBalanced(Node node){
        if(node == null){
            return true;
        }
        int balanceFactor = getBalanceFactor(node);
        if(Math.abs(balanceFactor) > 1){
            return false;
        }
        return isBalanced(node.left) && isBalanced(node.right);
    }

    private void inOrder(Node node,ArrayList<K> keys){
        if(node == null){
            return;
        }
        inOrder(node.left,keys);
        keys.add(node.key);
        inOrder(node.right,keys);
    }

    //方法二：1/2
    //向二分搜索树中添加元素
    public void add(K key,int i,V value){
        root = add(root,key,value);
    }

    //方法二：2/2
    private Node add(Node node,K key,V value){
        if(node == null){
            size++;
            return new Node(key,value);
        }

        if(key.compareTo(node.key) < 0){
            node.left = add(node.left,key,value);
        }else if(key.compareTo(node.key) > 0){
            node.right = add(node.right,key,value);
        }

        //更新height
        node.height = 1 + Math.max(getHeight(node.left),getHeight(node.right));

        //计算平衡因子
        int balanceFactor = getBalanceFactor(node);
        if(Math.abs(balanceFactor) > 1){
            System.out.println("unbalanced:" + balanceFactor);
        }
        return node;
    }

//    方法一：1/2
    //向二分搜索树中添加元素
//    public void add(E e){
//        if (root == null){
//            root = new Node(e);
//        }else{
//            add(root,e);
//        }
//    }

    //    方法一：2/2
    //向以root为根节点的二分搜索树中添加元素e，递归算法
//    private void add(Node node,E e){
//        if(e.equals(node.e)){
//            return;
//        }else if(e.compareTo(node.e) < 0 && node.left == null){
//            node.left = new Node(e);
//            size++;
//            return;
//        }else if(e.compareTo(node.e) > 0 && node.right == null){
//            node.right = new Node(e);
//            size++;
//            return;
//        }
//
//        if (e.compareTo(node.e) < 0) {
//            add(node.left, e);
//        }else{
//            add(node.right,e);
//        }
//    }
}