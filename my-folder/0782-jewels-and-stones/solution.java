class Solution {
    public int numJewelsInStones(String jewels, String stones) {
        Map<Character, Integer> map = new HashMap<>();
        
        for (int i = 0; i < jewels.length(); i++) {
            map.put(jewels.charAt(i), 0);    
        }
        
        int ans = 0;
        for (int j = 0; j < stones.length(); j++) {
            if (map.containsKey(stones.charAt(j))) {
                ans++;
            }
        }
        
        return ans;
    }
}
