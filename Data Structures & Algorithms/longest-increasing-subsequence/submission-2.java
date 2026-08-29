class Solution {
    public int lengthOfLIS(int[] nums) {
        List<Integer> seq=new ArrayList<>();
        seq.add(nums[0]);
        for (int i=1;i<nums.length;i++) {
            if (nums[i]>seq.get(seq.size()-1)) seq.add(nums[i]);
            else {
                int pos=binarySearch(nums[i],seq);
                seq.set(pos,nums[i]);
            }
        }
        return seq.size();
    }
    private int binarySearch(int num,List<Integer> seq) {
        int l=0,r=seq.size()-1;
        while (l<r) {
            int mid=(l+r)/2;
            if (mid==num) return mid;
            else if (mid<num) l=mid+1;
            else r=mid;
        }
        return l;
    }
}
