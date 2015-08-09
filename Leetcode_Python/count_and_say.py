class Solution:
    # @return a string
    def countAndSay(self, n):
        if n == 1:
            return '1'
        if n == 2:
            return '11'
        else:
            a = '11'
            for i in xrange(n-2):
                a = self.nextseq(a)
        return a
                
    def nextseq(self, s):
        A = []
        i = 1
        temp = s[0]
        cnt = 1
        while i < len(s):
            if s[i] != temp:
                A.append(str(cnt))
                A.append(temp)
                temp = s[i]
                i += 1
                cnt = 1
                if i == len(s):
                    A.append('1')
                    A.append(temp)
            else:
                cnt += 1
                i += 1
                if i == len(s):
                    A.append(str(cnt))
                    A.append(temp)
        return ''.join(A)
