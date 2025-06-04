/**
 * Longest Repeating Subsequence Finder
 * 
 * This program finds the length of the longest repeating subsequence in a string.
 * A repeating subsequence is a subsequence that appears at least twice in the original
 * string and doesn't use the same character twice in one subsequence.
 * 
 * For example, in string "AABEBCDD":
 * - The longest repeating subsequence is "ABD" which appears twice
 * - First occurrence: A(0)B(2)D(6)
 * - Second occurrence: A(1)B(3)D(7)
 * 
 * Algorithm:
 * Uses dynamic programming similar to the Longest Common Subsequence problem:
 * 1. Create a 2D DP table where dp[i][j] represents the length of the longest
 *    repeating subsequence considering substrings str[0...i-1] and str[0...j-1]
 * 2. If characters match and indices are different, take diagonal value + 1
 * 3. Otherwise, take the maximum of left and top values
 * 
 * Time Complexity: O(n²) where n is the length of the string
 * Space Complexity: O(n²) for the DP table
 * 
 * Input: A string - "AABEBCDD"
 * Output: Length of the longest repeating subsequence - 3
 */

#include <stdio.h>
#include <string.h>

/**
 * max - Returns the maximum of two integers
 * @a: First integer
 * @b: Second integer
 * 
 * Returns: The larger of the two values
 */
int max(int a, int b) {
    return (a > b) ? a : b;
}

/**
 * findLongestRepeatingSubsequence - Find the length of the longest repeating subsequence
 * @str: The input string to analyze
 * 
 * Returns: Length of the longest repeating subsequence
 */
int findLongestRepeatingSubsequence(const char* str) {
    int n = strlen(str);  // Length of the input string
    int dp[n + 1][n + 1];  // DP table for storing subproblem solutions
    
    // Initialize the DP table with zeros
    for (int i = 0; i <= n; i++) {
        for (int j = 0; j <= n; j++) {
            dp[i][j] = 0;
        }
    }
    
    // Fill the DP table using bottom-up approach
    for (int i = 1; i <= n; i++) {
        for (int j = 1; j <= n; j++) {
            // If characters match and are at different positions
            if (str[i - 1] == str[j - 1] && i != j) {
                // Take diagonal value and add 1
                dp[i][j] = dp[i - 1][j - 1] + 1;
            } else {
                // Take maximum of left and top values
                dp[i][j] = max(dp[i][j - 1], dp[i - 1][j]);
            }
        }
    }
    
    // The bottom-right cell contains the length of the longest repeating subsequence
    return dp[n][n];
}

int main() {
    // Test string
    const char* str = "AABEBCDD";
    
    // Display the input string
    printf("String: %s\n", str);
    
    // Find and display the length of the longest repeating subsequence
    printf("Length of longest repeating subsequence: %d\n", 
           findLongestRepeatingSubsequence(str));
    
    return 0;
}