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
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode count = head;
        int length = 0;
        while(count != null){
            length += 1;
            count = count.next;
        }
        if(length == 1) return null;
        ListNode curr = head;
        for(int i = 0; i < Math.max(0, (length - n) % length - 1); i++) curr = curr.next;
        if(curr == head && n == length){
            return head.next;
        } else{
            curr.next = curr.next.next;
            return head;
        }
    }
}
