# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def inorder(self, root, arr):
        if root is None:
            return

        self.inorder( root.left, arr)
        if root:
            arr.append(root.val)
        self.inorder( root.right, arr)

    def sortedArrayToBST(self, arr):
        if not arr:
            return None

        mid = len(arr) // 2
        root = TreeNode(arr[mid])
        root.left = self.sortedArrayToBST(arr[:mid])
        root.right = self.sortedArrayToBST(arr[mid+1:])
        return root

    def balanceBST(self, root: Optional[TreeNode]) -> Optional[TreeNode]:
        arr = []
        self.inorder(root, arr)
        return self.sortedArrayToBST(arr)



        
        