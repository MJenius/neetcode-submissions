class Solution {
    private void swap(int[] arr,int l,int r) {
        int temp;
        while (l<r) {
            temp=arr[r];
            arr[r]=arr[l];
            arr[l]=temp;
            l++;
            r--;
        }
    }
    public void rotate(int[] nums, int k) {
        int n=nums.length;
        k=k%n;
        swap(nums,0,n-1);
        swap(nums,0,k-1);
        swap(nums,k,n-1);
    }
}