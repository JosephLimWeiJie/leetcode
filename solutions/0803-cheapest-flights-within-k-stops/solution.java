class Solution {
    // Time: O (K x E)
    // Space: O(V + E)
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        // Start bellman ford algo
        int[] distances = new int[n];
        Arrays.fill(distances, Integer.MAX_VALUE);
        distances[src] = 0;

        for (int i = 0; i <= k; i++) {
            int[] tempDistances = Arrays.copyOf(distances, n);

            for (int[] flight : flights) {
                int source = flight[0];
                int target = flight[1];
                int distance = flight[2];

                if (distances[source] != Integer.MAX_VALUE && distances[source] + distance < tempDistances[target]) {
                    tempDistances[target] = distances[source] + distance;
                }

            }

            distances = tempDistances;
        }

        return distances[dst] == Integer.MAX_VALUE ? -1 : distances[dst];
    }
}
