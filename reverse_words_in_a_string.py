class Solution:
    # @param s, a string
    # @return a string
    def reverseWords(self, s):
        p = 0
        re = []
        while p < len(s):
            while p < len(s) and s[p] == ' ':
                p += 1
            q = p
            while q < len(s) and s[q] != ' ':
                q += 1
            if q > p:
                re.append(s[p:q])
            p = q
        return ' '.join(re[::-1])
