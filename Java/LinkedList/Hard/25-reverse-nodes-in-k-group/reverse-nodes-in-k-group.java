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
    private ListNode getKthNode(ListNode temp, int k){
        k--;
        while(temp != null && k>0){
            k--;
            temp = temp.next;
        }
        return temp;
    }
    private ListNode reverseLinkedList(ListNode head){
        ListNode prev=null;
        ListNode curr=head;
        ListNode next=null;

        while(curr != null){
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        return prev;        
    }
    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode temp = head;
        ListNode prevNode = null;
        
        while(temp != null){
            ListNode kthNode = getKthNode(temp,k);  
            if(kthNode == null){
                if(prevNode != null) prevNode.next = temp;
                break;
            }
            ListNode nextNode = kthNode.next;
            kthNode.next = null;
            reverseLinkedList(temp);
            if(temp == head){
                head = kthNode;
            }else{
                prevNode.next = kthNode;
            }
            prevNode = temp;
            temp= nextNode;
        }
        return head;
    }
}