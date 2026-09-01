class Solution {

    public int deleteAndEarn(int[] nums) {

        int max = 0;

        for (int num : nums) {
            max = Math.max(max, num);
        }

        int[] freq = new int[max + 1];

        for (int num : nums) {
            freq[num]++;
        }

        ArrayList<Integer> dp = new ArrayList<>();

        for (int i = 0; i <= max; i++) {
            dp.add(-1);
        }

        return solve(max, freq, dp);
    }

    public int solve(int i, int[] freq, ArrayList<Integer> dp) {

        if (i == 0) {
            return 0;
        }

        if (i == 1) {
            return freq[1];
        }

        if (dp.get(i) != -1) {
            return dp.get(i);
        }

        int notTake = solve(i - 1, freq, dp);

        int take = (i * freq[i]) + solve(i - 2, freq, dp);

        dp.set(i, Math.max(take, notTake));

        return dp.get(i);
    }
}