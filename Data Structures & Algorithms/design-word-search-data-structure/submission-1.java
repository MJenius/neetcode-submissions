class WordDictionary {
    public TrieNode root;
    public WordDictionary() {
        root=new TrieNode();
    }

    public void addWord(String word) {
        TrieNode node=root;
        for (int i=0;i<word.length();i++) {
            char ch=word.charAt(i);
            if (!node.containsKey(ch)) node.put(ch,new TrieNode());
            node=node.get(ch);
        }
        node.setEnd();
    }

    private boolean searchHelper(String word, int idx, TrieNode node) {
        if (node==null) return false;
        if (idx==word.length()) return node.isEnd();
        char ch=word.charAt(idx);
        if (ch=='.') {
            for (TrieNode child:node.getLinks()) {
                if (child!=null && searchHelper(word,idx+1,child)) return true;
            }
            return false;
        }
        return searchHelper(word,idx+1,node.get(ch));
    }

    public boolean search(String word) {
        return searchHelper(word,0,root);
    }
}
class TrieNode {
    private TrieNode[] links;
    private boolean isEnd;
    public TrieNode() {
        links=new TrieNode[26];
    }
    public boolean containsKey(char ch) {
        return links[ch-'a']!=null;
    }
    public void setEnd() {
        isEnd=true;
    }
    public boolean isEnd() {
        return isEnd;
    }
    public void put(char ch,TrieNode node) {
        links[ch-'a']=node;
    }
    public TrieNode get(char ch) {
        return links[ch-'a'];
    }
    public TrieNode[] getLinks() {
        return links;
    }
}