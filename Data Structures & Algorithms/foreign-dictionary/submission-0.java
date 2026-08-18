class Solution {
    private Map<Character,List<Character>> reversedAdj = new HashMap<>();
    private Map<Character,Boolean> seen = new HashMap<>();
    private StringBuilder ans = new StringBuilder();
    public String foreignDictionary(String[] words) {
        for (String word:words) {
            for (char c:word.toCharArray()) reversedAdj.putIfAbsent(c,new ArrayList<>());
        }
        for (int i=0;i<words.length-1;i++) {
            String word1=words[i];
            String word2=words[i+1];
            if (word1.length()>word2.length() && word1.startsWith(word2)) return "";
            for (int j=0;j<Math.min(word1.length(),word2.length());j++) {
                if (word1.charAt(j)!=word2.charAt(j)) {
                    reversedAdj.get(word2.charAt(j)).add(word1.charAt(j));
                    break;
                }
            }
        }
        for (Character C:reversedAdj.keySet()) {
            boolean res = dfs(C);
            if (!res) return "";
        }
        if (ans.length()<reversedAdj.size()) return "";
        return ans.toString();
    }
    private boolean dfs(Character C) {
        if (seen.containsKey(C)) return seen.get(C);
        seen.put(C,false);
        for (Character next:reversedAdj.get(C)) {
            boolean res=dfs(next);
            if (!res) return false;
        }
        seen.put(C,true);
        ans.append(C);
        return true;
    }
}
