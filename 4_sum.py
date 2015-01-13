class Solution:
    # @return a list of lists of length 4, [[val1,val2,val3,val4]]
    def fourSum(self, num, target):
        length = len(num)
        if length < 4:  return []
        d = {}
        res = []
        for p in xrange(length - 1):
            for q in xrange(p + 1, length):
                if num[p] + num[q] not in d:
                    d[num[p] + num[q]] = [(p, q)]
                else:
                    d[num[p] + num[q]].append((p, q))
        
        for i in xrange(length - 1):
            for j in xrange(i + 1, length):
                tem = target - num[i] - num[j]
                if tem in d:
                    for s in d[tem]:
                        if j < s[0]:
                            addon = sorted([num[i], num[j], num[s[0]], num[s[1]]])
                            if addon not in res:
                                res.append(addon)
        return res
