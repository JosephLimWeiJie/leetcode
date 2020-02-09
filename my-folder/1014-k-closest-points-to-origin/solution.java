class Solution {
    public static class Info {
        public int index;
        public int dist;
        
        public Info(int index, int dist) {
            this.index = index;
            this.dist = dist;
        }
    }
    
    public static int squareDist(int x, int y) {
        return (x * x) + (y * y);
    }
    
    public static void swap(Info[] info, int a, int b) {
        Info temp = info[a];
        info[a] = info[b];
        info[b] = temp;
    }
    
    public static int partition(Info[] info, int low, int high) {
        int pivot = info[high].dist;
        int i = low - 1;
        for (int j = low; j < high; j++) {
            if (pivot >= info[j].dist) {
                i++;
                swap(info, i, j);
            }
        }
        
        swap(info, i + 1, high);
        return i + 1;
    }
    
    public static int quickSelect(Info[] info, int low, int high, int k) {
        if (low <= high && k > 0 && k <= (high - low + 1)) {
            int position = partition(info, low, high);
            if (position - low + 1 == k) {
                return position;
            } else if (position - low + 1 > k) {
                return quickSelect(info, low, position - 1, k);
            } else {
                return quickSelect(info, position + 1, high, (k - (position - low + 1)));
            }
        }
        return  -1;
    }
    
    public static int[][] kClosest(int[][] points, int k) {
        Info[] info = new Info[points.length];
        int[][] ans = new int[k][2];
        for (int i = 0; i < points.length; i++) {
            info[i] = new Info(i, squareDist(points[i][0], points[i][1]));
        }
        quickSelect(info, 0, points.length - 1, k);
        for (int j = 0; j < k; j++) {
            ans[j] = points[info[j].index];
        }
        return ans;
    }
}
