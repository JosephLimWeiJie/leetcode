class Solution {

    // Time: O(N * E log(V))
    // Space: O(E + V)
    public int findTheCity(int n, int[][] edges, int distanceThreshold) {
        // Build adj List (Simplified using computeIfAbsent)
        Map<Integer, List<int[]>> adjList = new HashMap<>();
        for (int[] edge : edges) {
            int from = edge[0];
            int to = edge[1];
            int weight = edge[2];
            
            // BUG FIX 1: Graph is undirected, add BOTH directions
            adjList.computeIfAbsent(from, k -> new ArrayList<>()).add(new int[]{to, weight});
            adjList.computeIfAbsent(to, k -> new ArrayList<>()).add(new int[]{from, weight});
        }

        int ans = -1;
        int min = Integer.MAX_VALUE;
        
        for (int i = 0; i < n; i++) {
            // BUG FIX 2: Pass total cities 'n' AND starting node 'i'
            int num = this.djikstra(n, i, adjList, distanceThreshold);
            
            // BUG FIX 4: Use '<=' to naturally favor greater city IDs on ties
            if (num <= min) {
                min = num;
                ans = i;
            }
        }

        return ans;
    }

    // Pass total cities (totalCities) and the starting point (startNode) separately
    private int djikstra(int totalCities, int startNode, Map<Integer, List<int[]>> adjList, int distanceThreshold) {
        boolean[] visited = new boolean[totalCities];
        int[] distances = new int[totalCities];
        
        // BUG FIX 3: Initialize distances array with Infinity
        Arrays.fill(distances, Integer.MAX_VALUE);
        distances[startNode] = 0;

        PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(x -> x[1]));
        
        // Start from startNode with distance 0
        pq.add(new int[]{startNode, 0});
        
        while (!pq.isEmpty()) {
            int[] currNode = pq.poll();
            int source = currNode[0];
            int currDist = currNode[1];

            if (visited[source]) continue;
            visited[source] = true;
            
            // Optional optimization: Stop parsing edges if the minimum popped distance exceeds threshold
            if (currDist > distanceThreshold) continue; 
            
            List<int[]> neighborEdges = adjList.getOrDefault(source, new ArrayList<>());
            for (int[] edge : neighborEdges) {
                int target = edge[0];
                int weight = edge[1];

                if (distances[source] != Integer.MAX_VALUE && distances[source] + weight < distances[target]) {
                    distances[target] = distances[source] + weight;
                    pq.add(new int[]{target, distances[target]});
                }
            }
        }

        int count = 0;
        for (int i = 0; i < totalCities; i++) {
            // Do not count the starting city itself
            if (i != startNode && distances[i] <= distanceThreshold) {
                count++;
            }
        }

        return count;
    }
}
