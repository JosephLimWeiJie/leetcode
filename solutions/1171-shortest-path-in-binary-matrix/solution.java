class Solution {

    // Time: O(m * n)
    // Space: O(m * n)
    public int shortestPathBinaryMatrix(int[][] grid) {
        boolean[][] visited = new boolean[grid.length][grid[0].length];

        // If end is not 0, no way to head to end. Return -1.
        if (grid == null || grid.length == 0 || grid[0].length == 0 || grid[0][0] != 0 || grid[grid.length - 1][grid[0].length - 1] != 0) {
            return -1;
        }

        return this.bfs(0, 0, grid, visited);
    }

    private int bfs(int row, int col, int[][] grid, boolean[][] visited) {
        int[][] directions = new int[][]{{1, 0}, {0, 1}, {-1, 0}, {0, -1}, {1, 1}, {1, -1}, {-1, 1}, {-1, -1}};
        Deque<int[]> queue = new ArrayDeque<>();

        queue.push(new int[]{0,0, 1});
        visited[0][0] = true;
        while (!queue.isEmpty()) {
            int[] curr = queue.poll();
            int currR = curr[0];
            int currC = curr[1];
            int length = curr[2];

            // Reach end
            if (currR == grid.length - 1 && currC == grid.length - 1) {
                return length;
            }

            for (int i = 0; i < directions.length; i++) {
                int newR = directions[i][0] + currR;
                int newC = directions[i][1] + currC;

                if (newR >= 0 && newR < grid.length && newC >= 0 && newC < grid[0].length && grid[newR][newC] == 0 && visited[newR][newC] != true) {
                    queue.add(new int[]{newR, newC, length + 1});
                    visited[newR][newC] = true;
                }
            }
        }

        return -1;
    }
}
