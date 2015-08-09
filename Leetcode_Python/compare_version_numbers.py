class Solution:
    # @param version1, a string
    # @param version2, a string
    # @return an integer
    def compareVersion(self, version1, version2):
        v1 = [int(k) for k in version1.split('.')]
        v2 = [int(k) for k in version2.split('.')]
        if len(v1) < len(v2):
            v1 += [0] * ( len(v2) - len(v1) ) 
        if len(v1) > len(v2):
            v2 += [0] * ( len(v1) - len(v2) ) 
        for i in xrange(len(v1)):
            if v1[i] > v2[i]:
                return 1
            elif v1[i] < v2[i]:
                return -1
        return 0
