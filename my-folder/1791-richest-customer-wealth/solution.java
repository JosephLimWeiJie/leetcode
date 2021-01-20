class Solution {
    public int maximumWealth(int[][] accounts) {
        int maxWealth = Integer.MIN_VALUE;
        
        for (int i = 0; i < accounts.length; i++) {
            int currSum = 0;
            
            for (int j = 0; j < accounts[i].length; j++) {
                currSum += accounts[i][j];  
            }
            
            maxWealth = Math.max(maxWealth, currSum);
        }
            
        return maxWealth;
    }
}
