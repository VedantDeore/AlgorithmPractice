# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def search(self, root, val):
        if root is None:
            return None
        if root.val == val:
            return root
        if val < root.val:
            return self.search(root.left, val)
        if val > root.val:
            return self.search(root.right, val)

    def searchBST(self, root: Optional[TreeNode], val: int) -> Optional[TreeNode]:
        ans = None
        ans = self.search(root, val) 
        return ans if ans != None else None  
        