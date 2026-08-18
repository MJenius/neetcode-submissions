public class Solution {
    public int trap(int[] height) {
        if (height == null || height.length == 0) return 0;
        int l = 0, r = height.length - 1;
        int maxl = height[l], maxr = height[r];
        int ans = 0;
        while (l < r) {
            if (maxl <= maxr) {
                l++;
                maxl = Math.max(maxl, height[l]);
                ans += maxl - height[l];
            }
            else {
                r--;
                maxr = Math.max(maxr, height[r]);
                ans += maxr - height[r];
            }
        }
        return ans;
    }
}