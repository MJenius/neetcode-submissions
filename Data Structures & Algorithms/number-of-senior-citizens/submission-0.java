class Solution {
    public int countSeniors(String[] details) {
        int ans=0;
        for (String p:details) {
            int age=Integer.parseInt(p.substring(11,13));
            if (age>60) ans++;
        }
        return ans;
    }
}