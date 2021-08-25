package unionFind;

/**
 * 并查集模式一，quick find模式
 * quick find：判断两个元素是否连接，复杂度O(1)，判断是否连接为O(n)
 */
public class UnionFind1 implements UF{

    /*
    通过数组来存储各元素所属的集合，例如：
    id数组每个index位置的元素值为，所属的集合编号，id[0] = 1，第0各元素属于集合1
    */
    private int[] id;

    public UnionFind1(int size){
        id = new int[size];
        for (int i = 0; i < id.length; i++) {
            id[i] = i;
        }
    }

    /**
     * 合并元素p和元素q所属的集合
     * @param p
     * @param q
     */
    @Override
    public void unionElements(int p, int q) {
        int pId = find(p);
        int qId = find(q);
        if(pId == qId){
            return;
        }
        for (int i = 0; i < id.length; i++) {
            if(id[i] == pId){
                id[i] = qId;
            }
        }
    }

    /**
     * 查看元素p和元素q是否所属同一个集合
     * @param p
     * @param q
     * @return
     */
    @Override
    public boolean isConnected(int p, int q) {
        return find(p) == find(q);
    }

    @Override
    public int getSize() {
        return id.length;
    }

    /**
     * 返回数组id中元素p（index为p的元素）所属的集合编号
     * @param p
     * @return
     */
    private int find(int p){
        if (p < 0 || p >= id.length){
            throw new IllegalArgumentException("p is out of bound.");
        }
        return id[p];
    }
}
