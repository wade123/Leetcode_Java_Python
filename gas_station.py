class Solution:
    # @param gas, a list of integers
    # @param cost, a list of integers
    # @return an integer
    def canCompleteCircuit(self, gas, cost):
        diff = [gas[i] - cost[i] for i in xrange(len(gas))]
        if sum(diff) < 0:
            return -1
        i = 0
        while i < len(diff):
            Sum = 0
            j = i
            while j < len(diff):
                Sum += diff[j]
                if Sum < 0:
                    i = j + 1
                    break
                else:
                    j += 1
            if j == len(diff):
                return i
