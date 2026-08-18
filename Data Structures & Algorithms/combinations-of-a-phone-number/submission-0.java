class Solution {
    private String[] map={"","","abc","def","ghi","jkl","mno","pqrs","tuv","wxyz"};
    public List<String> letterCombinations(String digits) {
        List<String> ans = new ArrayList<>();
        if (digits.length()==0) return ans;
        backtrack(ans,digits,"",0);
        return ans;
    }
    private void backtrack(List<String> ans,String digits,String curr,int idx) {
        if (idx==digits.length()) {
            ans.add(curr);
            return;
        }
        String letters=map[digits.charAt(idx)-'0'];
        for (char letter:letters.toCharArray()) backtrack(ans,digits,curr+letter,idx+1);
    }
}
