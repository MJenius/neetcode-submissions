class Solution {
    public String decodeString(String s) {
        Stack<String> strings=new Stack<>();
        Stack<Integer> counts=new Stack<>();
        int k=0;
        String curr="";
        for (char c:s.toCharArray()) {
            if (Character.isDigit(c)) {
                k=k*10+(c-'0');
            }
            else if (c=='[') {
                strings.push(curr);
                counts.push(k);
                curr="";
                k=0;
            }
            else if (c==']') {
                String temp=curr;
                curr=strings.pop();
                int count=counts.pop();
                for (int i=0;i<count;i++) curr+=temp;
            }
            else curr+=c;
        }
        return curr;
    }
}