class Solution:
    # @return a string
    def convertToTitle(self, num):
        ch = [chr(i) for i in xrange( ord('A'), ord('Z') + 1 ) ]
        res = ""
        while num > 0:
            res += ch[(num-1) % 26]
            num = (num-1)/26
        return res[::-1]
