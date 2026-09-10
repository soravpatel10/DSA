class Solution {
    ArrayList<ArrayList<Integer>> dp;
    public int uniquePaths(int m, int n) {

        dp = new ArrayList<>();
        for (int i = 0; i < m; i++) {
            ArrayList<Integer> row = new ArrayList<>();

            for (int j = 0; j < n; j++){
                row.add(-1);
            }
            dp.add(row);
        }
        return solve(m - 1, n - 1);
    }

    public int solve(int m, int n) {

        if (m == 0 && n == 0)
            return 1;

        if (m < 0 || n < 0)
            return 0;

        if (dp.get(m).get(n) != -1)
            return dp.get(m).get(n);

        int up = solve(m - 1, n);
        int left = solve(m, n - 1);

        dp.get(m).set(n, up + left);
        
        return dp.get(m).get(n);
    }
}