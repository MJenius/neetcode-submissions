class Solution {
    public List<Integer> partitionLabels(String s) {
        int pStart=0,pEnd=0;
        List<Integer> ans=new ArrayList<>();
        int[] lastOccurence=new int[26];
        for (int i=0;i<s.length();i++) lastOccurence[s.charAt(i)-'a']=i;
        for (int i=0;i<s.length();i++) {
            pEnd=Math.max(pEnd,lastOccurence[s.charAt(i)-'a']);
            if (i==pEnd) {
                ans.add(pEnd-pStart+1);
                pStart=i+1;
            }
        }
        return ans;
    }
}
