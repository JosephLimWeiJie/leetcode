class Solution {
    public List<List<Integer>> groupThePeople(int[] groupSizes) {
        
        // k -> range, v -> list of elements in that specific group size
        Map<Integer, List<Integer>> data = new HashMap<>();
        
        for (int i = 0; i < groupSizes.length; i++) {
            if (!data.containsKey(groupSizes[i])) {
                data.put(groupSizes[i], new ArrayList<Integer>());
            }
            data.get(groupSizes[i]).add(i);
        }

        // O(n + k)
        List<List<Integer>> ans = new ArrayList<>();
        for (Map.Entry<Integer, List<Integer>> entry : data.entrySet()) {
            int size = entry.getKey();
            List<Integer> possibleNums = entry.getValue();
            int count = 0;
            List<Integer> toAdd = new ArrayList<>();
            
            while (!possibleNums.isEmpty()) {
                count++;
                Integer toRemove = possibleNums.remove(possibleNums.size() - 1);
                toAdd.add(toRemove);
                
                if (count % size == 0) {
                    ans.add(toAdd);
                    toAdd = new ArrayList<>();
                }
            }
            
        }
        
        return ans;
            
    }
}
