/**
 * LongestRepeatingSubsequence
 * 
 * This class finds the longest repeating subsequence in a string.
 * A repeating subsequence is a subsequence that appears at least twice in the original string
 * and the two subsequences have different indices for each occurrence.
 * 
 * For example, in string "AABEBCDD":
 * - "ABD" is a repeating subsequence (appears at positions 0,2,6 and 1,4,7)
 * 
 * The problem is solved using dynamic programming, similar to the Longest Common Subsequence (LCS)
 * problem, but with the constraint that the same character at the same position cannot be used twice.
 * 
 * Time Complexity: O(n²) where n is the length of the string
 * Space Complexity: O(n²) for the DP table
 * 
 * Input: A string
 * Output: The length of the longest repeating subsequence and one possible subsequence
 */
public class LongestRepeatingSubsequence {
    /**
     * Find the length of the longest repeating subsequence using dynamic programming.
     * 
     * Algorithm:
     * 1. Create a 2D DP table where dp[i][j] represents the length of the longest repeating
     *    subsequence considering the first i characters of the string and the first j characters
     * 2. If characters at positions i-1 and j-1 match and i != j (to ensure different positions),
     *    then dp[i][j] = dp[i-1][j-1] + 1
     * 3. Otherwise, dp[i][j] = max(dp[i-1][j], dp[i][j-1])
     * 4. The value at dp[n][n] gives the length of the longest repeating subsequence
     * 
     * @param str The input string
     * @return The length of the longest repeating subsequence
     */
    public static int findLRSLength(String str) {
        int n = str.length();
        // DP table: dp[i][j] represents LRS length considering first i and j characters
        int[][] dp = new int[n + 1][n + 1];
        
        // Fill the dp table (bottom-up approach)
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                // If characters match and are at different positions
                if (str.charAt(i - 1) == str.charAt(j - 1) && i != j) {
                    // Include this character in the subsequence
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                } else {
                    // Take the maximum of excluding either character
                    dp[i][j] = Math.max(dp[i][j - 1], dp[i - 1][j]);
                }
            }
        }
        
        // The bottom-right cell contains the length of the LRS
        return dp[n][n];
    }
    
    /**
     * Find and return one possible longest repeating subsequence.
     * 
     * Algorithm:
     * 1. First, build the same DP table as in findLRSLength
     * 2. Then, backtrack from the bottom-right cell (dp[n][n]) to construct the subsequence:
     *    a. If characters at positions i-1 and j-1 match and i != j, include this character
     *       and move diagonally up-left
     *    b. Otherwise, move in the direction of the larger value (up or left)
     * 3. Return the constructed subsequence
     * 
     * @param str The input string
     * @return One possible longest repeating subsequence as a string
     */
    public static String findLRS(String str) {
        int n = str.length();
        // DP table: same as in findLRSLength
        int[][] dp = new int[n + 1][n + 1];
        
        // Fill the dp table (identical to findLRSLength)
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
        
        // Start from the bottom-right cell and move towards the top-left
        while (i > 0 && j > 0) {
            // If characters match and are at different positions
            if (str.charAt(i - 1) == str.charAt(j - 1) && i != j) {
                // Include this character in the result
                result.insert(0, str.charAt(i - 1));
                // Move diagonally up-left
                i--;
                j--;
            }
            // Otherwise, move in the direction of the larger value
            else if (dp[i - 1][j] > dp[i][j - 1]) {
                // Move up
                i--;
            }
            else {
                // Move left
                j--;
            }
        }
        
        return result.toString();
    }
    
    /**
     * Main method to test the longest repeating subsequence algorithms with various examples.
     * 
     * @param args Command line arguments (not used)
     */
    public static void main(String[] args) {
        // Test cases with different patterns
        String[] testCases = {
            "AABEBCDD",   // LRS: "ABD"
            "AAAAAA",     // LRS: "AAA"
            "ABCDEF",     // No repeating subsequence
            "AAAA",       // LRS: "AA"
            "ABCABC"      // LRS: "ABC"
        };
        
        // Test each string
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