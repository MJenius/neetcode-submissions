class Solution {
    public boolean checkInclusion(String s1, String s2) {
        if (s1.length()>s2.length()) return false;
        int[] count = new int[26];
        for (char c:s1.toCharArray()) count[c-'a']++;
        for (char c:s2.toCharArray()) count[c-'a']--;
        for (int i=0;i<s1.length();i++) {
            if (count[s1.charAt(i)-'a']!=0) return false;
        }
        return true;
    }
}
