package SegmentTree;

public class SegmentTree<E> {

    private E[] data;
    private E[] tree;
    private Merge<E> merge;

    /**
     * 构造线段树
     * @param arr 待构造为线段树的数组
     * @param merge 自定义的线段树各节点值的形成方式
     */
    public SegmentTree(E[] arr,Merge<E> merge){
        this.merge = merge;
        data = (E[])new Object[arr.length];
        for(int i = 0;i < arr.length;i++){
            data[i] = arr[i];
        }
        tree = (E[])new Object[4 * arr.length];
        buildSegmentTree(0,0,data.length - 1);
    }


    /**
     * 构建线段树
     * @param index 当前构建节点索引
     * @param l 当前构建节点所表示的线段区间的起始位置[l,r]，对应的是原数组中第l个元素直第r个元素
     * @param r 当前构建节点所表示的线段区间的终止位置[l,r]
     */
    private void buildSegmentTree(int index,int l,int r){
        if(l == r){
            tree[index] = data[l];
            return;
        }
        int mid = l + (r - l) / 2;
        int left = leftChild(index);
        int right = rightChild(index);

        buildSegmentTree(left,l,mid);
        buildSegmentTree(right,mid + 1,r);

        tree[index] = merge.merge(tree[left],tree[right]);
    }

    //返回完全二叉树的数组表示中，一个索引所表示的元素的左孩子的索引
    private int leftChild(int index){
        return 2 * index + 1;
    }

    //返回完全二叉树的数组表示中，一个索引所表示的元素的右孩子的索引
    private int rightChild(int index){
        return 2 * index + 2;
    }

    //返回区间[queryL,queryR]的值
    public E query(int queryL,int queryR){
        if(queryL < 0 || queryL >= data.length || queryR < 0 || queryR >= data.length || queryL > queryR){
            throw new IllegalArgumentException("index is illegal.");
        }
        return query(0,0,data.length - 1,queryL,queryR);
    }

    private E query(int treeIndex,int l,int r,int queryL,int queryR){
        if(l == queryL && r == queryR){
            return tree[treeIndex];
        }

        int mid = l + (r - l) / 2;
        int leftChild = leftChild(treeIndex);
        int rightChild = rightChild(treeIndex);

        E leftRes,rightRes = null;
        if(queryR <= mid){//所查线段都在左子树
            return query(leftChild,l,mid,queryL,queryR);
        }else if(queryL >= mid + 1){//所查线段都在右子树
            return query(rightChild,mid + 1,r,queryL,queryR);
        }else {
            //所查线段跨越左右子树
            leftRes = query(leftChild, l, mid, queryL, mid);
            rightRes = query(rightChild, mid + 1, r, mid + 1, queryR);
        }

        return merge.merge(leftRes,rightRes);
    }

    public int getSize(){
        return data.length;
    }

    public E get(int index){
        if(index < 0 || index >= data.length){
            throw new IllegalArgumentException("index is illegal.");
        }
        return data[index];
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        for(int i = 0;i < tree.length;i++){
            if(tree[i] != null){
                sb.append(tree[i]);
            }else{
                sb.append("null");
            }
            if(i != tree.length - 1){
                sb.append(", ");
            }
        }
        sb.append("]");
        return sb.toString();
    }
}
