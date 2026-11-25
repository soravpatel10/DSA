// class Solution {
//     public int islandPerimeter(int[][] grid) {
//         int count = 0;

//         for(int i=0; i<grid.length; i++){
//             for(int j=0; j<grid[0].length; j++){
//                 if(grid[i][j] == 1){
//                     count+=4;
                

//                 if(i>0 && grid[i-1][j]==1){
//                     count--;
//                 }

//                 if(j>0 && grid[i][j-1]==1){
//                     count--;
//                 }

//                 if(i<grid.length-1 && grid[i+1][j]==1){
//                     count--;
//                 }
                
//                 if(j<grid[0].length-1 && grid[i][j+1]==1){
//                     count--;
//                 }
//                 }
//             }
//         }
//         return count;
//     }
// }

class Solution {
    public int islandPerimeter(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1) {
                    return dfs(grid, i, j);
                }
            }
        }

        return 0;
    }

    public int dfs(int[][] grid, int i, int j) {

        if (i < 0 || j < 0 ||
            i >= grid.length || j >= grid[0].length ||
            grid[i][j] == 0) {
            return 1;
        }

        if (grid[i][j] == 2) {
            return 0;
        }

        grid[i][j] = 2;

        int perimeter = 0;

        perimeter += dfs(grid, i + 1, j);  
        perimeter += dfs(grid, i - 1, j); 
        perimeter += dfs(grid, i, j + 1); 
        perimeter += dfs(grid, i, j - 1); 

        return perimeter;
    }
}