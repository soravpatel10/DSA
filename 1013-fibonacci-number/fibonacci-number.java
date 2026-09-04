//recursion
// class Solution {
//     public int fib(int n){
//         if(n<=1){
//             return n;
//         }
//         return fib(n-1)+fib(n-2);
//     }
// }
//

//comment
//Memoization
// class Solution {
//     public int fib(int n){
//         ArrayList<Integer> dp = new ArrayList<>();
//         for(int i=0; i<=n; i++){
//             dp.add(-1);
//         }
//         return solve(n , dp);
//     }
//     public int solve(int n, ArrayList<Integer> dp){
//         if(n<=1) {
//             return n;
//         }
//         if(dp.get(n) != -1) {
//             return dp.get(n);
//         }
//         dp.set(n, solve(n-1, dp) + solve(n-2, dp));
//         return dp.get(n);
//     }
// }

//Tabulation
// class Solution {
//     public int fib(int n){
//         ArrayList<Integer> dp = new ArrayList<>();
//         if (n <= 1) return n;
//         for (int i = 0; i <= n; i++) {
//             dp.add(0);
//         }
//         dp.set(0, 0);
//         dp.set(1, 1);
//         for(int i=2; i<=n; i++){
//             dp.set(i, dp.get(i-1)+ dp.get(i-2));
//         }
//         return dp.get(n);
//     }
// }
//comment
//Space Optimization
class Solution{
    public int fib(int n){
        if(n<=1) return n;
        int prev2 = 0;
        int prev = 1;
        for(int i=2; i<=n; i++){
            int curr = prev + prev2;
            prev2 = prev;
            prev = curr;
        }
        return prev;
    }
}