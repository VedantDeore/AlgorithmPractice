class Solution:
    def isValid(self, s: str) -> bool:
        stack : List[str] = []
        for i in range(len(s)):
            if s[i] == '(' or s[i] == '{' or s[i] == "[":
                stack.append(s[i])
            else:
                if not stack:
                    return False
                
                ch = stack.pop()

                if (s[i] == ')' and ch == '(') or (s[i] == ']' and ch == '[')or (s[i] == '}' and ch == '{'):
                    pass
                else:
                    return False


        return not stack


        