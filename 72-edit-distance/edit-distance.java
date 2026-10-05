// // //recursion
// // class Solution {
// //     public int minDistance(String word1, String word2) {
// //         return solve(word1, word2, word1.length(), word2.length());
// //     }

// //     public int solve(String word1, String word2, int i, int j) {
// //         if (i == 0) return j;
// //         if (j == 0) return i;

// //         if (word1.charAt(i - 1) == word2.charAt(j - 1)) {
// //             return solve(word1, word2, i - 1, j - 1);
// //         }

// //         int insert = solve(word1, word2, i, j - 1);
// //         int delete = solve(word1, word2, i - 1, j);
// //         int replace = solve(word1, word2, i - 1, j - 1);

// //         return 1 + Math.min(insert, Math.min(delete, replace));
// //     }
// // }

// //memoization
// class Solution {
//     public int minDistance(String word1, String word2) {
//         int n = word1.length();
//         int m = word2.length();

//         ArrayList<ArrayList<Integer>> dp = new ArrayList<>();

//         for (int i = 0; i <= n; i++) {
//             ArrayList<Integer> row = new ArrayList<>();
//             for (int j = 0; j <= m; j++) {
//                 row.add(-1);
//             }
//             dp.add(row);
//         }

//         return solve(word1, word2, n, m, dp);
//     }

//     public int solve(String word1, String word2, int i, int j, ArrayList<ArrayList<Integer>> dp) {
//         if (i == 0) return j;
//         if (j == 0) return i;

//         if (dp.get(i).get(j) != -1) return dp.get(i).get(j);

//         if (word1.charAt(i - 1) == word2.charAt(j - 1)) {
//             dp.get(i).set(j, solve(word1, word2, i - 1, j - 1, dp));
//         } else {
//             int insert = solve(word1, word2, i, j - 1, dp);
//             int delete = solve(word1, word2, i - 1, j, dp);
//             int replace = solve(word1, word2, i - 1, j - 1, dp);

//             dp.get(i).set(j, 1 + Math.min(insert, Math.min(delete, replace)));
//         }

//         return dp.get(i).get(j);
//     }
// }

//tabulation
class Solution {
    public int minDistance(String word1, String word2) {
        int n = word1.length();
        int m = word2.length();

        ArrayList<ArrayList<Integer>> dp = new ArrayList<>();

        for (int i = 0; i <= n; i++) {
            ArrayList<Integer> row = new ArrayList<>();
            for (int j = 0; j <= m; j++) {
                row.add(0);
            }
            dp.add(row);
        }

        for (int i = 0; i <= n; i++) {
            dp.get(i).set(0, i);
        }

        for (int j = 0; j <= m; j++) {
            dp.get(0).set(j, j);
        }

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                if (word1.charAt(i - 1) == word2.charAt(j - 1)) {
                    dp.get(i).set(j, dp.get(i - 1).get(j - 1));
                } else {
                    int insert = dp.get(i).get(j - 1);
                    int delete = dp.get(i - 1).get(j);
                    int replace = dp.get(i - 1).get(j - 1);

                    dp.get(i).set(j, 1 + Math.min(insert, Math.min(delete, replace)));
                }
            }
        }

        return dp.get(n).get(m);
    }
}