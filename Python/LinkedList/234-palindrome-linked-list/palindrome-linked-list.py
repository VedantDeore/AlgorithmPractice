# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, val=0, next=None):
#         self.val = val
#         self.next = next
class Solution:
    def reverseList(self, head: Optional[ListNode]) -> Optional[ListNode]:
        if head is None or head.next is None:
            return head
        prev = None
        curr = head
        next = head

        while next!=None:
            next = curr.next
            curr.next = prev
            prev= curr
            curr= next

        return prev
    def isPalindrome(self, head: Optional[ListNode]) -> bool:
        if head is None or head.next is None:
            return True

        fast = head
        slow = head

        while fast.next != None and fast.next.next != None:
            slow = slow.next
            fast = fast.next.next

        newH = self.reverseList(slow.next)

        first = head
        second = newH

        while second != None:
            if first.val != second.val:
                self.reverseList(newH)
                return False
        
            first = first.next
            second = second.next


        self.reverseList(newH)

        return True