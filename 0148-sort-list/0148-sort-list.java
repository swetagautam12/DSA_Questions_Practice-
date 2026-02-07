/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode sortList(ListNode head) {
        if(head==null)
        {
            return null;
        }
        PriorityQueue<Integer>minHeap= new PriorityQueue<>();
        ListNode current=head;

        while(current!=null)
        {
            minHeap.add(current.val);
            current=current.next;
        }
          
        current=head;
        while(!minHeap.isEmpty())
        {
            current.val=minHeap.poll();
            current=current.next;
        }
        return head;
    }
}