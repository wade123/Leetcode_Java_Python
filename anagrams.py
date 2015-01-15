class Solution:
    # @param strs, a list of strings
    # @return a list of strings
    def anagrams(self, strs):
        d = {}
        for i in strs:
            if ''.join(sorted(i)) not in d:
                d[''.join(sorted(i))] = [i]
            else:
                d[''.join(sorted(i))].append(i)
        res = []       
        for j in d:
            if len(d[j]) > 1:
                for k in d[j]:
                    res += [k]
        return res
        
