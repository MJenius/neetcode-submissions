class Solution {
    public int numDecodings(String s) {
        int prev1=1,prev2=1;
        if (s.charAt(0)=='0') return 0;
        for (int i=1;i<s.length();i++) {
            int curr=0;
            if (s.charAt(i)!='0') curr=prev1;
            int val=Integer.parseInt(s.substring(i-1,i+1));
            if (val>=10 && val<=26) curr+=prev2;
            prev2=prev1;
            prev1=curr;
        }
        return prev1;
    }
}
