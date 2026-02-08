# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def depth(self, root):
        if root is None:
            return 0

        lh = self.depth(root.left)
        rh = self.depth(root.right)

        if (lh is -1 or rh is -1):
            return -1

        if abs(lh-rh) >1:
            return -1
        
        return 1+ max(lh,rh)
        
    def isBalanced(self, root: Optional[TreeNode]) -> bool:
        if root == None:
            return True

        return True if self.depth(root) != -1 else False
        

        