class Solution {
    // Time: O(E x V)
    // Space: O(E + V)
    public int networkDelayTime(int[][] times, int n, int k) {
        int[] distances = new int[n + 1];
        Arrays.fill(distances, Integer.MAX_VALUE);
        distances[k] = 0;

        // Relax n - 1 times
        for (int i = 0; i < n; i++) {
            boolean isUpdate = false;
            for (int[] edge : times) {
                int to = edge[0];
                int from = edge[1];
                int dist = edge[2];

                if (distances[to] != Integer.MAX_VALUE && distances[to] + dist < distances[from]) {
                    distances[from] = distances[to] + dist;
                    isUpdate = true;
                }
            }

            if (!isUpdate) {
                break;
            }
        }

        int maxTime = 0;
        for (int i = 1; i <= n; i++) {
            if (distances[i] == Integer.MAX_VALUE) return -1; // A node is unreachable
            maxTime = Math.max(maxTime, distances[i]);
        }

        return maxTime;
    }
}
