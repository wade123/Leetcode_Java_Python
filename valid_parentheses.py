class Solution:
    # @return a boolean
    def isValid(self, s):
        if s == '':
            return False
        stk = []
        for i in xrange(len(s)):
            if stk == []:
                stk.append(s[i])
            else:
                temp = stk.pop()
                if not self.pair(temp, s[i]):
                    stk.append(temp)
                    stk.append(s[i])
        if stk == []:
            return True
        return False
        
    def pair(self, a, b):
        if (a == '[' and b == ']') or (a == '{' and b == '}') or (a == '(' and b == ')'):
            return True
        else:
            return False
