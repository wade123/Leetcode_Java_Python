class Solution:
    # @param num, a list of integer
    # @return a list of lists of integer
    def subsetsWithDup(self, S):
        if len(S) == 0: return [[]]
        S.sort()
        res = []
        def dfs(i, lis):
            if i == len(S):
                if lis not in res:
                    res.append(lis)
                return
            else:
                dfs(i + 1, lis)
                dfs(i + 1, lis + [S[i]])
        dfs(0, [])
        return res
