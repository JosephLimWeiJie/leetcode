class Solution {
    
    public int maxIncreaseKeepingSkyline(int[][] grid) {
        
        // Time:  O(n ^ 2)
        // Space: O(n ^ 2)
        int[][] rowFirstGrid = new int[grid.length][grid[0].length];
        int[][] colFirstGrid = new int[grid.length][grid[0].length];        
        
        for (int i = 0; i < grid.length; i++) {
            int rowMax = findRowMax(grid[i]);
            for (int j = 0; j < grid[i].length; j++) {
                rowFirstGrid[i][j] = rowMax;
            }
        }
        
        
        for (int i = 0; i < grid.length; i++) {
            int colMax = findColMax(grid, i);
            for (int j = 0; j < grid[i].length; j++) {
                colFirstGrid[j][i] = colMax;
            }
        }
        
        int sum = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                sum += (Math.min(rowFirstGrid[i][j], colFirstGrid[i][j]) - grid[i][j]);
            }
        }
        
        return sum;
    }
    
    public int findRowMax(int[] array) {
        int max = Integer.MIN_VALUE;
        
        for (int i = 0; i < array.length; i++) {
            if (array[i] > max) {
                max = array[i];
            }
        }
        
        return max;
    }
    
    public int findColMax(int[][] grid, int col) {
        int max = Integer.MIN_VALUE;
        
        for (int i = 0; i < grid.length; i++) {
            if (grid[i][col] > max) {
                max = grid[i][col];
            }
        }
        
        return max;
    }
}
