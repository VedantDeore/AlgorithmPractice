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
    private ListNode mergerSorted(ListNode head1, ListNode head2){
        ListNode dummpyNode = new ListNode(-1);
        ListNode temp = dummpyNode;
        ListNode temp1 = head1;
        ListNode temp2 = head2;

        while (temp1 != null && temp2 != null) {
            if(temp1.val > temp2.val){
                temp.next = temp2;
                 temp = temp2;
                temp2 = temp2.next;
            }else{
                temp.next = temp1;
                temp = temp1;
                temp1 = temp1.next;
            }
        }
        if(temp1 != null) temp.next = temp1;
        if(temp2 != null) temp.next = temp2;
        
        return dummpyNode.next;
    }
    public ListNode mergeKLists(ListNode[] lists) {
        if(lists == null || lists.length == 0) return null;
        ListNode head= lists[0];
        for(int i=1;i<lists.length;i++){
            head = mergerSorted(head,lists[i]);
        }
        return head;
    }
}