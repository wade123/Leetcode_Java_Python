class Solution:
    # @param ratings, a list of integer
    # @return an integer
    def candy(self, ratings):
        if not ratings:
            return 0
        if len(ratings) == 1:
            return 1
        A = [1 for i in xrange(len(ratings))]
        for i in xrange(1,len(A)):
            if ratings[i] > ratings[i - 1]:
                A[i] = A[i - 1] + 1
        e = len(A) - 1
        while e >= 1:
            while e >=1 and ratings[e - 1] <= ratings[e]:
                e -= 1
            while e >= 1 and ratings[e - 1] > ratings[e]:
                A[e - 1] = max(A[e] + 1, A[e - 1])
                e -= 1
        return sum(A)
