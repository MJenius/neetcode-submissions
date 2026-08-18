class Solution {
    public int compress(char[] chars) {
        int n=chars.length;
        StringBuilder sb=new StringBuilder();
        int i=0;
        while (i<n) {
            sb.append(chars[i]);
            int j=i+1;
            while (j<n && chars[i]==chars[j])j++;
            if (j-i>1) sb.append(String.valueOf(j-i));
            i=j;
        }
        for (int k=0;k<sb.length();k++) {
            chars[k]=sb.charAt(k);
        }
        return sb.length();
    }
}