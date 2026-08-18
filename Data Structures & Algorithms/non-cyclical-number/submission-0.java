class Solution {
    public boolean isHappy(int n) {
        Set<Integer> set = new HashSet<>();
        while (!set.contains(n)) {
            set.add(n);
            n=SquaredSum(n);
            if (n==1) return true;
        }
        return false;
    }

    private int SquaredSum(int n) {
        int ans=0;
        while (n!=0) {
            int digit=n%10;
            ans+=digit*digit;
            n/=10;
        }
        return ans;
    }
}
