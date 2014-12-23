class Solution:
    # @return a list of lists of integers
    def combine(self, n, k):
        if k == 0:
            return [[]]
        if n == k: 
            return [range(1, n+1)]
        else:
            return self.combine(n-1, k) + [i + [n] for i in self.combine(n-1, k - 1)]
