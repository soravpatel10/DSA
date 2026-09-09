// class Solution {
//     public int minFallingPathSum(int[][] grid) {
//         int n = grid.length;
//         int ans  = Integer.MAX_VALUE;

//         for(int col=0; col<n ; col++){
//             ans = Math.min(ans, solve(0, col, grid));
//         }
//         return ans;
//     }
//
//     public int solve(int row, int col, int[][] grid){
//         int n = grid.length;
//         if(row == n-1){
//             return grid[row][col];
//         }

//         int ans = Integer.MAX_VALUE;
//         for(int nextCol=0; nextCol<n; nextCol++){
//             if(nextCol != col){
//                 int path = solve(row+1, nextCol, grid);
//                 ans = Math.min(ans,path);
//             }
//         }
//         return grid[row][col] + ans;

//     }
// }

class Solution {
    public int minFallingPathSum(int[][] grid) {
        int n = grid.length;
        int ans = Integer.MAX_VALUE;
        ArrayList<ArrayList<Integer>> dp = new ArrayList<>();
        for(int i=0; i<n; i++){
            ArrayList<Integer> row = new ArrayList<>();

            for(int j=0; j<n; j++){
                row.add(null);
            }
            dp.add(row);
        }

        ans = Integer.MAX_VALUE;

        for(int col=0; col<n; col++){
            ans = Math.min(ans, solve(0, col, grid,dp));
        }
        return ans;
    }

    public int solve(int row, int col, int[][] grid, ArrayList<ArrayList<Integer>> dp){
        int n = grid.length;
        if(row == n-1){
            return grid[row][col];
        }

        if(dp.get(row).get(col) != null){
            return dp.get(row).get(col);
        }

        int ans = Integer.MAX_VALUE;

        for(int nextCol=0; nextCol < n; nextCol++){
            if(nextCol != col){
                ans = Math.min(ans, solve(row+1, nextCol, grid, dp));
            }
        }

        int result = grid[row][col] +ans;
        dp.get(row).set(col, result);
        return result;
    }
}