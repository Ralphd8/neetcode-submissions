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
    public boolean hasCycle(ListNode head) {
        HashSet<ListNode> set = new HashSet<>();
        int count = 0;

        while(count == set.size() && head != null){
            set.add(head);
            count++;
            head = head.next;
        }
        if(head == null){
            return false;
        }
        else{
            return true;
        }
    }
}
