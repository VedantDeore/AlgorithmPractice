# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def search(self, root,ans,cnt):
        if root is None:
            return     
            
        ans[0] = max(ans[0],cnt)
        
        
        if root.left:
            self.search(root.left, ans, cnt+1)
        
        if root.right:
            self.search(root.right, ans, cnt+1)

        
        
    def maxDepth(self, root: Optional[TreeNode]) -> int:
        ans = [0]
        self.search(root, ans, 1)

        return ans[0]