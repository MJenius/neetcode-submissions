class Solution {
    public int numUniqueEmails(String[] emails) {
        Set<String> unique=new HashSet<>();
        for (String s:emails) {
            String[] split=s.split("@",-1);
            StringBuilder recipient=new StringBuilder();
            for (char c:split[0].toCharArray()) {
                if (c=='.') continue;
                else if (c=='+') break;
                recipient.append(c);
            }
            String mail=recipient+"@"+split[1];
            unique.add(mail);
        }
        return unique.size();
    }
}