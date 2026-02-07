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
    public ListNode reverse(ListNode head){
        ListNode current = head;
        ListNode prev = null;
        ListNode next = null;
        while(current != null){
            next = current.next;
            current.next = prev;
            prev = current;
            current = next;
        }

        return prev;
    }
    public ListNode doubleIt(ListNode head) {
        if(head == null) return null;

        // Appiled the similar approach in this like we do in Add 2 Numbers

        head = reverse(head);
        ListNode temp = head;
        ListNode dummyNode = new ListNode(-1);
        ListNode current = dummyNode;
        int carry = 0;
        while(temp != null){
            int digit = temp.val;
            int doubled = digit*2;
            doubled += carry;
            ListNode newNode = new ListNode(doubled%10);
            carry = doubled/10;
            current.next = newNode;
            current = newNode;

            temp = temp.next;
        }
        if(carry != 0){
            ListNode newNode = new ListNode(carry);
            current.next = newNode;
        }

        ListNode result = reverse(dummyNode.next);
        return result;
    }
}