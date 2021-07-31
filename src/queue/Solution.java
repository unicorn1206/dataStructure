package queue;

import LinkedList.LinkedListQueue;

import java.util.HashMap;
import java.util.Random;
import java.util.PriorityQueue;

public class Solution {
    private static class Freq implements Comparable<Freq>{
        public int e,freq;

        public Freq(int e,int freq){
            this.e = e;
            this.freq = freq;
        }

        @Override
        public int compareTo(Freq another){
            if(this.freq > another.freq){
                return 1;
            }else if(this.freq < another.freq){
                return -1;
            }else{
                return 0;
            }
        }
    }
    public static int[] topKFrequent(int[] nums, int k) {
        HashMap<Integer,Integer> map = new HashMap<>();
        for(int num : nums){
            if(map.containsKey(num)){
                map.put(num,map.get(num) + 1);
            }else{
                map.put(num,1);
            }
        }

        PriorityQueue<Freq> pq = new PriorityQueue<>();
        for(int key : map.keySet()){
            if(!pq.isEmpty()){
                int freq = pq.peek().freq;
                System.out.println(freq);
            }

            if(pq.size() < k){
                pq.offer(new Freq(key,map.get(key)));
            }else if(pq.peek().freq < map.get(key)){
                pq.poll();
                pq.offer(new Freq(key,map.get(key)));
            }
        }

        int[] res = new int[k];
        for (int i = 0; i < k; ++i) {
            res[i] = pq.poll().e;
        }
        return res;
    }


    public static void main(String[] args) {
        int[] nums = {4,1,-1,2,-1,2,3};
        topKFrequent(nums,2);
    }
}
