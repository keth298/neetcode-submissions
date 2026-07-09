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
    public void reorderList(ListNode head) {
        if (head == null || head.next == null) return;
        int length = 0;
        ListNode count = head;
        while (count != null) {
            length += 1;
            count = count.next;
        }
        int m = (length + 1) / 2;
        ListNode rev = head;
        for (int i = 0; i < m; i++) rev = rev.next;
        
        ListNode prev = null;
        while (rev != null){
            ListNode temp = rev.next;
            rev.next = prev;
            prev = rev;
            rev = temp;
        }
        ListNode curr = head;
        rev = prev;
        while(rev != null){
            ListNode nextCurr = curr.next;
            ListNode nextRev = rev.next;
 
            curr.next = rev;
            rev.next = nextCurr;
 
            curr = nextCurr;
            rev = nextRev;
        }
        curr.next = null;
    }
}
