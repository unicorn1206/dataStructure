package binarySearchTree;

import java.util.ArrayList;
import java.util.Random;

public class TestBST {
    public static void main(String[] args) {
        BST<Integer> integerBST = new BST<>();
        /*Random random = new Random();
        for(int i = 0;i < 1000;i++){
            integerBST.add(random.nextInt(10000),i);
        }

        ArrayList<Integer> nums = new ArrayList<Integer>();
        while(!integerBST.isEmpty()){
            nums.add(integerBST.removeMin());
        }
        for(int i = 1;i < nums.size();i++){
            if(nums.get(i - 1) > nums.get(i)){
                throw new IllegalArgumentException("Error");
            }
        }
        System.out.println("removeMin test completed");

        for(int i = 0;i < 1000;i++){
            integerBST.add(random.nextInt(10000),i);
        }

        nums = new ArrayList<Integer>();
        while(!integerBST.isEmpty()){
            nums.add(integerBST.removeMax());
        }
        for(int i = 1;i < nums.size();i++){
            if(nums.get(i - 1) < nums.get(i)){
                throw new IllegalArgumentException("Error");
            }
        }
        System.out.println("removeMax test completed");*/
        int[] nums = {5,3,6,8,4,2};
        for (int i = 0;i < nums.length;i++) {
            integerBST.add(nums[i],i);
        }
//        integerBST.levelOrder();
//        System.out.println();
//        integerBST.traversePreOrder();
//        System.out.println();
//
//        integerBST.preOrderNR();
//        System.out.println();

        integerBST.inOrder();
        System.out.println();

//        integerBST.postOrder();
//        System.out.println();
        //System.out.println(integerBST.toString());
    }
}
