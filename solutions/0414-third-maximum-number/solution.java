class Solution { 
    
    public int thirdMax(int[] nums) {
        long first = nums[0];
        long second = Long.MIN_VALUE;
        long third = Long.MIN_VALUE;   

        for (int i = 1; i < nums.length; i++) {
            int currVal = nums[i];
            
            if (currVal > first) {
                third = second;
                second = first;
                first = currVal;
            } else if (currVal > second && currVal < first) {
                third = second;
                second = currVal;
            } else if (currVal > third && currVal < second) {
                third = currVal;
            }
        }
        
        if (third == Long.MIN_VALUE) {
            return (int) first;
        }
        
        return (int) third;
    }
    
}
