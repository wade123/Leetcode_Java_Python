class Solution:
    # @param x, a float
    # @param n, a integer
    # @return a float
    def pow(self, x, n):
        if n == 0:  return 1
        return self.powPos(x, n) if n > 0 else 1 / self.powPos(x, -n)

    def powPos(self, x, n):
        if n == 1:  return x
        return self.powPos(x * x, n / 2) if n % 2 == 0 else x * self.powPos(x * x, (n - 1) / 2)
