class Solution {
    public int deleteAndEarn(int[] nums) {

        int max = 0;
        for (int num : nums) {
            max = Math.max(max, num);
        }

        int[] points = new int[max + 1];

        for (int num : nums) {
            points[num] += num;
        }

        ArrayList<Integer> dp = new ArrayList<>();

        for (int i = 0; i <= max; i++) {
            dp.add(0);
        }

        dp.set(0, points[0]);

        if (max >= 1) {
            dp.set(1, Math.max(points[0], points[1]));
        }

        for (int i = 2; i <= max; i++) {
            dp.set(i,
                Math.max(dp.get(i - 1), dp.get(i - 2) + points[i]));
        }

        return dp.get(max);
    }
}