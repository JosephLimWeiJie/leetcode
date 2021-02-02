class Solution {
    public boolean checkStraightLine(int[][] coordinates) {
        int width = coordinates[1][0] - coordinates[0][0];
        int height = coordinates[1][1] - coordinates[0][1];
        
        for (int i = 2; i < coordinates.length; i++) {
            int[] curr = coordinates[i];
            int newWidth = curr[0] - coordinates[0][0];
            int newHeight = curr[1] - coordinates[0][1];
            
            if (width * newHeight != height * newWidth) {
                return false;
            }
        }
        
        return true;
    }
}
