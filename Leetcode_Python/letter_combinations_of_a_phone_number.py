class Solution:
    # @return a list of strings, [s1, s2]
    def letterCombinations(self, digits):
        d = {'2': ['a', 'b', 'c'],
             '3': ['d', 'e', 'f'],
             '4': ['g', 'h', 'i'],
             '5': ['j', 'k', 'l'],
             '6': ['m', 'n', 'o'],
             '7': ['p', 'q', 'r', 's'],
             '8': ['t', 'u', 'v'],
             '9': ['w', 'x', 'y', 'z'] }
        re = []
        def dfs(i, cmb):
            if i == len(digits):
                re.append(cmb)
            else:
                for letter in d[digits[i]]:
                    dfs(i + 1, cmb + [letter])
        dfs(0, [])
        return [''.join(k) for k in re]
