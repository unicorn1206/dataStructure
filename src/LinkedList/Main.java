package LinkedList;

import queue.ArrayQueue;
import queue.LoopQueue;
import queue.Queue;
import stack.ArrayStack;
import stack.Stack;

import java.util.Random;

public class Main {
    private static double testStack(Stack<Integer> s, int opCount){
        long startTime = System.nanoTime();

        Random random = new Random();
        for(int i = 0;i < opCount;i++){
            s.push(random.nextInt(Integer.MAX_VALUE));
        }

        for(int i = 0;i < opCount;i++){
            s.pop();
        }

        long endTime = System.nanoTime();
        return (endTime - startTime) / 1000000000.0;
    }

    public static void main(String[] args) {
        ArrayStack<Integer> arrayStack = new ArrayStack<>();
        double time1 = testStack(arrayStack,100000);
        System.out.println("ArrayStack ,time:" + time1 + "s");

        LinkedListStack<Integer> linkedListStack = new LinkedListStack<Integer>();
        double time2 = testStack(linkedListStack,100000);
        System.out.println("LinkedListStack ,time:" + time2 + "s");
    }
}
