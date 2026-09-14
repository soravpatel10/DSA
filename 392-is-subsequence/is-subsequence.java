// class Solution {
//     public boolean isSubsequence(String s, String t) {
//         return isSub(s,t,0,0);
//         }

//         public boolean isSub(String s, String t, int i , int j){
//             if (i==s.length()){
//                 return true;
//             }

//             if(j==t.length()){
//                 return false;
//             }

//             if( s.charAt(i) != t.charAt(j)){
//                 return isSub(s,t,i,j+1);
//             }

//             if( s.charAt(i)==t.charAt(j)){
//                 return isSub(s,t,i+1,j+1);
//             }
//             return false;
//     }
// }


//tabulation
class Solution {
    public boolean isSubsequence(String s, String t) {

        int m = s.length();
        int n = t.length();

        boolean[][] dp = new boolean[m + 1][n + 1];

        for (int j = 0; j <= n; j++) {
            dp[m][j] = true;
        }

        for (int i = m - 1; i >= 0; i--) {
            for (int j = n - 1; j >= 0; j--) {

                if (s.charAt(i) == t.charAt(j)) {
                    dp[i][j] = dp[i + 1][j + 1];
                } else {
                    dp[i][j] = dp[i][j + 1];
                }
            }
        }

        return dp[0][0];
    }
}
