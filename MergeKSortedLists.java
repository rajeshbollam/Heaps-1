//The idea here is to compare the first nodes in each list, find the minimum among them and add to the result. 
//We move the pointer to the next element of the node in the list which is added to result.
//We keep doing this till all the nodes in all the lists are added to the result list
//We use priority queue for min-heap to find the minimum among all the nodes
//Time Complexity: O(nklogk) where n is the average length of a linkedlist and k is the number of linkedlists
//Space Complexity: O(k)
import java.util.PriorityQueue;

class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}

class Solution {
    public ListNode mergeKLists(ListNode[] lists) {
        PriorityQueue<ListNode> pq = new PriorityQueue<>((a,b) -> a.val-b.val);
        for(ListNode head: lists){
            if(head != null){
                pq.add(head);
            }            
        }
        ListNode dummy = new ListNode(Integer.MIN_VALUE);
        ListNode curr = dummy;
        while(!pq.isEmpty()){
            ListNode minNode = pq.remove();
            curr.next = minNode;
            curr = curr.next;
            if(minNode.next != null){
                pq.add(minNode.next);
            }
        }

        return dummy.next;

    }
}