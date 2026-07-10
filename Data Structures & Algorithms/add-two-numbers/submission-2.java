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
        ListNode curr1 = l1;
        ListNode curr2 = l2;
        ListNode dummy = new ListNode(0);
        ListNode sum = dummy;
        boolean addOne = false;
        while(curr1 != null && curr2 != null){
            int num = addOne? curr1.val + curr2.val + 1: curr1.val + curr2.val;
            ListNode temp;
            if(num > 9){
                temp = new ListNode(num % 10);
                addOne = true;
            } else {
                temp = new ListNode(num);
                addOne = false;
            }
            sum.next = temp;
            sum = sum.next;
            curr1 = curr1.next;
            curr2 = curr2.next;
        }
        while(curr1 != null){
            int num = addOne? curr1.val + 1: curr1.val;
            ListNode temp;
            if(num > 9){
                temp = new ListNode(num % 10);
                addOne = true;
            } else {
                temp = new ListNode(num);
                addOne = false;
            }
            sum.next = temp;
            sum = sum.next;
            curr1 = curr1.next;
        }
        while(curr2 != null){
            int num = addOne? curr2.val + 1: curr2.val;
            ListNode temp;
            if(num > 9){
                temp = new ListNode(num % 10);
                addOne = true;
            } else {
                temp = new ListNode(num);
                addOne = false;
            }
            sum.next = temp;
            sum = sum.next;
            curr2 = curr2.next;
        }
        if(addOne){
            sum.next = new ListNode(1);
        }
        return dummy.next;
    }
}
