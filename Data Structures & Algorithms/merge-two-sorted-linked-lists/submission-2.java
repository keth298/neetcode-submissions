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
        ListNode dummy = new ListNode(0);
        ListNode curr = dummy;
        while(list1 != null && list2 != null){
            curr.next = list1.val > list2.val? list2: list1;
            if (list1.val > list2.val) list2 = list2.next;
            else list1 = list1.next;
            curr = curr.next;
        }
        if(list1 != null) curr.next = list1;
        else curr.next = list2;
        return dummy.next;
    }
}