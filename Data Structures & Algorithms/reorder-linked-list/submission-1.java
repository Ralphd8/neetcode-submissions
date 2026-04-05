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

    public void reorderList(ListNode head) {
        if(head == null || head.next == null){
            return;
        }
        int listSize = 0;
        ListNode temp = head;
        while(temp != null){
            listSize++;
            temp = temp.next;
        }
        temp = head;
        for(int i=1;i<=Math.ceil(listSize/2);i++){
            temp = temp.next;
        }
        ListNode reverseList = reverseList(temp);

        ListNode mainList = head.next;
        ListNode current = head;
        int count = 1;
        HashSet<ListNode> set = new HashSet<>();
        set.add(head);
        boolean mainListTurn = false;

        while(count == set.size()){
            if(mainListTurn == false){
                if(set.contains(reverseList)){
                    break;
                }
                current.next = reverseList;
                set.add(reverseList);
                reverseList = reverseList.next;
            }
            else{
                if(set.contains(mainList)){
                    break;
                }
                current.next = mainList;
                set.add(mainList);
                mainList = mainList.next;
            }
            
            current = current.next;
            count++;
            mainListTurn = (mainListTurn == true) ? false : true;
        }
        current.next = null;
    }
}
