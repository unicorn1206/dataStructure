package unionFind;

/**
 * 并查集模式六，路径压缩到底，每个节点直接指向它的父节点，没有中间节点
 * find方法中通过递归find方法实现
 */
public class UnionFind6 implements UF {

    private int[] parent;
    private int[] rank;//rank[i]表示以i为根的集合所表示的树的层数

    public UnionFind6(int size){
        parent = new int[size];
        rank = new int[size];
        for (int i = 0; i < parent.length; i++) {
            parent[i] = i;
            rank[i] = 1;
        }
    }

    @Override
    public void unionElements(int p, int q) {
        int pRoot = find(p);
        int qRoot = find(q);

        if (pRoot == qRoot){
            return;
        }

        //根据两个元素所在树的高度不同判断合并方向
        //将高度低的集合指向（合并）到高度高的集合上
        if(rank[pRoot] < rank[qRoot]){
            parent[pRoot] = qRoot;
        }else if(rank[pRoot] > rank[qRoot]){
            parent[qRoot] = pRoot;
        }else{ //rank[pRoot] == rank[qRoot]
            parent[pRoot] = qRoot;
            rank[qRoot] += 1;
        }

    }

    @Override
    public boolean isConnected(int p, int q) {
        return find(p) == find(q);
    }

    @Override
    public int getSize() {
        return parent.length;
    }

    /**
     * 查看index=p的元素的根节点
     * @param p
     * @return
     */
    private int find(int p){
        if (p < 0 || p >= parent.length){
            throw new IllegalArgumentException("p is out of bound.");
        }
        if(p != parent[p]){
            parent[p] = find(parent[p]);
        }
        return parent[p];
    }
}
