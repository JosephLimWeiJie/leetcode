class Solution {
    public int search(int[] nums, int target) {
        return binarySearch(0, nums.length - 1, nums, target);    
    }
    
    public int binarySearch(int left, int right, int[] nums, int target) {
        if (left > right) {
            return -1;
        } 
        
        int mid = (left + right) / 2;
        int curr = nums[mid];
        if (curr > target) {
            return binarySearch(left, mid - 1, nums, target);
        } else if (curr < target) {
            return binarySearch(mid + 1, right, nums, target);
        } else {
            return mid;
        }
    }
}
