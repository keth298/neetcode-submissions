/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) {
 *         this.val = val;
 *     }
 *     ListNode(int val, ListNode next) {
 *         this.val = val;
 *         this.next = next;
 *     }
 * }
 */
class Solution {
    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode count = head;
        int length = 0;
        while (count != null) {
            count = count.next;
            length++;
        }
        ListNode dummy = new ListNode(0);
        ListNode prevGroupTail = dummy;
        ListNode curr = head;
        for (int i = 0; i < (length / k); i++) {
            ListNode groupHead = curr;
            ListNode prev = null;
            for (int j = 0; j < k; j++) {
                ListNode temp = curr.next;
                curr.next = prev;
                prev = curr;
                curr = temp;
            }
            prevGroupTail.next = prev;
            prevGroupTail = groupHead;
        }
        prevGroupTail.next = curr;
        return dummy.next;
    }
}