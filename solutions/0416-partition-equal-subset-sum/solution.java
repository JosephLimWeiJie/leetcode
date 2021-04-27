class Solution {
    public static boolean canPartition(int[] nums) {
        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
        }
        
        
        if (sum % 2 != 0) {
            return false;
        }

        sum /= 2;
        boolean[] board = new boolean[sum + 1];
        // base case for dynamic programming
        board[0] = true;

        for (int i = 0; i < nums.length; i++) {
            for (int j = sum; j >= nums[i]; j--) {
                if (board[sum] == true) {
                    return true;
                }

                board[j] = board[j] || board[j - nums[i]];
            }
        }

        return false;
    }
}
