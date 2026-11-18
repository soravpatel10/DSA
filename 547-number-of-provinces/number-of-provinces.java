class Solution {
    void dfs(int node, int[][] adj, boolean[] vis) {
        vis[node] = true; //marked current city as visited

        //traverse all cities
        for(int i = 0; i < adj.length; i++) {

            //check connection and visited status
            if(adj[node][i] == 1 && !vis[i]) {
                dfs(i, adj, vis); //recursive dfs call
            }
        }
    }

    public int findCircleNum(int[][] isConnected) {
        int n = isConnected.length; //number of cities
        boolean[] vis = new boolean[n]; //create visited array
        int count = 0; //province count

        //traverse every city
        for(int i = 0; i < n; i++) {

            // If city is not visited
            if(!vis[i]) {
                count++; //found new province
                dfs(i, isConnected, vis); //visit all connected cities

            }
        }
        return count;
    }
}
