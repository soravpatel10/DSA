class Solution {
    public int maxAreaOfIsland(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;

        int maxArea = 0;

        int[] delRow = {-1, 1, 0, 0};
        int[] delCol = {0, 0, -1, 1};

        for (int i = 0; i < n; i++) {

            for (int j = 0; j < m; j++) {
//check grid value is 1
                if (grid[i][j] == 1) {

                    Queue<int[]> q = new LinkedList<>();

                    q.add(new int[]{i, j});
//visited check
                    grid[i][j] = 0;

                    int area = 1;

                    while (!q.isEmpty()) {

                        int[] node = q.poll();

                        int row = node[0];
                        int col = node[1];

                        for (int k = 0; k < 4; k++) {

                            int newRow = row + delRow[k];
                            int newCol = col + delCol[k];

                            if (newRow >= 0 && newRow < n &&
                                newCol >= 0 && newCol < m &&
                                grid[newRow][newCol] == 1) {

                                grid[newRow][newCol] = 0;

                                area++;

                                q.add(new int[]{newRow, newCol});
                            }
                        }
                    }

                    maxArea = Math.max(maxArea, area);
                }
            }
        }

        return maxArea;
    }
}