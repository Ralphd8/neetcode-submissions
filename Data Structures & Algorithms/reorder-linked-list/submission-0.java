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
    
    public void reorderList(ListNode head) {
        if(head == null || head.next == null){
            return;
        }

        ListNode slow = head;
        ListNode fast = head;

        while(fast.next != null && fast != null && fast.next.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }

        ListNode reverse = reverseList(slow.next);
        slow.next = null;

        ListNode firstHalf = head.next;
        ListNode secondHalf = reverse;
        ListNode temp = head;

        int i=0;

        while(firstHalf != null && secondHalf != null){
            if(i % 2 ==0 ){
                temp.next = secondHalf;
                secondHalf = secondHalf.next;
            }
            else{
                temp.next = firstHalf;
                firstHalf = firstHalf.next;
            }
            temp = temp.next;
            i++;
        }

        if(firstHalf == null){
            temp.next = secondHalf;
        }
        else{
            temp.next = firstHalf;
        }
        temp.next.next = null;



    }
}
