class Solution {
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {

        int m = image.length;
        int n = image[0].length;

        int[][] ans = new int[m][n];

        // Copy original matrix
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                ans[i][j] = image[i][j];
            }
        }

        int original = image[sr][sc];

        if (original == color) {
            return ans;
        }

        Queue<int[]> q = new LinkedList<>();

        q.add(new int[]{sr, sc});
        ans[sr][sc] = color;

        int[][] dir = {
            {-1, 0},
            {1, 0},
            {0, -1},
            {0, 1}
        };

        while (!q.isEmpty()) {

            int[] curr = q.poll();

            int r = curr[0];
            int c = curr[1];

            for (int[] d : dir) {

                int nr = r + d[0];
                int nc = c + d[1];

                if (nr >= 0 && nr < m &&
                    nc >= 0 && nc < n &&
                    image[nr][nc] == original &&
                    ans[nr][nc] != color) {

                    ans[nr][nc] = color;
                    q.add(new int[]{nr, nc});
                }
            }
        }

        return ans;
    }
}



// class Solution {
//     public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        
//         int m = image.length;
//         int n = image[0].length;
//         boolean[][] vis = new boolean[m][n]; 
//         for(sr=0, sr<m ,sr++){
//             for(sc=0, sc<n, sc++){

//             }
//         }
//         // for(sr, sr<image.length; sr++){
//         //     for(sc, sc < ){
//         //         if(grid[sr][sc] == grid[sr+1][sc] || grid[sr][sc] == grid[sr][sc+1] || grid[sr][sc] == grid[sr-1][sc] || grid[i][j] == grid[sr][sc-1]) {
//         //             bfs(i, j, grid, vis);
//         //             grid[sr][sc] += 1;
//         //         }
//         //     }
//         // }
//     }

//     public static bfs(int row, int col, int[][] grid, boolean[] vis){
//         Queue<Integer> = new Linkedlist<>();
//         q.add(img[sr][sc]);
//         vis[i] = true;

//         while(q.size() > 0){
//             int front = q.remove();
//             for()
//         }
//     }
// }