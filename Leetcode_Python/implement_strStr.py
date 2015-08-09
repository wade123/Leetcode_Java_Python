class Solution:
    # @param haystack, a string
    # @param needle, a string
    # @return an integer
    def strStr(self, haystack, needle):
        hl = len(haystack)
        nl = len(needle)
        if hl < nl:
            return -1
        if nl == 0:
            return 0
        i = 0
        while i < (hl - nl + 1):
            j = 0
            while j < nl:
                if needle[j] != haystack[i+j]:
                    i += 1
                    break
                else:
                    j += 1
                    if j == nl:
                        return i
        return -1
