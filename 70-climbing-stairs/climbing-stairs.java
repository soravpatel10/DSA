class Solution {
    public int climbStairs(int n) {
        ArrayList<Integer> dp = new ArrayList<>();
        for(int i=0; i<=n; i++){
            dp.add(-1);
        }
        return solve(n, dp);
    }

    private int solve (int n, ArrayList<Integer> dp){
        if(n==0 || n==1){
            return 1;
        }

        if(dp.get(n) != -1){
            return dp.get(n);
        }
        dp.set(n, solve(n-1, dp) + solve(n-2,dp));
        return dp.get(n);
    }
}


