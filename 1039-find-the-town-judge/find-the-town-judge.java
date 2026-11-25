class Solution {
    public int findJudge(int n, int[][] trust) {

        int[] indegree = new int[n + 1];
        int[] outdegree = new int[n + 1];

        // for (int[] t : trust) {
        //     outdegree[t[0]]++;
        //     indegree[t[1]]++;
        // }

        for(int i=0; i<trust.length; i++){
                int a = trust[i][0];
                int b = trust[i][1];
                
                outdegree[a]++;
                indegree[b]++;
            } 
        


        for (int i = 1; i <= n; i++) {
            if (indegree[i] == n - 1 && outdegree[i] == 0) {
                return i;
            }
        }

        return -1;
    }
}











































// class Solution {
//     public int findJudge(int n, int[][] trust) {

//         int[] indegree = new int[n + 1];
//         int[] outdegree = new int[n + 1];

//         for (int[] t : trust) {
//             outdegree[t[0]]++;
//             indegree[t[1]]++;
//         }

//         for (int i = 1; i <= n; i++) {
//             if (indegree[i] == n - 1 && outdegree[i] == 0) {
//                 return i;
//             }
//         }

//         return -1;
//     }
// }















// class Solution {
//     public int findJudge(int n, int[][] trust) {

//         int[] count = new int[n + 1];

//         for (int i = 0; i < trust.length; i++) {
//             count[trust[i][0]]--;
//             count[trust[i][1]]++;
//         }

//         for (int i = 1; i <= n; i++) {
//             if (count[i] == n - 1) {
//                 return i;
//             }
//         }

//         return -1;
//     }
// }