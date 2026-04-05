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
        if(l1 == null){
            return l2;
        }
        if(l2 == null){
            return l1;
        }
        ListNode prev = new ListNode();
        ListNode temp = prev;
        int addition = 0;
        while(l1 != null && l2 != null){
            int sum = l1.val + l2.val + addition;
            addition = 0;
            if(sum > 9){
                addition = 1;
                sum = sum % 10;
            }
            ListNode cur = new ListNode(sum);
            temp.next = cur;
            temp = cur;
            l1 = l1.next;
            l2 = l2.next;
        }
        
        if(l1 == null){
            while(l2!= null){
                int sum = l2.val + addition;
                addition =0;
            if(sum > 9){
                addition = 1;
                sum = sum % 10;
            }
            ListNode cur = new ListNode(sum);
            temp.next = cur;
            temp = cur;
            l2 = l2.next;
            }
        }

        if(l2 == null){
            while(l1!= null){
                int sum = l1.val + addition;
                addition =0;
            if(sum > 9){
                addition = 1;
                sum = sum % 10;
            }
            ListNode cur = new ListNode(sum);
            temp.next = cur;
            temp = cur;
            l1 = l1.next;
            }
        }

        if(addition == 1){
            ListNode cur = new ListNode(1);
            temp.next = cur;
        }
        return prev.next;
    }
}