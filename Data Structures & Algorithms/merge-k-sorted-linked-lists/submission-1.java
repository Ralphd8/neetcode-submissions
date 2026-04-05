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
        ListNode head = (list1.val <= list2.val) ? list1 : list2;
        ListNode cur = head;

        list1 = (head == list1) ? list1.next : list1;
        list2 = (head == list2) ? list2.next : list2;

        while(list1 != null && list2 != null){
            ListNode temp = (list1.val <= list2.val) ? list1 : list2;
            cur.next = temp;
            cur = temp;
            list1 = (cur == list1) ? list1.next : list1;
            list2 = (cur == list2) ? list2.next : list2;
        }
        while(list1 == null && list2 != null){
            cur.next = list2;
            cur = cur.next;
            list2 = list2.next;
        }
        while(list2 == null && list1 != null){
            cur.next = list1;
            cur = cur.next;
            list1 = list1.next;
        }
        return head;
    }
    public ListNode mergeKLists(ListNode[] lists) {
        ListNode res = null;
        for(ListNode list : lists){
            res = mergeTwoLists(res,list);
        }
        return res;
    }
}
