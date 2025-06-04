/**
 * Longest Palindromic Substring
 * 
 * This program finds the longest palindromic substring in a given string using two different approaches:
 * 1. Expand Around Center - For each character, expand outward to find palindromes
 * 2. Dynamic Programming - Build a table to track palindromic substrings
 * 
 * A palindrome is a string that reads the same backward as forward (e.g., "racecar", "madam")
 * 
 * Time Complexity:
 * - Expand Around Center: O(n²) where n is the length of the string
 * - Dynamic Programming: O(n²) where n is the length of the string
 * 
 * Space Complexity:
 * - Expand Around Center: O(1) as we only use a constant amount of extra space
 * - Dynamic Programming: O(n²) for the DP table
 * 
 * Input: A string (e.g., "babad")
 * Output: The longest palindromic substring (e.g., "bab" or "aba")
 */

#include <iostream>  // For input/output operations
#include <string>    // For string operations
#include <vector>    // For the 2D vector in DP approach

/**
 * expandAroundCenter - Helper function to expand around a center point
 * @s: The input string
 * @left: Left index of the center
 * @right: Right index of the center
 * @start: Reference to the start index of the current longest palindrome
 * @maxLen: Reference to the length of the current longest palindrome
 * 
 * This function expands outward from a center point (which can be a single character
 * for odd-length palindromes or between two characters for even-length palindromes)
 * as long as the characters on both sides match.
 */
void expandAroundCenter(const std::string& s, int left, int right, int& start, int& maxLen) {
    // Expand as long as we're within bounds and characters match
    while (left >= 0 && right < s.length() && s[left] == s[right]) {
        left--;
        right++;
    }
    
    // Calculate the length of the palindrome
    // We subtract 1 because the while loop increments/decrements one step too far
    int len = right - left - 1;
    
    // Update the longest palindrome if this one is longer
    if (len > maxLen) {
        start = left + 1;  // Adjust start position (left went one step too far)
        maxLen = len;
    }
}

/**
 * longestPalindromicSubstring - Find the longest palindromic substring using expand around center
 * @s: The input string
 * 
 * This function uses the expand around center approach to find the longest palindromic substring.
 * It considers each character as a potential center of a palindrome and expands outward.
 * It handles both odd-length palindromes (centered at a character) and even-length
 * palindromes (centered between two characters).
 * 
 * Returns: The longest palindromic substring
 */
std::string longestPalindromicSubstring(const std::string& s) {
    // Handle base case: empty string or single character
    if (s.length() < 2) return s;
    
    int start = 0;   // Start index of the longest palindrome
    int maxLen = 1;  // Length of the longest palindrome (minimum is 1 character)
    
    // Check for odd length palindromes (centered at each character)
    for (int i = 0; i < s.length(); i++) {
        expandAroundCenter(s, i, i, start, maxLen);
    }
    
    // Check for even length palindromes (centered between characters)
    for (int i = 0; i < s.length() - 1; i++) {
        expandAroundCenter(s, i, i + 1, start, maxLen);
    }
    
    // Extract and return the longest palindromic substring
    return s.substr(start, maxLen);
}

/**
 * longestPalindromicSubstringDP - Find the longest palindromic substring using dynamic programming
 * @s: The input string
 * 
 * This function uses a dynamic programming approach to find the longest palindromic substring.
 * It builds a 2D table where dp[i][j] is true if the substring s[i..j] is a palindrome.
 * 
 * The key insight is that a substring is a palindrome if:
 * 1. The first and last characters match (s[i] == s[j])
 * 2. The substring between them is also a palindrome (dp[i+1][j-1] is true)
 * 
 * Returns: The longest palindromic substring
 */
std::string longestPalindromicSubstringDP(const std::string& s) {
    int n = s.length();
    if (n < 2) return s;  // Handle base case
    
    // dp[i][j] represents whether s[i..j] is a palindrome
    std::vector<std::vector<bool>> dp(n, std::vector<bool>(n, false));
    
    // All substrings of length 1 are palindromes
    for (int i = 0; i < n; i++) {
        dp[i][i] = true;
    }
    
    int start = 0;   // Start index of the longest palindrome
    int maxLen = 1;  // Length of the longest palindrome
    
    // Check for substrings of length 2
    for (int i = 0; i < n - 1; i++) {
        if (s[i] == s[i + 1]) {
            dp[i][i + 1] = true;
            start = i;
            maxLen = 2;
        }
    }
    
    // Check for lengths greater than 2
    // We build the table diagonally (by substring length)
    for (int len = 3; len <= n; len++) {
        for (int i = 0; i < n - len + 1; i++) {
            int j = i + len - 1;  // Ending index of the substring
            
            // A substring is a palindrome if the first and last characters match
            // and the substring between them is also a palindrome
            if (s[i] == s[j] && dp[i + 1][j - 1]) {
                dp[i][j] = true;
                if (len > maxLen) {
                    start = i;
                    maxLen = len;
                }
            }
        }
    }
    
    // Extract and return the longest palindromic substring
    return s.substr(start, maxLen);
}

int main() {
    // Test string
    std::string str = "babad";
    std::cout << "Original string: " << str << std::endl;
    
    // Find longest palindromic substring using expand around center approach
    std::string result1 = longestPalindromicSubstring(str);
    std::cout << "Longest palindromic substring (expand around center): " << result1 << std::endl;
    
    // Find longest palindromic substring using dynamic programming approach
    std::string result2 = longestPalindromicSubstringDP(str);
    std::cout << "Longest palindromic substring (dynamic programming): " << result2 << std::endl;
    
    return 0;
}