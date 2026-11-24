class Solution {
    public int numIslands(char[][] grid) {

        int m = grid.length;
        int n = grid[0].length;

        boolean[][] vis = new boolean[m][n];

        int count = 0;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {

                if (grid[i][j] == '1' && !vis[i][j]) {

                    count++;
                    bfs(i, j, grid, vis);
                }
            }
        }

        return count;
    }

    public void bfs(int r, int c, char[][] grid, boolean[][] vis) {

        Queue<int[]> q = new LinkedList<>();

        q.add(new int[]{r, c});
        vis[r][c] = true;

        int[][] dir = {
            {-1, 0},
            {1, 0},
            {0, -1},
            {0, 1}
        };

        while (!q.isEmpty()) {

            int[] curr = q.poll();

            int row = curr[0];
            int col = curr[1];

            for (int i = 0; i < 4; i++) {

                int nr = row + dir[i][0];
                int nc = col + dir[i][1];

                if (nr >= 0 && nr < grid.length &&
                    nc >= 0 && nc < grid[0].length &&
                    grid[nr][nc] == '1' && !vis[nr][nc]) {

                    vis[nr][nc] = true;
                    q.add(new int[]{nr, nc});
                }
            }
        }
    }
}