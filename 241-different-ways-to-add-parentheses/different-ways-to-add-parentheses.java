class Solution {
    public List<Integer> diffWaysToCompute(String s) {
        List<Integer> ans = new ArrayList<>();

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);

            if (c == '+' || c == '-' || c == '*') {
                List<Integer> l = diffWaysToCompute(s.substring(0, i));
                List<Integer> r = diffWaysToCompute(s.substring(i + 1));

                for (int a : l) {
                    for (int b : r) {
                        if (c == '+') ans.add(a + b);
                        else if (c == '-') ans.add(a - b);
                        else ans.add(a * b);
                    }
                }
            }
        }

        if (ans.isEmpty()) ans.add(Integer.parseInt(s));
        return ans;
    }
}