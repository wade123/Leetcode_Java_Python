class MinStack:
    # @param x, an integer
    # @return an integer
    def push(self, x):
        self.stk.append(x)
        if x <= self.min_list[-1]:
            self.min_list.append(x)
        
    # @return nothing
    def pop(self):
        if self.stk[-1] == self.min_list[-1]:
            del self.min_list[-1]
        del self.stk[-1]

    # @return an integer
    def top(self):
        return self.stk[-1]

    # @return an integer
    def getMin(self):
        return self.min_list[-1]
    
    def __init__(self):
        self.stk = []
        self.min_list = [float("inf")]
