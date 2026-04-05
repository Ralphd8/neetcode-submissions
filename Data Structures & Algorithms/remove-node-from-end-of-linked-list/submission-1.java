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
    public ListNode reverseList(ListNode head) {
        ListNode current = head;
        ListNode previous = null;
        while(current != null){
            ListNode temp = current.next;
            current.next = previous;
            previous = current;
            current = temp;
        }
        return previous;
    }
    public ListNode removeNthFromEnd(ListNode head, int n) {
        if(head == null || head.next == null){
            return null;
        }
        ListNode reverse = reverseList(head);
        if(n == 1){
            reverse = reverse.next;
        }
        else{
            ListNode temp = reverse;
            for(int i=1;i<n-1;i++){
                temp = temp.next;
            }
            temp.next = temp.next.next;
        }
        return reverseList(reverse);
    }
}
