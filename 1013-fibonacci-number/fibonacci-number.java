/* Solution {
    public int fib(int n) {
        ArrayList<Integer> dp = new ArrayList<>();

        for (int i = 0; i <= n; i++) {
            dp.add(-1);
        }
        return solve(n, dp);
    }

    private int solve(int n, ArrayList<Integer> dp) {
        if (n == 0 || n == 1) {
            return n;
        }

        if (dp.get(n) != -1) {
            return dp.get(n);
        }

        dp.set(n, solve(n - 1, dp) + solve(n - 2, dp));
        return dp.get(n);
    }
}*/


//dp
// class Solution{
//     public int fib(int n) {
//         if (n <= 1) {
//             return n;
//         }
//         ArrayList<Integer> dp = new ArrayList<>();

//         for (int i = 0; i <= n; i++) {
//             dp.add(0);
//         }

//     dp.set(0 ,0);
//     dp.set(1, 1);

//     for(int i=2; i<=n; i++){
//         dp.set(i, dp.get(i-1) + dp.get(i-2));
//     }
//     return dp.get(n);
// }
// }

/*
class Solution{
    public int fib(int n){
        int ans = findfib(n);
        return ans;
    }

    public int findfib(int n){

        if(n==0 || n==1){
            return n;
        }

        int num1= findfib(n-1);
        int num2 =findfib(n-2);

        int num = num1 + num2;
        return num;
    }
}
*/
//dp memo
class Solution {
    public int fib(int n){
        if(n<=1){
            return n;
        }
        return fib(n-1)+fib(n-2);
    }
}