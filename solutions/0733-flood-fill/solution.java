import java.util.*;

class Solution {

    public static int[][] floodFill(int[][] image, int sr, int sc, int newColor) {

        // N, E, S, W
        int[][] directions = new int[][] {{-1, 0}, {0, 1}, {0, -1}, {1, 0}};
        boolean[][] visited = new boolean[image.length][image[0].length];

        int originalColor = image[sr][sc];
        traverseFromSource(image, directions, visited, sr, sc, newColor, originalColor);

        return image;
    }

    public static void traverseFromSource(int[][] image, int[][] directions,
                                   boolean[][] visited, int sr,
                                   int sc, int newColor, int originalColor) {

        visited[sr][sc] = true;
        image[sr][sc] = newColor;

        for (int[] direction : directions) {
            int newX = sr + direction[0];
            int newY = sc + direction[1];

            if (newX < 0 || newX > image.length - 1) {
                continue;
            }

            if (newY < 0 || newY > image[0].length - 1) {
                continue;
            }

            if (!visited[newX][newY]) {
                if (image[newX][newY] == originalColor) {
                    traverseFromSource(image, directions, visited, newX, newY, newColor, originalColor);
                }
            }
        }

    }

    public static void printGrid(int[][] grid) {
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                sb.append(grid[i][j] + ",");
            }
            sb.append("\n");
        }

        System.out.println(sb.toString());
    }

    public static void main(String[] args) {
        int[][] grid = new int[][] {{1,1,1},{1,1,0},{1,0,1}};
        printGrid(grid);

        printGrid(floodFill(grid, 1, 1, 2));
    }
}

