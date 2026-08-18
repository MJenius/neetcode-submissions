class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int n=nums1.length+nums2.length;
        int[] arr = new int[n];
        int i=0,j=0,k=0;
        double ans=0;
        while (i<nums1.length && j<nums2.length) {
            int val;
            if (nums1[i]<=nums2[j]) {
                val=nums1[i++];
            }
            else val=nums2[j++];
            arr[k++]=val;
            }
        while (i<nums1.length) arr[k++]=nums1[i++];
        while (j<nums2.length) arr[k++]=nums2[j++];

            if (n%2==0) {
                ans=(arr[n/2 -1]+arr[n/2])/2.0;
                return ans;
            }
            else {
                ans=arr[n/2];
                return ans;
            }
        }

}