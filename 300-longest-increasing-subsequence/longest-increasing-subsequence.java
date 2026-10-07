// class Solution {
//     public int lengthOfLIS(int[] nums) {
//         return solve(0, -1, nums);
//     }

//     public int solve(int i, int p, int[] nums){
//         int n = nums.length;
//         if(i >= n){
//             return 0;
//         }
//         int take = 0;
//         if( p ==-1 || nums[i] > nums[p]){
//             take = 1 + solve(i+1, i, nums);
//         }
//         int skip = solve(i+1, p, nums);

//         return Math.max(take, skip);
//     }
// }

//Memoization
class Solution{
    public int lengthOfLIS(int[] nums){
        int n = nums.length;
        ArrayList<ArrayList<Integer>> dp  = new ArrayList<>();
        
        for(int i=0;i<=n; i++){
            ArrayList<Integer> row = new ArrayList<>();

            for(int j=0; j <= n; j++){
                row.add(-1); 
            }
            dp.add(row);
        }

        return solve(0, -1, nums, dp);

    }
    public int solve(int i, int j, int[] nums, ArrayList<ArrayList<Integer>> dp){

        if(i>= nums.length){
            return 0;
        }
        if(dp.get(i).get(j+1) != -1){
            return dp.get(i).get(j+1);
        }
        int take = 0;
        if(j == -1 || nums[i] > nums[j]){
            take = 1 + solve(i+1, i, nums, dp);
        }
        int skip = solve(i+1, j, nums, dp);

        dp.get(i).set(j+1, Math.max(take, skip));
        return dp.get(i).get(j+1);
    }
}