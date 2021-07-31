package MaxHeap;

import java.util.Random;

public class Main {

    public static double testHeap(Integer[] testData,boolean isHeapify){
        long startTime = System.nanoTime();

        MaxHeap<Integer> maxHeap;
        if(isHeapify){
            maxHeap = new MaxHeap<Integer>(testData);
        }else{
            maxHeap = new MaxHeap<Integer>();
            for(int num : testData){
                maxHeap.add(num);
            }
        }

        int[] arr = new int[testData.length];
        for(int i = 0;i < testData.length;i++){
            arr[i] = maxHeap.extraMax();
        }

        for(int i = 1;i < testData.length;i++){
            if(arr[i] > arr[i - 1]){
                throw new IllegalArgumentException("Error");
            }
        }
        System.out.println("Test MaxHeap Completed.");

        long endTime = System.nanoTime();
        return (endTime - startTime) / 1000000000.0;
    }
    public static void main(String[] args) {
        int n = 1000000;

        Random random = new Random();
        Integer[] testData = new Integer[n];
        for(int i = 0;i < n;i++){
            testData[i] = random.nextInt(Integer.MAX_VALUE);
        }
        System.out.println(testHeap(testData,true));
        System.out.println(testHeap(testData,false));

    }
}
