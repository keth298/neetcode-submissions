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
    public ListNode mergeKLists(ListNode[] lists) {
        if (lists.length == 0 || lists[0] == null) return null;
        for(int i = 1; i < lists.length; i++){
            lists[i] = mergeTwoLists(lists[i], lists[i - 1]);
        }
        return lists[lists.length - 1];
    }

    public ListNode mergeTwoLists(ListNode list1, ListNode list2){
        ListNode dummy = new ListNode(0);
        ListNode merge = dummy;
        while(list1 != null && list2 != null){
            if(list1.val <= list2.val){
                merge.next = list1;
                list1 = list1.next;
            } else {
                merge.next = list2;
                list2 = list2.next;
            }
            merge = merge.next;
        }
        if(list1 != null) merge.next = list1;
        else if (list2 != null) merge.next = list2;
        return dummy.next;
    }
}
