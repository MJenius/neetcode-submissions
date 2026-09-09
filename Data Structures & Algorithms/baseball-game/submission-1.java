class Solution {
    public int calPoints(String[] operations) {
        Stack<Integer> st=new Stack<>();
        int ans=0;
        for (String op:operations) {
            if (op.equals("+")) {
                int a=st.pop();
                int b=st.pop();
                st.push(b);
                st.push(a);
                st.push(a+b);
            }
            else if (op.equals("D")) {
                int a=st.pop();
                st.push(a);
                st.push(a*2);
            }
            else if (op.equals("C")) {
                st.pop();
            }
            else {
                st.push(Integer.valueOf(op));
            }
        }
        while (!st.isEmpty()) ans+=st.pop();
        return ans;
    }
}