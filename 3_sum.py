class Solution:
    # @return a list of lists of length 3, [[val1,val2,val3]]
    def threeSum(self, num):
        re = []
        for i in xrange(len(num)-2):
            d = {}
            for j in xrange(i+1, len(num)):
                if -num[i] - num[j] in d:
                    tem = sorted( [num[i], num[j], -num[i] - num[j]] )
                    if tem not in re:
                        re.append(tem)
                else:
                    d[num[j]] = j
        return re
