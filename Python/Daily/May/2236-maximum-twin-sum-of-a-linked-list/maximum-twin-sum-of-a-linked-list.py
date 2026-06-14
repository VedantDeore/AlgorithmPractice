# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, val=0, next=None):
#         self.val = val
#         self.next = next
class Solution:
    def pairSum(self, head: Optional[ListNode]) -> int:
        slow = head
        fast = head

        while fast != None and fast.next != None:
            fast = fast.next.next
            slow = slow.next

        mid  = slow
        # print(slow.val)
        curr = mid
        prev = None
        nextt = None
        while curr != None:
            nextt = curr.next
            curr.next = prev
            prev = curr
            curr = nextt
        
        start = head
        curr  = prev
        ans = 0
        while curr != None:
            ans = max(start.val  + curr.val, ans)
            # print(start.val , " " , curr.val , '\n')
            start = start.next
            curr = curr.next

        return ans
