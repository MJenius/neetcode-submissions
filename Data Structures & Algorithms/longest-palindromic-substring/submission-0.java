class Solution {
    public String longestPalindrome(String s) {
        int n = s.length();
        boolean[][] dp = new boolean[n][n];
        int maxStart = 0, maxLen = 1;
        for (int len = 1; len <= n; len++) {
            for (int i = 0; i + len - 1 < n; i++) {
                int j = i + len - 1;
                if (s.charAt(i) == s.charAt(j)) {
                    if (len <= 2 || dp[i + 1][j - 1]) {
                        dp[i][j] = true;
                        if (len > maxLen) {
                            maxLen = len;
                            maxStart = i;
                        }
                    }
                }
            }
        }
        return s.substring(maxStart, maxStart + maxLen);
    }
}