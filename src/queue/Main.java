package queue;

import LinkedList.LinkedListQueue;

import java.util.Random;

public class Main {
    private static double testQueue(Queue<Integer> q,int opCount){
        long startTime = System.nanoTime();

        Random random = new Random();
        for(int i = 0;i < opCount;i++){
            q.enqueue(random.nextInt(Integer.MAX_VALUE));
        }

        for(int i = 0;i < opCount;i++){
            q.dequeue();
        }

        long endTime = System.nanoTime();
        return (endTime - startTime) / 1000000000.0;
    }

    public static void main(String[] args) {
        ArrayQueue<Integer> integerArrayQueue = new ArrayQueue<>();
        double time1 = testQueue(integerArrayQueue,100000);
        System.out.println("ArrayQueue ,time:" + time1 + "s");

        LoopQueue<Integer> loopQueue = new LoopQueue<>();
        double time2 = testQueue(loopQueue,100000);
        System.out.println("LoopQueue ,time:" + time2 + "s");

        LinkedListQueue<Integer> linkedListQueue = new LinkedListQueue<Integer>();
        double time3 = testQueue(linkedListQueue,100000);
        System.out.println("LinkedListQueue ,time:" + time3 + "s");
    }
}
