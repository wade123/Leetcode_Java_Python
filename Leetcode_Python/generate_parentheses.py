class Solution:
    # @param an integer
    # @return a list of string
    def generateParenthesis(self, n):
        if n == 0: return None 
        self.res = res = []
        self.n = n
        self.dfs(0, n, n, '')
        return res

    def dfs(self, flag, l, r, lis):
        if len(lis) == 2 * self.n:
            self.res.append(lis)
            return
        if flag == 0 and l:
            self.dfs(flag + 1, l - 1, r, lis + '(')
        if flag > 0:
            if l:
                self.dfs(flag + 1, l - 1, r, lis + '(')
            if r:
                self.dfs(flag - 1, l, r - 1, lis + ')')
