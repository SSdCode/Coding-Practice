/**
 * Longest Repeating Subsequence
 * 
 * This program finds the length and an example of the longest repeating subsequence in a string.
 * A repeating subsequence is a subsequence that appears at least twice in the original string
 * and the two subsequences have different indices for each occurrence.
 * 
 * For example, in "AABEBCDD":
 * - "ABD" is a repeating subsequence (found at positions 0,3,6 and 1,4,7)
 * 
 * The problem is solved using dynamic programming, similar to the Longest Common Subsequence (LCS)
 * problem, but with the constraint that the same character at the same position cannot be used twice.
 * 
 * Time Complexity: O(n²) where n is the length of the string
 * Space Complexity: O(n²) for the DP table
 * 
 * Input: A string (e.g., "AABEBCDD")
 * Output: Length of the longest repeating subsequence and one possible subsequence
 */

#include <iostream>  // For input/output operations
#include <string>    // For string operations
#include <vector>    // For 2D vector (DP table)
#include <algorithm> // For max function

/**
 * longestRepeatingSubsequence - Find the length of the longest repeating subsequence
 * @str: The input string
 * 
 * This function uses dynamic programming to find the length of the longest repeating subsequence.
 * The approach is similar to finding the longest common subsequence (LCS) of the string with itself,
 * but with the constraint that the same character at the same position cannot be used twice.
 * 
 * The DP table is filled as follows:
 * - dp[i][j] represents the length of the longest repeating subsequence considering
 *   the first i characters of the string and the first j characters of the string
 * - If characters match and are at different positions, we include this character in our subsequence
 * - Otherwise, we take the maximum of excluding either the current character from the first or second instance
 * 
 * Returns: The length of the longest repeating subsequence
 */
int longestRepeatingSubsequence(const std::string& str) {
    int n = str.length();
    // Create a DP table of size (n+1) x (n+1), initialized with zeros
    std::vector<std::vector<int>> dp(n + 1, std::vector<int>(n + 1, 0));
    
    // Fill the DP table bottom-up
    for (int i = 1; i <= n; i++) {
        for (int j = 1; j <= n; j++) {
            // If characters match and are at different positions
            if (str[i - 1] == str[j - 1] && i != j) {
                // Include this character in the subsequence
                dp[i][j] = dp[i - 1][j - 1] + 1;
            } else {
                // Take the maximum of excluding either the current character
                dp[i][j] = std::max(dp[i][j - 1], dp[i - 1][j]);
            }
        }
    }
    
    // The bottom-right cell contains the length of the longest repeating subsequence
    return dp[n][n];
}

/**
 * printLongestRepeatingSubsequence - Find and return one of the longest repeating subsequences
 * @str: The input string
 * 
 * This function not only finds the length of the longest repeating subsequence but also
 * reconstructs one possible subsequence by backtracking through the DP table.
 * 
 * The backtracking process starts from the bottom-right cell of the DP table and
 * works backward to reconstruct the subsequence:
 * - If characters match and are at different positions, include the character and move diagonally
 * - Otherwise, move in the direction of the larger value (either up or left)
 * 
 * Returns: One of the longest repeating subsequences as a string
 */
std::string printLongestRepeatingSubsequence(const std::string& str) {
    int n = str.length();
    // Create and fill the DP table (same as in the previous function)
    std::vector<std::vector<int>> dp(n + 1, std::vector<int>(n + 1, 0));
    
    // Fill the DP table bottom-up
    for (int i = 1; i <= n; i++) {
        for (int j = 1; j <= n; j++) {
            if (str[i - 1] == str[j - 1] && i != j) {
                dp[i][j] = dp[i - 1][j - 1] + 1;
            } else {
                dp[i][j] = std::max(dp[i][j - 1], dp[i - 1][j]);
            }
        }
    }
    
    // Backtrack to find the subsequence
    std::string result;
    int i = n, j = n;
    
    // Start from the bottom-right cell and work backward
    while (i > 0 && j > 0) {
        // If characters match and are at different positions
        if (str[i - 1] == str[j - 1] && i != j) {
            // Include this character in the result and move diagonally
            result = str[i - 1] + result;
            i--;
            j--;
        }
        // Otherwise, move in the direction of the larger value
        else if (dp[i - 1][j] > dp[i][j - 1]) {
            i--;
        }
        else {
            j--;
        }
    }
    
    return result;
}

int main() {
    // Test string
    std::string str = "AABEBCDD";
    
    // Display the input string
    std::cout << "String: " << str << std::endl;
    
    // Find and display the length of the longest repeating subsequence
    std::cout << "Length of longest repeating subsequence: " 
              << longestRepeatingSubsequence(str) << std::endl;
    
    // Find and display one of the longest repeating subsequences
    std::string subsequence = printLongestRepeatingSubsequence(str);
    if (!subsequence.empty()) {
        std::cout << "One of the longest repeating subsequences: " << subsequence << std::endl;
    }
    
    return 0;
}