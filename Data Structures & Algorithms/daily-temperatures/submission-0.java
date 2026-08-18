class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        int n = temperatures.length;
        int[] ans = new int[n];
        ans[n - 1] = 0;
        for (int i = n - 2; i >= 0; i--) {
            int j = i + 1;
            while (j < n && temperatures[j] <= temperatures[i]) {
                if (ans[j] == 0) {
                    j = n; // No warmer day ahead
                } else {
                    j += ans[j]; // Jump to next known warmer day
                }
            }
            ans[i] = (j < n) ? j - i : 0;
        }
        return ans;
    }
}