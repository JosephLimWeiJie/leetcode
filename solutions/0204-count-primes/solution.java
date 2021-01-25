class Solution {
    
    public int countPrimes(int n) {
        boolean[] aux = new boolean[n + 1];
        
        if (n < 2) {
            return 0;
        }
        
        int count = 0;
        for (int i = 2; i < n; i++) {
            if (!aux[i]) {
                count++;
                for (int j = i; j <= n; j += i) {
                    aux[j] = true;
                }
            }
        }
        
        return count;
    }
}
