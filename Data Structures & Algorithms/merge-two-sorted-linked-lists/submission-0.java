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
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        if(list1 == null){
            return list2;
        }
        if(list2 == null){
            return list1;
        }
        ListNode cur = (list1.val <= list2.val) ? list1 : list2;
        if(cur == list1){
            list1= list1.next;
        }
        else{
            list2 = list2.next;
        }
        ListNode temp = cur;

        while(list1 != null && list2 != null){
            if(list1.val <= list2.val){
                cur.next = list1;
                list1 = list1.next;
            }
            else{
                cur.next = list2;
                list2 = list2.next;
            }
            cur = cur.next;
        }

        if(list1 == null){
            while(list2 != null){
                cur.next = list2;
                list2 = list2.next;
                cur = cur.next;
            }
            
        }
        else{
            while(list1 != null){
                cur.next = list1;
                list1 = list1.next;
                cur = cur.next;
            }
        }
        
        return temp;
        
    }
}