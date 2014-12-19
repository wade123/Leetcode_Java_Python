class Solution:
    # @param s, a string
    # @return a boolean
    def isPalindrome(self, s):
        if s == ' ':
            return True
        i = 0
        A = []
        while i < len(s):
            if ord('A') <= ord(s[i]) <= ord('Z'):
                A.append(chr( ord(s[i]) + 32) )
                i += 1
            elif ord('a') <= ord(s[i]) <= ord('z'):
                A.append(s[i])
                i += 1
            elif ord('0') <= ord(s[i]) <= ord('9'):
                A.append(s[i])
                i += 1
            else:
                i += 1
        m = 0
        n = len(A) - 1
        while m <= n:
            if A[m] != A[n]:
                return False
            else:
                m += 1
                n -= 1
        return True
