class Solution:
    # @param candidates, a list of integers
    # @param target, integer
    # @return a list of lists of integers
    def combinationSum2(self, candidates, target):
        candidates.sort()
        self.length = len(candidates)
        self.res = []
        self.target = target
        self.dfs(candidates, 0, [], 0)
        return self.res
        
    def dfs(self, candidates, i, lis, tem):
        if tem == self.target:
            if lis not in self.res:
                self.res.append(lis)
        for k in xrange(i, self.length):
            if tem + candidates[k] > self.target:
                return
            else:
                self.dfs(candidates, k + 1, lis + [candidates[k]], tem + candidates[k])
        
