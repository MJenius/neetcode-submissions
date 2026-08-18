class Solution {
    public int lengthOfLongestSubstring(String s) {
        Set<Character> seen=new HashSet<>();
        int l=0,ans=0;
        for (int r=0;r<s.length();r++) {
            while (seen.contains(s.charAt(r))) seen.remove(s.charAt(l++));
            seen.add(s.charAt(r));
            ans=Math.max(ans,r-l+1);
        }
        return ans;
    }
}
