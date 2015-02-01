class Solution:
    # @return a string
    def minWindow(self, S, T):
        if not S:
            return ''
        d = {}
        for i in T:
            if i in d:
                d[i] += 1
            else:
                d[i] = 1
        left = 0
        count = 0
        minLen = len(S) + 1
        minStart = 0
        for right in xrange(len(S)):
            if S[right] in d:
                d[S[right]] -= 1
                if d[S[right]] >= 0:
                    count += 1
                while count == len(T):
                    if right - left + 1 < minLen:
                        minLen = right - left + 1
                        minStart = left
                    if S[left] in d:
                        d[S[left]] += 1
                        if d[S[left]] > 0:
                            count -= 1
                    left += 1
        if minLen > len(S):
            return ''
        else:
            return S[minStart: minStart + minLen]
