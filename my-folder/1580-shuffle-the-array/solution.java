class Solution {
    
    public int[] shuffle(int[] nums, int n) {
        int[] firstArr = Arrays.copyOfRange(nums, 0, n);
        int[] secArr = Arrays.copyOfRange(nums, n, nums.length);
        int[] finalArr = new int[nums.length];

        int i = 0;
        int j = 0;
        int k = 0;
        
        while (i < firstArr.length && j < secArr.length) {
            finalArr[k] = firstArr[i];
            k++;
            i++;
            
            finalArr[k] = secArr[j];
            k++; 
            j++;
        }
    
        return finalArr;
    }
    
}
