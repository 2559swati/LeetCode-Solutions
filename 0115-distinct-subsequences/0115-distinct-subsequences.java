class Solution {

    public int numDistinct(String s, String t) {

        int[][] dp = new int[s.length()][t.length()];

        // -1 means we haven't calculated this state yet
        for (int i = 0; i < s.length(); i++) {
            for (int j = 0; j < t.length(); j++) {
                dp[i][j] = -1;
            }
        }

        return solve(0, 0, s, t, dp);
    }

    static int solve(int i, int j, String s, String t, int[][] dp) {

        // t is completely formed
        if (j == t.length()) {
            return 1;
        }

        // s finished but t is still remaining
        if (i == s.length()) {
            return 0;
        }

        // Already calculated
        if (dp[i][j] != -1) {
            return dp[i][j];
        }

        // Characters are same
        if (s.charAt(i) == t.charAt(j)) {

            int take = solve(i + 1, j + 1, s, t, dp);

            int notTake = solve(i + 1, j, s, t, dp);

            dp[i][j] = take + notTake;

        } else {

            // Characters are different
            dp[i][j] = solve(i + 1, j, s, t, dp);
        }

        return dp[i][j];
    }
}