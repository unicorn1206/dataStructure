package binarySearchTree;

public class TestBST {
    public static void main(String[] args) {
        BST<Integer> integerBST = new BST<>();
        int[] nums = {5,3,6,8,4,2};
        for (int i = 0;i < nums.length;i++) {
            integerBST.add(nums[i],i);
        }
        integerBST.traversePreOrder();
        System.out.println();

        integerBST.inOrder();
        System.out.println();
//
        integerBST.postOrder();
        System.out.println();
        //System.out.println(integerBST.toString());
    }
}
