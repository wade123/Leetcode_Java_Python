class Solution:
    # @return a string
    def convertToTitle(self, num):
        ch = [chr(i) for i in xrange( ord('A'), ord('Z') + 1 ) ]
        res = ""
        while num > 0:
            res += ch[(num-1) % 26]
            num = (num-1)/26
        return res[::-1]

'''One-line Version''' 
# NOTE!! this one-line version is from Leetcode discussion, not written by me.
class Solution:
    # @return a string
    def convertToTitle(self, num):
        return "" if num == 0 else self.convertToTitle((num - 1) / 26) + chr((num - 1) % 26 + ord('A'))
        
