// class Solution {

//     int solve(int i,int amount,int[] coins){

//         if(amount==0)
//             return 0;
//
//         if(i==0){
//             if(amount%coins[0]==0)
//                 return amount/coins[0];

//             return (int)1e9;
//         }

//         int notPick=solve(i-1,amount,coins);
//         int pick=(int)1e9;

//         if(coins[i]<=amount)
//             pick=1+solve(i,amount-coins[i],coins);

//         return Math.min(pick,notPick);
//     }

//     public int coinChange(int[] coins,int amount){

//         int n=coins.length;
//         int ans=solve(n-1,amount,coins);

//         if(ans>=1e9){
//             return -1;
//         }
//         return ans;
//     }
// }


//memoization
class Solution {

    int solve(int i,int amount,int[] coins,
              ArrayList<ArrayList<Integer>> dp){

        if(amount==0)
            return 0;

        if(i==0){
            if(amount%coins[0]==0){
                return amount/coins[0];
            }
            return (int)1e9;
        }

        if(dp.get(i).get(amount)!=-1){
            return dp.get(i).get(amount);
        }
        int notPick=solve(i-1,amount,coins,dp);

        int pick=(int)1e9;
        if(coins[i]<=amount){
            pick=1+solve(i,amount-coins[i],coins,dp);
        }
        
        int ans=Math.min(pick,notPick);
        dp.get(i).set(amount,ans);
        return ans;
    }

    public int coinChange(int[] coins,int amount) {

        int n=coins.length;
        ArrayList<ArrayList<Integer>> dp=new ArrayList<>();

        for(int i=0;i<n;i++){
            ArrayList<Integer> row=new ArrayList<>();

            for(int j=0;j<=amount;j++)
                row.add(-1);

            dp.add(row);
        }

        int ans=solve(n-1,amount,coins,dp);

        if(ans>=1e9){
            return -1;
        }
        return ans;
    }
}