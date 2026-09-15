class Solution {
    public int findTargetSumWays(int[] nums, int target) {
        return solve(nums, target, nums.length, 0);
    }

    public int solve(int[] nums, int target, int i, int currSum) {

        if (i == 0) {
            return currSum == target ? 1 : 0;
        }

        int plus = solve(nums, target, i - 1, currSum + nums[i - 1]);
        int minus = solve(nums, target, i - 1, currSum - nums[i - 1]);

        return plus + minus;
    }
}