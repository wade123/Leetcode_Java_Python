class Solution:
    # @return an integer
    def lengthOfLongestSubstring(self, s):
        length = len(s)
        if length <= 1:  return length
        Max = 0
        p = 0
        while p <= length - 2: 
            q = p + 1
            lis = {s[p]: p}
            while q < length and s[q] not in lis:
                lis[s[q]] = q
                q += 1
            cnt = q - p
            if cnt > Max:
                Max = cnt
            if q < length and s[q] in lis:
                p = lis[s[q]]
            p += 1
        return Max
