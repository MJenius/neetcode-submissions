class Solution {
    public int maxArea(int[] heights) {
        int l=0,r=heights.length-1,area=0;
        while (l<r) {
            int currarea=Math.min(heights[l],heights[r])*(r-l);
            area=Math.max(currarea,area);
            if (heights[l]<=heights[r]) l++;
            else r--;
        }
        return area;
    }
}
