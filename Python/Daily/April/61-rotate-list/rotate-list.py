# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, val=0, next=None):
#         self.val = val
#         self.next = next
class Solution:
    def rotateRight(self, head: Optional[ListNode], k: int) -> Optional[ListNode]:
        if head is None or head.next is None:
            return head
        n = 1
        temp = head
        while temp.next is not None:
            temp = temp.next
            n+=1
        # print(n)
        tail = temp
        k = k%n
        # print(k)
        if k==0:
            return head
        
        dist= n-k

        # print(dist)

        temp = head
        prev = None
        tail.next = head
        for i in range(dist):
            prev = temp
            temp = temp.next
        prev.next =None

        return temp
        
        

        