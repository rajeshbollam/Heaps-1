//In this approach, we take a Priority Queue(min-heap) of size k and we keep adding all the elements in the array into the priority queue.
//We remove the elements from the start if the set priority queue of size k becomes full.
//Once all elements are inserted, the kth largest element will be at the start of the priority queue.
//Time Complexity: O(nlogk) where n is the length of the array
//Space Complexity: O(k)
import java.util.PriorityQueue;

class Solution {
    public int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for(int num: nums){
            pq.add(num);//logk
            if(pq.size() > k){
                pq.poll();
            }
        }
        return pq.peek();
    }
}


//The approach here is to take a Priority Queue set for max heap of size n-k, where n is the length of the array and we keep adding all the elements in the priority queue.
//The idea here is that the largest k elements do not present in the max heap when all elements in the array are added. So as the queue becomes full while inserting, we keep removing the first element and compare it with the min. value.
//The minimum of the removed elements is the kth largest element
//Time Complexity: O(nlog(n-k))
//Space Complexity: O(k)
class Solution1 {
    public int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> pq = new PriorityQueue<>((a,b) -> b-a);
        int re = Integer.MAX_VALUE;
        for(int num: nums){
            pq.add(num);//log(n-k)
            if(pq.size() > nums.length-k){
                re = Math.min(re, pq.remove());
            }
        }
        return re;
    }
}