# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def inorder(self,root, currlist,numbers):
        if(root.right is None and root.left is None):
            currlist.append(root.val)
            numbers.append(list(reversed(currlist)))
            currlist.pop()
            return

        if root.left:
            currlist.append(root.val)
            self.inorder(root.left, currlist , numbers)
            currlist.pop()
            # print(root.val + " ")

        if root.right:
            currlist.append(root.val)
            self.inorder(root.right, currlist , numbers)
            currlist.pop()

        return 

    def sumRootToLeaf(self, root: Optional[TreeNode]) -> int:
        numbers : List[List] = []

        self.inorder(root, [], numbers)

        
        ans = 0
        for i in numbers:
            print(i)
            power = 0
            num = 0
            for j in i:
                if j == 1:
                    num += pow(2,power)
                power+=1
            ans += num
        
        return ans