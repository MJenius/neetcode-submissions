class Solution {
    public List<List<String>> partition(String s) {
        List<List<String>> ans = new ArrayList<>();
        backtrack(ans,new ArrayList<>(),s,0);
        return ans;
    }
    private void backtrack(List<List<String>> ans,List<String> curr,String s,int start) {
        if (start==s.length()) {
            ans.add(new ArrayList<>(curr));
            return;
        } 
        for (int i=start;i<s.length();i++) {
            if (isPallindrome(s,start,i)) {
                curr.add(s.substring(start,i+1));
                backtrack(ans,curr,s,i+1);
                curr.remove(curr.size()-1);
            }
        }
    }
    private boolean isPallindrome(String s,int l,int r) {
        while (l<r) {
            if (s.charAt(l++)!=s.charAt(r--)) return false;
        }
        return true;
    }
}
