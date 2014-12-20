'''Version 1'''
class Solution:
    # @return an integer
    def romanToInt(self, s):
        d = {'I': 1, 'V': 5, 'X': 10, 'L': 50, 'C': 100, 'D': 500, 'M': 1000}
        if len(s) == 1: 
            return d[s]
        it = 0
        i = 1
        while i < len(s):
            if d[ s[i] ] <= d[ s[i-1] ]:
                it += d[ s[i-1] ]
                i += 1
                if i == len(s):
                    it += d[ s[i-1] ]
            else:
                it += d[ s[i] ] - d[ s[i-1] ]
                i += 2
                if i == len(s):
                    it += d[ s[i-1] ]
        return it

'''Version 2'''
class Solution:
    # @return an integer
    def romanToInt(self, s):
        def stand(a):
            if a == 'I': return 1
            if a == 'V': return 5
            if a == 'X': return 10
            if a == 'L': return 50
            if a == 'C': return 100
            if a == 'D': return 500
            if a == 'M': return 1000
        Si = list(s)
        Sn = map(stand,Si)
        Sn.append(0)
        i = 0
        res = 0
        while i < len(Sn)-1:
            if Sn[i] < Sn[i+1]:
                res += (Sn[i+1] - Sn[i])
                i += 2
            else:
                res += Sn[i]
                i += 1
        return res
