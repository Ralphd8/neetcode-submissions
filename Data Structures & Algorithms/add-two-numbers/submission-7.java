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
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode head = new ListNode();
        ListNode cur = head;
        int remaining = 0;
        boolean beg = true;

        while(l1 != null && l2 != null){
            int sum = l1.val + l2.val + remaining;
            if(beg){
                head.val = (sum>9) ? (int) Math.abs(sum - 10) : sum;
                beg = false;
            }
            else{
                ListNode newNode = new ListNode((sum>9) ? (int) Math.abs(sum - 10) : sum);
                cur.next = newNode;
                cur = cur.next;
            }
            remaining = (sum > 9) ? 1 : 0;
            l1 = l1.next;
            l2 = l2.next;
        }
        while(l1 != null){
            int sum = l1.val + remaining;
            if(beg){
                head.val = (sum>9) ? (int) Math.abs(sum - 10) : sum;
                beg = false;
            }
            else{
                ListNode newNode = new ListNode((sum>9) ? (int) Math.abs(sum - 10) : sum);
                cur.next = newNode;
                cur = cur.next;
            }
            remaining = (sum > 9) ? 1 : 0;
            l1 = l1.next;
        }
        while(l2 != null){
            int sum = l2.val + remaining;
            if(beg){
                head.val = (sum>9) ? (int) Math.abs(sum - 10) : sum;
                beg = false;
            }
            else{
                ListNode newNode = new ListNode((sum>9) ? (int) Math.abs(sum - 10) : sum);
                cur.next = newNode;
                cur = cur.next;
            }
            remaining = (sum > 9) ? 1 : 0;
            l2 = l2.next;
        }
        if(remaining == 1){
            ListNode newNode = new ListNode(1);
            cur.next = newNode;
        }
        return head;
    }
}
