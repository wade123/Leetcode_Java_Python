class Solution:
    # @return an integer
    def reverse(self, x):
        if x < 0:
            return (-1)*self.revpos(-x)
        else:
            return self.revpos(x)
    
    def revpos(self,x):
        x = int(str(x)[::-1])
        if x < 2**31:
            return x
        else:
            return 0
