class Solution {
    
    public static boolean checkPossibility(int[] nums) {
        int counter = 0;

        for (int i = 0; i < nums.length - 1; i++) {
            int next = nums[i + 1];
            int curr = nums[i];

            if (curr > next) {
                counter++;
                if (counter > 1) {
                    return false;
                }

                if (i > 0 && nums[i - 1] > nums[i + 1]) {
                    nums[i + 1] = nums[i];
                } else {
                    nums[i] = nums[i + 1];
                }
            }
        }

        return true;
    }
}
