class Solution {
    public boolean isSubsequence(String s, String t) {
        boolean ans=false;
        if (s.equals("")) return true;
        int i=0,j=0;
        while (i<s.length() && j<t.length()) {
            if (t.charAt(j)==s.charAt(i)) {
                i++;
                ans=true;
                if (i==s.length()) return ans;
            }
            j++;
            ans=false;
        }
        return ans;
    }
}