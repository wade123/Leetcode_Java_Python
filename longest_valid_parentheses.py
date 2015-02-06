class Solution:
    # @param s, a string
    # @return an integer
    def longestValidParentheses(self, s):
        if not s or len(s) <= 1:
            return 0
        stk = []
        Max = 0
        
        for i in xrange(len(s)):
            if stk == []:
                stk.append(i)
            else:
                if s[stk[-1]] == '(' and s[i] == ')':
                    stk.pop()
                    if stk == []:
                        Max = i + 1
                    else:
                        Max = max(Max, i - stk[-1])
                else:
                    stk.append(i)
        return Max
                    
        
        
