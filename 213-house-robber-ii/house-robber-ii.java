class Solution {
    public int helper(int[] nums) {
        int n = nums.length;

        if (n == 1) return nums[0];

        ArrayList<Integer> dp = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            dp.add(0);
        }

        dp.set(0, nums[0]);
        dp.set(1, Math.max(nums[0], nums[1]));

        for (int i = 2; i < n; i++) {
            dp.set(i, Math.max(dp.get(i - 1),
                               dp.get(i - 2) + nums[i]));
        }

        return dp.get(n - 1);
    }

    public int rob(int[] nums) {
        int n = nums.length;

        if (n == 1) return nums[0];

        int[] arr1 = Arrays.copyOfRange(nums, 0, n - 1);
        int[] arr2 = Arrays.copyOfRange(nums, 1, n);

        return Math.max(helper(arr1), helper(arr2));
    }
}