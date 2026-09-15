class Solution {
    public int largestRectangleArea(int[] heights) {
        int n=heights.length;
        int max=heights[0];
        Stack<Integer> st = new Stack<>();
        for (int i=0;i<=n;i++) {
            int h = (i==n?0:heights[i]);
            while (!st.isEmpty() && heights[st.peek()]>=h) {
                int height=heights[st.pop()];
                int width=0;
                if (st.isEmpty()) width=i;
                else width = i-st.peek()-1;
                max= Math.max(max,height*width);
            }
            st.push(i);
        }
        return max;
    }
}
