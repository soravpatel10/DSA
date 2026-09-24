class Solution {

    public int longestCommonSubsequence(String text1, String text2) {

        int n = text1.length();
        int m = text2.length();

        ArrayList<ArrayList<Integer>> dp = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            ArrayList<Integer> row = new ArrayList<>();

            for (int j = 0; j < m; j++) {
                row.add(-1);
            }
            dp.add(row);
        }

        return solve(text1, text2, 0, 0, dp);
    }

    public int solve(String s1, String s2, int i, int j,
                     ArrayList<ArrayList<Integer>> dp) {

        if (i == s1.length() || j == s2.length()) {
            return 0;
        }

        if (dp.get(i).get(j) != -1) {
            return dp.get(i).get(j);
        }

        int ans;
        if (s1.charAt(i) == s2.charAt(j)) {
            ans = 1 + solve(s1, s2, i + 1, j + 1, dp);
        } else {
            ans = Math.max(solve(s1, s2, i + 1, j, dp),solve(s1, s2, i, j + 1, dp));
        }

        dp.get(i).set(j, ans);
        return ans;
    }
}