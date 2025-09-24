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
        // TC -> o(n1 + n2)
        // SC -> o(1)
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
    private ListNode f(int i, ListNode lists[], ListNode head){
        if(i == lists.length - 1){
            return lists[i]; // last list
        }
        ListNode mergedhead = f(i+1, lists, lists[i+1]);
        return mergerSorted(head, mergedhead);
    }
    public ListNode mergeKLists(ListNode[] lists) {
        if(lists == null || lists.length == 0) return null;
        return f(0,lists,lists[0]);
    }
}