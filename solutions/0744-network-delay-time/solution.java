class Solution {
    // Time: O(E log(V))
    // Space: O(E + V)
    public int networkDelayTime(int[][] times, int n, int k) {
        // Set-up - build adj list
        Map<Integer, List<int[]>> adjList = new HashMap<>();
        for (int i = 0; i < times.length; i++) {
            int srcId = times[i][0];
            int tgtId = times[i][1];
            int weight = times[i][2];
            if (adjList.containsKey(srcId)) {
                List<int[]> lst = adjList.get(srcId);
                lst.add(new int[]{tgtId, weight});
                adjList.put(srcId, lst);
            } else {
                List<int[]> lst = new ArrayList<>();
                lst.add(new int[]{tgtId, weight});
                adjList.put(srcId, lst);
            }
        }

        // Assume each point is infinite distance away
        int[] distances = new int[n + 1];
        Arrays.fill(distances, Integer.MAX_VALUE);
        boolean[] visited = new boolean[n + 1];

        // start from node K
        distances[k] = 0;
        PriorityQueue<int[]> minHeap = new PriorityQueue<>(Comparator.comparingInt(x -> x[1]));
        minHeap.add(new int[]{k, 0});

        while (!minHeap.isEmpty()) {
            int[] currNode = minHeap.poll();
            int source = currNode[0];
            int dist = currNode[1];

            if (visited[source]) continue;
            visited[source] = true;

            for (int[] time : adjList.getOrDefault(source, new ArrayList<>())) {
                int target = time[0];
                int distance = time[1];

                if (!visited[target]) {
                    // Relax
                    if (distances[source] + distance < distances[target]) {
                        distances[target] = distances[source] + distance;
                        minHeap.add(new int[]{target, distances[target]});
                    }
                }
            }
        }

        int maxTime = 0;
        for (int i = 1; i <= n; i++) {
            if (distances[i] == Integer.MAX_VALUE) {
                return -1;
            } else {
                maxTime = Math.max(distances[i], maxTime);
            }
        }

        return maxTime;
    }
}
