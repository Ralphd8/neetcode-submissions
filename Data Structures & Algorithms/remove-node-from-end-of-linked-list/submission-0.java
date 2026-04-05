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
        ListNode prev = null;
        ListNode cur = head;
        while(cur != null){
            ListNode temp = cur.next;
            cur.next = prev;
            prev = cur;
            cur = temp;
        }
        return prev;
    }

    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode reverse = reverseList(head);
        ListNode cur = reverse;

        if(n == 1){
            reverse = reverse.next;
        }
        else{
            int i=1;
            while(i != n-1){
                i++;
                cur = cur.next;
            }
            cur.next = cur.next.next;
        }
        ListNode res = reverseList(reverse);
        return res;

    }
}
