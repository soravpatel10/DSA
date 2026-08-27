class Solution {
    // public int countFriendsPairings(int n) {
    //     // code here
    //     return fun(n);
    // }
    
    // public static int fun(int n){
    // int op1 = 1*fun(n-1);
    // int op2 = (n-1)*fun(n-2);
    // return op1+op2;
    // }
    
    public int countFriendsPairings(int n){
        ArrayList<Integer> dp = new ArrayList<>();
        for(int i=0; i<=n; i++){
            dp.add(-1);
        }
        return Memo(n,dp);
    }
    
    public static int Memo(int n, ArrayList<Integer> dp){
        if(n<=2){
            return n;
        }
        if(dp.get(n)!=-1)return dp.get(n);
        int opt1 = 1*Memo((n-1), dp);
        int opt2 = (n-1)*Memo((n-2), dp);
        dp.set(n, opt1 + opt2);
        return opt1 + opt2;
    }
}
