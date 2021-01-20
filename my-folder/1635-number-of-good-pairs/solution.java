class Solution {
    public int numIdenticalPairs(int[] arr) {

          HashMap<Integer,Integer> hm = new HashMap<>();
          int sum = 0;

          for(int i = 0; i<arr.length; i++ ) {
              if(hm.containsKey(arr[i])){
                sum += hm.get(arr[i]);
              }
              hm.put(arr[i], hm.getOrDefault(arr[i], 0 ) + 1);  
          }
          return sum;

        }
}
