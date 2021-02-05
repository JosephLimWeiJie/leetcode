class Solution {
    public int getMaximumGenerated(int n) {
        int[] arr = new int[n + 1];
        
        if (n == 0) {
            return 0;
        }
        
        arr[0] = 0;
        arr[1] = 1;
        int max = arr[1];
        
        boolean isThirdRule = true;
        boolean isFourthRule = false;
        int i = 1;
        while (i * 2 + 1 <= n) {
            if (isThirdRule) {
                arr[2 * i] = arr[i];
                isThirdRule = false;
                isFourthRule = true;
                if (arr[2 * i] > max) {
                    max = arr[2 * i];
                }
            } else {
                arr[2 * i + 1] = arr[i] + arr[i + 1];
                isThirdRule = true;
                isFourthRule = false;
                if (arr[2 * i + 1] > max) {
                    max = arr[2 * i + 1];
                }
                
                i++;
            }   
        }
        
        return max;        
    }
}
