public class LongestRepeatingSubsequence {
    // Dynamic Programming approach to find length
    public static int findLRSLength(String str) {
        int n = str.length();
        int[][] dp = new int[n + 1][n + 1];
        
        // Fill the dp table
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                if (str.charAt(i - 1) == str.charAt(j - 1) && i != j) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                } else {
                    dp[i][j] = Math.max(dp[i][j - 1], dp[i - 1][j]);
                }
            }
        }
        
        return dp[n][n];
    }
    
    // Method to find and print the subsequence
    public static String findLRS(String str) {
        int n = str.length();
        int[][] dp = new int[n + 1][n + 1];
        
        // Fill the dp table
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                if (str.charAt(i - 1) == str.charAt(j - 1) && i != j) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                } else {
                    dp[i][j] = Math.max(dp[i][j - 1], dp[i - 1][j]);
                }
            }
        }
        
        // Backtrack to find the subsequence
        StringBuilder result = new StringBuilder();
        int i = n, j = n;
        
        while (i > 0 && j > 0) {
            if (str.charAt(i - 1) == str.charAt(j - 1) && i != j) {
                result.insert(0, str.charAt(i - 1));
                i--;
                j--;
            }
            else if (dp[i - 1][j] > dp[i][j - 1]) {
                i--;
            }
            else {
                j--;
            }
        }
        
        return result.toString();
    }
    
    public static void main(String[] args) {
        String[] testCases = {
            "AABEBCDD",
            "AAAAAA",
            "ABCDEF",
            "AAAA",
            "ABCABC"
        };
        
        for (String test : testCases) {
            System.out.println("\nString: " + test);
            System.out.println("Length of longest repeating subsequence: " + 
                             findLRSLength(test));
            String subsequence = findLRS(test);
            if (!subsequence.isEmpty()) {
                System.out.println("One possible longest repeating subsequence: " + 
                                 subsequence);
            } else {
                System.out.println("No repeating subsequence found");
            }
        }
    }
}