// // //recursion
// // class Solution {
// //     public int numDistinct(String s, String t) {
// //         return solve(s, t, s.length(), t.length());
// //     }

// //     public int solve(String s, String t, int i, int j) {

// //         if (j == 0) {
// //             return 1;
// //         }

// //         if (i == 0) {
// //             return 0;
// //         }

// //         if (s.charAt(i - 1) == t.charAt(j - 1)) {
// //             int take = solve(s, t, i - 1, j - 1);
// //             int notTake = solve(s, t, i - 1, j);
// //             return take + notTake;
// //         }
// //         return solve(s, t, i - 1, j);
// //     }
// // }

// //Memoization
// class Solution {
//     public int numDistinct(String s, String t) {
//         int n = s.length();
//         int m = t.length();

//         ArrayList<ArrayList<Integer>> dp = new ArrayList<>();

//         for (int i = 0; i <= n; i++) {
//             ArrayList<Integer> row = new ArrayList<>();
//             for (int j = 0; j <= m; j++) {
//                 row.add(-1);
//             }
//             dp.add(row);
//         }

//         return solve(s, t, n, m, dp);
//     }

//     public int solve(String s, String t, int i, int j,
//                      ArrayList<ArrayList<Integer>> dp) {

//         if (j == 0) return 1;
//         if (i == 0) return 0;

//         if (dp.get(i).get(j) != -1)
//             return dp.get(i).get(j);

//         if (s.charAt(i - 1) == t.charAt(j - 1)) {
//             int take = solve(s, t, i - 1, j - 1, dp);
//             int notTake = solve(s, t, i - 1, j, dp);

//             dp.get(i).set(j, take + notTake);
//         } else {
//             dp.get(i).set(j, solve(s, t, i - 1, j, dp));
//         }

//         return dp.get(i).get(j);
//     }
// }


//Tabulation
class Solution {
    public int numDistinct(String s, String t) {
        int n = s.length();
        int m = t.length();

        ArrayList<ArrayList<Integer>> dp = new ArrayList<>();

        for (int i = 0; i <= n; i++) {
            ArrayList<Integer> row = new ArrayList<>();

            for (int j = 0; j <= m; j++) {
                row.add(0);
            }

            dp.add(row);
        }

        for (int i = 0; i <= n; i++) {
            dp.get(i).set(0, 1);
        }

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {

                if (s.charAt(i - 1) == t.charAt(j - 1)) {
                    dp.get(i).set(j,
                        dp.get(i - 1).get(j - 1) + dp.get(i - 1).get(j));
                } else {
                    dp.get(i).set(j, dp.get(i - 1).get(j));
                }
            }
        }

        return dp.get(n).get(m);
    }
}