class Solution {
    public boolean isPerfectSquare(int num) {
        long l=0;
        long r=num;
        while (l<=r) {
            long mid=l+(r-l)/2;
            if (mid*mid==num) return true;
            if (mid*mid<num) l=mid+1;
            if (mid*mid>num) r=mid-1;
        }
        return false;
    }
}