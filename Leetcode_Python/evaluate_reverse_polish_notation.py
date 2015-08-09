class Solution:
    # @param tokens, a list of string
    # @return an integer
    def evalRPN(self, tokens):
        if not tokens:
            return None
        stk = []
        ops = ['+', '-', '*', '/']
        while tokens:
            a = tokens.pop(0)
            if a not in ops:
                stk.append(int(a))
            else:
                r = stk.pop()
                l = stk.pop()
                back = self.evaluate(l, r, a)
                stk.append(back)
        return int(stk[0])
    
    def evaluate(self, x, y, op):
        if op == '+':
            return x + y
        elif op == '-':
            return x - y
        elif op == '*':
            return x * y
        else:
            if x * y > 0:
                return x / y
            else:
                return -(-x / y)
        
        
