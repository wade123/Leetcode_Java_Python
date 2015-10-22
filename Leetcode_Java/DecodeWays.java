public class DecodeWays {
    public int numDecodings(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }
        int[] dp = new int[s.length() + 1];
        if (s.charAt(0) == '0') {
            return 0;
        }
        dp[0] = 1;
        dp[1] = 1;
        for (int i = 2; i <= s.length(); i++) {
            if (s.charAt(i - 1) == '0') {
                if (validPair(s.charAt(i - 2), s.charAt(i - 1))) {
                    dp[i] = dp[i - 2];
                } else {
                    return 0;
                }
            } else {
                if (validPair(s.charAt(i - 2), s.charAt(i - 1))) {
                    dp[i] = dp[i - 1] + dp[i - 2];
                } else {
                    dp[i] = dp[i - 1];
                }
            }
        }
        return dp[s.length()];
    }

    private boolean validPair(char a, char b) {
        return (a == '1' && b >= '0' && b <= '9')
            || (a == '2' && b >= '0' && b <= '6');
    }

    public static void main(String[] args) {
        DecodeWays test = new DecodeWays();
        System.out.println(test.numDecodings("27"));
    }
}