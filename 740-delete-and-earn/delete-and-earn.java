import java.util.*;

class Solution {

    int[] dp = new int[20005];

    int fun(int i, ArrayList<Integer> nums, HashMap<Integer, Integer> map) {

        if (i == nums.size() - 1) {
            return nums.get(i) * map.get(nums.get(i));
        }

        if (i >= nums.size()) {
            return 0;
        }

        if (dp[i] != -1) {
            return dp[i];
        }

        int max = 0;

        if (i + 1 < nums.size() &&
            nums.get(i + 1) == nums.get(i) + 1) {

            int a = (nums.get(i) * map.get(nums.get(i)))
                    + fun(i + 2, nums, map);

            max = Math.max(max, a);
        }

        if (i + 1 < nums.size() &&
            nums.get(i + 1) != nums.get(i) + 1) {

            int a = (nums.get(i) * map.get(nums.get(i)))
                    + fun(i + 1, nums, map);

            max = Math.max(max, a);
        }

        int a = fun(i + 1, nums, map);
        max = Math.max(max, a);

        return dp[i] = max;
    }

    public int deleteAndEarn(int[] nums) {

        HashMap<Integer, Integer> map = new HashMap<>();

        for (int x : nums) {
            map.put(x, map.getOrDefault(x, 0) + 1);
        }

        ArrayList<Integer> v1 = new ArrayList<>(map.keySet());
        Collections.sort(v1);

        Arrays.fill(dp, -1);

        return fun(0, v1, map);
    }
}