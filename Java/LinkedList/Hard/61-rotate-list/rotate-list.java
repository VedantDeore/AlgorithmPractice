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
    public ListNode rotateRight(ListNode head, int k) {
        if (head == null || head.next == null || k == 0) return head;
        int len = 1;
        ListNode tail = head;
        while(tail.next !=null){
            len++;
            tail = tail.next;
        }
        k = k%len;
        if(k == 0)return head;
        else{
            tail.next = head;
            int n= len-k;
            ListNode temp = head;
            for(int i=1;i<n;i++){
                temp = temp.next;
            }
            head= temp.next;
            temp.next=null;
        } 
        return head;
    }
}