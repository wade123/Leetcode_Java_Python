class Solution:
    # @param S, a list of integer
    # @return a list of lists of integer
    def subsets(self, S):
        if len(S) == 0: return [[]]
        S.sort()
        res = []
        def dfs(i, lis):
            if i == len(S):
                res.append(lis)
                return
            else:
                dfs(i + 1, lis)
                dfs(i + 1, lis + [S[i]])
        dfs(0, [])
        return res
