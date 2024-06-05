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

    public int listLength(ListNode head){
        int l = 0;
        while(head!=null){
            l++;
            head = head.next;
        }
        return l;
    }

    public ListNode solve(ListNode head, int k, int l){
        if(k > l) return head;
        ListNode curr = head;
        ListNode prev = null;
        for(int i=0;i<k;i++){
            ListNode cn = curr.next;
            curr.next = prev;
            prev = curr;
            curr = cn;
        }
        head.next = solve(curr, k, l-k);
        return prev; 
    }

    public ListNode reverseKGroup(ListNode head, int k) {
        int l = listLength(head);
        return solve(head, k, l);
    }
}