class Solution {
    public int[] asteroidCollision(int[] asteroids) {
        Stack<Integer> st=new Stack<>();
        for (int a:asteroids) {
            while (!st.isEmpty() && a<0 && st.peek()>0 && Math.abs(a)>st.peek()) st.pop();
            if (st.isEmpty()||a>0||st.peek()<0) st.push(a);
            else if (st.peek()==Math.abs(a)) st.pop();
        }
        int[] ans=new int[st.size()];
        int k=st.size()-1;
        while (k>=0) ans[k--]=st.pop();
        return ans;
    }
}