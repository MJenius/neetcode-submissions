class Solution {
    private void backtrack(int open,int closed,int n,List<String> ans,StringBuilder stack) {
        if (open==closed && closed==n) {
            ans.add(stack.toString());
            return;
        }
        if (open<n) {
            stack.append('(');
            backtrack(open+1,closed,n,ans,stack);
            stack.deleteCharAt(stack.length()-1);
        }
        if (closed<open) {
            stack.append(')');
            backtrack(open,closed+1,n,ans,stack);
            stack.deleteCharAt(stack.length()-1);
        }
    }


    public List<String> generateParenthesis(int n) {
        // Only add open if opencount<n
        // Only add close if closedcount<open
        // valid if open==closed==n
        StringBuilder stack = new StringBuilder();
        List<String> ans = new ArrayList<>();
        backtrack(0,0,n,ans,stack);
        return ans;
    }
}
