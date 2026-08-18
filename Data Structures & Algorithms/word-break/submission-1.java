class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        boolean[] dp = new boolean[s.length()+1];
        Set<String> wordSet=new HashSet<>(wordDict);
        dp[0]=true;
        for (int end=1;end<=s.length();end++) {
            for (int start=end-1;start>=0;start--) if (dp[start] && wordSet.contains(s.substring(start,end))) dp[end]=true;
        }
        return dp[s.length()];
    }
}