class Solution {
    int solve(String s, int i){
        if(i== s.length()){
            return 0;
        }
        char c = s.charAt(i);
        int value= 26 -(c-'a');
        int current = value*(i+1);
        return current + solve(s, i+1);
    }
    public int reverseDegree(String s) {
        return solve(s,0);
        
    }
}