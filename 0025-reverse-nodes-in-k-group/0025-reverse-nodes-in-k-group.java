/**
 * Definition for singly-linked list.
 * public class ListNode {
 * int val;
 * ListNode next;
 * ListNode() {}
 * ListNode(int val) { this.val = val; }
 * ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public static ListNode reverseList(ListNode head) {
        if (head == null || head.next == null)
            return head;
        ListNode prev = null, temp = head;
        while (temp.next != null) {
            ListNode newNode = temp.next;
            temp.next = prev;
            prev = temp;
            temp = newNode;
        }
        temp.next = prev;
        return temp;
    }

    public static ListNode findKthNode(ListNode head, int k, ListNode prevNode) {
        int j = k - 1;
        ListNode temp = head, temp1 = head;
        while (j-- > 0 && temp != null) {
            temp = temp.next;
        }
        if (temp == null) {
            if (prevNode != null) {
                prevNode.next = head;
            }
            return head;
        }
        ListNode nextNode = temp.next;
        temp.next = null;
        ListNode reverseHead = reverseList(head);
        if (prevNode == null) {
            head = reverseHead;
        } else {
            prevNode.next = reverseHead;
        }
        prevNode = temp1;
        findKthNode(nextNode, k, prevNode);
        return head;
    }

    public ListNode reverseKGroup(ListNode head, int k) {
        if (head == null || head.next == null || k == 1)
            return head;
        head = findKthNode(head, k, null);
        return head;
    }
}