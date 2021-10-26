package Trie;

import sun.reflect.generics.tree.Tree;

import java.util.*;

public class Trie {
    /**
     * 内部类：Trie的Node节点
     */
    private class Node{
        public boolean isWord;
        public TreeMap<Character,Node> next;

        public Node(boolean isWord){
            this.isWord = isWord;
            next = new TreeMap<>();
        }

        public Node(){
            this(false);
        }
    }

    private Node root;
    private int size;

    public Trie(){
        root = new Node();
        size = 0;
    }

    /**
     * 获得Trie中存储的单词数量
     * @return
     */
    public int getSize(){
        return size;
    }

    /**
     * 向Trie中添加新单词
     * @param word
     */
    public void add(String word){
        Node cur = root;
        for (int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);
            if(cur.next.get(c) == null){
                cur.next.put(c,new Node());
            }
            cur = cur.next.get(c);
        }
        if(!cur.isWord){
            cur.isWord = true;
            size++;
        }
    }

    /**
     * 查找Trie中是否包含word
     * @param word
     * @return
     */
    public boolean contains(String word){
        Node cur = root;
        for(int i = 0; i < word.length(); i++){
            char c = word.charAt(i);
            if(cur.next.get(c) == null){
                return false;
            }
            cur = cur.next.get(c);
        }
        return cur.isWord;
    }

    /**
     * 查询在Trie中是否包含有prefix为前缀的单词
     * @param prefix
     * @return
     */
    public boolean isPrefix(String prefix){
        Node cur = root;
        for (int i = 0; i < prefix.length(); i++) {
            char c = prefix.charAt(i);
            if(cur.next.get(c) == null){
                return false;
            }
            cur = cur.next.get(c);
        }
        return true;
    }

    public static void main(String[] args) {
        Map<String,String> map = new HashMap<String,String>();
        map.put("a","1");
        map.put("b","2");
        System.out.println(map.get("c"));
        String a = null;
        if(("1").equals(a)){
            System.out.println("a=1");
        }
        if(a.equals("0")){
            System.out.println("a=0");
        }
    }
}
