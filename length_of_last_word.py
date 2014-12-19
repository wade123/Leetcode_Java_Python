class Solution:
	# @param s, a string
    	# @return an integer
    	def lengthOfLastWord(self, s):
        	if s == '': 
			return 0
		i = len(s) - 1
        	while s[i] == ' ' and i >= 0:
			i -= 1
        	le = 0
        	while s[i] != ' ' and i >= 0:
			le += 1
            		i -= 1
        	return le  
