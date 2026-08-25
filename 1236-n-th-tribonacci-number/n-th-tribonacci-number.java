/*class Solution {
    public int tribonacci(int n) {
        ArrayList<Integer> dp = new ArrayList<>();

        for(int i=0; i<=n; i++){
            dp.add(-1);
        }

        return solve(n,dp);
    }

    private int solve (int n, ArrayList<Integer>dp){
        if( n==0 ) {
            return 0;
        }

        if(n==1 || n==2){
            return 1;
        }

        if(dp.get(n) != -1){
            return dp.get(n);
        }

        dp.set(n, solve(n-1, dp) + solve(n-2, dp) + solve(n-3, dp));
        return dp.get(n);
    }
}
*/
class Solution{
    public int tribonacci(int n){
        
        ArrayList<Integer> dp = new ArrayList<>();
        if(n==0){
            return 0;
        }

        if(n==1 || n==2){
            return 1;
        }

        for( int i =0; i<=n ; i++){
            dp.add(0);
        }
        dp.set(0,0);
        dp.set(1,1);
        dp.set(2,1);

        
        for(int i=3; i<=n ; i++){
            dp.set(i, dp.get(i-1) + dp.get(i-2) + dp.get(i-3));
        }
        return dp.get(n);
    }
}