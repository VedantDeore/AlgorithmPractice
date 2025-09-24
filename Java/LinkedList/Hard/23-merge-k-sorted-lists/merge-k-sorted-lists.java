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
        if(lists == null || lists.length == 0) return null;
        PriorityQueue<ListNode> q = new PriorityQueue<>((a,b)-> a.val - b.val);
        ListNode dummyNode = new ListNode(-1);
        ListNode temp = dummyNode;

        for (ListNode node : lists) {
            if (node != null) {
                q.add(node);
            }
        }
        while (!q.isEmpty()) {
            ListNode current = q.poll();

            temp.next = current;
            if(current.next != null){
                q.add(current.next);
            }
            temp = temp.next;
        }
        return dummyNode.next;
    }
}