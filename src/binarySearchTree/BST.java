package binarySearchTree;

/**
 * 二分搜索树：元素可比较
 * 范型需继承可比较接口满足二分搜索树的条件
 * @param <E>
 */
public class BST<E extends Comparable<E>> {
    private class Node{
        public E e;
        public Node left, right;

        public Node(E e){
            this.e = e;
            left = null;
            right = null;
        }
    }

    public int size;
    public Node root;

    public BST(){
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
    public boolean contains(E e){
        return contains(root,e);
    }

    //看以node为根的二分搜索树中是否包含元素e，递归算法
    private boolean contains(Node node,E e){
        if(node == null){
            return false;
        }

        if(e.compareTo(node.e) == 0){
            return true;
        }else if(e.compareTo(node.e) < 0){
            return contains(node.left,e);
        }else{
            return contains(node.right,e);
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
        System.out.println(node.e);
        traversePreOrder(node.left);
        traversePreOrder(node.right);
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
        System.out.println(node.e);
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
        System.out.println(node.e);
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
        res.append(generateDepthString(depth) + node.e + "\n");
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

    //方法二：1/2
    //向二分搜索树中添加元素
    public void add(E e,int i){
        root = add(root,e,i);
    }

    //方法二：2/2
    private Node add(Node node,E e,int depth){
        if(node == null){
            size++;
            return new Node(e);
        }

        if(e.compareTo(node.e) < 0){
            node.left = add(node.left,e,depth + 1);
        }else if(e.compareTo(node.e) > 0){
            node.right = add(node.right,e,depth + 1);
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
