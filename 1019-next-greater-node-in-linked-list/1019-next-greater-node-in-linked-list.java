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
    public int[] nextLargerNodes(ListNode head) {

        int c = 0;
        ListNode temp = head;
        while (temp!=null) {
            c++;
            temp = temp.next;
        }
        
        int[] arr = new int[c];
        int i=0;
        while (head!=null) {
            arr[i++] = head.val;
            head = head.next;
        }

        int n = arr.length;
        int x=0, y=1;
        while (y<n) {
            if (arr[x] < arr[y]) {
                arr[x++] = arr[y];
                y=x+1;
            }
            else y++;

            if (y==n) {
                arr[x] = 0;
                x++;
                y=x+1;
            }
        }

        while (x<n) arr[x++] = 0;

        return arr;
    }
}