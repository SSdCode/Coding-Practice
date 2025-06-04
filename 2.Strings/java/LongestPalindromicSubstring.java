/**
 * LongestPalindromicSubstring
 * 
 * This class provides three different algorithms to find the longest palindromic substring in a given string:
 * 1. Expand Around Center - O(n²) time complexity
 * 2. Dynamic Programming - O(n²) time complexity
 * 3. Manacher's Algorithm - O(n) time complexity (most efficient)
 * 
 * A palindrome is a string that reads the same backward as forward, e.g., "madam" or "racecar".
 * 
 * Time Complexity:
 * - Expand Around Center: O(n²) where n is the length of the string
 * - Dynamic Programming: O(n²) where n is the length of the string
 * - Manacher's Algorithm: O(n) where n is the length of the string
 * 
 * Space Complexity:
 * - Expand Around Center: O(1) constant extra space
 * - Dynamic Programming: O(n²) for the DP table
 * - Manacher's Algorithm: O(n) for the transformed string and P array
 * 
 * Input: A string
 * Output: The longest palindromic substring within the input string
 */
public class LongestPalindromicSubstring {
    /**
     * Find the longest palindromic substring using the Expand Around Center approach.
     * 
     * Algorithm:
     * 1. For each character in the string, consider it as a potential center of a palindrome
     * 2. Expand around this center in both directions as long as characters match
     * 3. Consider both odd-length palindromes (single character center) and 
     *    even-length palindromes (between two characters)
     * 4. Keep track of the longest palindrome found
     * 
     * @param s The input string
     * @return The longest palindromic substring
     */
    public static String longestPalindromicSubstring(String s) {
        // Handle edge cases
        if (s == null || s.length() < 2) return s;
        
        // Variables to track the longest palindrome found
        int start = 0;
        int maxLen = 1;
        
        // Check each possible center position
        for (int i = 0; i < s.length(); i++) {
            // Check for odd length palindromes (center is a single character)
            expandAroundCenter(s, i, i, start, maxLen);
            
            // Check for even length palindromes (center is between two characters)
            expandAroundCenter(s, i, i + 1, start, maxLen);
        }
        
        // Extract and return the longest palindromic substring
        return s.substring(start, start + maxLen);
    }
    
    /**
     * Helper method to expand around a potential palindrome center.
     * 
     * @param s The input string
     * @param left The left pointer (moving towards the beginning of the string)
     * @param right The right pointer (moving towards the end of the string)
     * @param start Reference to the start index of the longest palindrome
     * @param maxLen Reference to the length of the longest palindrome
     */
    private static void expandAroundCenter(String s, int left, int right, int start, int maxLen) {
        // Expand as long as characters match and we're within bounds
        while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
            int len = right - left + 1;
            // Update longest palindrome if current one is longer
            if (len > maxLen) {
                start = left;
                maxLen = len;
            }
            // Expand outward
            left--;
            right++;
        }
    }
    
    /**
     * Find the longest palindromic substring using Dynamic Programming.
     * 
     * Algorithm:
     * 1. Create a boolean DP table where dp[i][j] indicates if substring s[i...j] is a palindrome
     * 2. Initialize all substrings of length 1 as palindromes
     * 3. Check all substrings of length 2
     * 4. For substrings of length 3 or more, use the recurrence relation:
     *    dp[i][j] = true if s[i] == s[j] AND dp[i+1][j-1] is true
     * 5. Keep track of the longest palindrome found
     * 
     * @param s The input string
     * @return The longest palindromic substring
     */
    public static String longestPalindromicSubstringDP(String s) {
        // Handle edge cases
        if (s == null || s.length() < 2) return s;
        
        int n = s.length();
        // DP table: dp[i][j] is true if substring s[i...j] is a palindrome
        boolean[][] dp = new boolean[n][n];
        int start = 0;  // Start index of longest palindrome
        int maxLen = 1; // Length of longest palindrome
        
        // All substrings of length 1 are palindromes
        for (int i = 0; i < n; i++) {
            dp[i][i] = true;
        }
        
        // Check for substrings of length 2
        for (int i = 0; i < n - 1; i++) {
            if (s.charAt(i) == s.charAt(i + 1)) {
                dp[i][i + 1] = true;
                start = i;
                maxLen = 2;
            }
        }
        
        // Check for lengths greater than 2
        // len is the current substring length being considered
        for (int len = 3; len <= n; len++) {
            for (int i = 0; i < n - len + 1; i++) {
                // j is the ending index of current substring
                int j = i + len - 1;
                // A substring is a palindrome if its first and last characters match
                // and the substring between them is also a palindrome
                if (s.charAt(i) == s.charAt(j) && dp[i + 1][j - 1]) {
                    dp[i][j] = true;
                    if (len > maxLen) {
                        start = i;
                        maxLen = len;
                    }
                }
            }
        }
        
        // Extract and return the longest palindromic substring
        return s.substring(start, start + maxLen);
    }
    
    /**
     * Find the longest palindromic substring using Manacher's Algorithm.
     * This is the most efficient approach with O(n) time complexity.
     * 
     * Algorithm:
     * 1. Transform the string to handle both odd and even length palindromes
     *    by inserting special characters (e.g., '#') between each character
     * 2. Use the key insight that previously computed palindromes can help
     *    determine new palindromes without redundant character comparisons
     * 3. Maintain a center position and right boundary of the current palindrome
     * 4. Use symmetry to initialize palindrome lengths for positions within the right boundary
     * 5. Expand palindromes where needed and update center/boundary
     * 
     * @param s The input string
     * @return The longest palindromic substring
     */
    public static String longestPalindromicSubstringManacher(String s) {
        // Handle edge cases
        if (s == null || s.length() < 2) return s;
        
        // Transform string to handle even length palindromes
        // e.g., "abc" -> "^#a#b#c#$" where ^ and $ are boundary markers
        String t = "^#" + String.join("#", s.split("")) + "#$";
        int n = t.length();
        
        // p[i] = radius of palindrome centered at i (excluding center)
        int[] p = new int[n];
        int c = 0;  // Center of current palindrome
        int r = 0;  // Right boundary of current palindrome
        
        for (int i = 1; i < n - 1; i++) {
            // If within right boundary, initialize p[i] using mirror property
            if (r > i) {
                // Mirror index of i with respect to c
                p[i] = Math.min(r - i, p[2 * c - i]);
            }
            
            // Attempt to expand palindrome centered at i
            while (t.charAt(i + 1 + p[i]) == t.charAt(i - 1 - p[i])) {
                p[i]++;
            }
            
            // If palindrome centered at i expands past r,
            // adjust center and right boundary
            if (i + p[i] > r) {
                c = i;
                r = i + p[i];
            }
        }
        
        // Find the maximum element in p array (longest palindrome)
        int maxLen = 0;
        int centerIndex = 0;
        for (int i = 1; i < n - 1; i++) {
            if (p[i] > maxLen) {
                maxLen = p[i];
                centerIndex = i;
            }
        }
        
        // Convert back to original string indices and return substring
        return s.substring((centerIndex - maxLen) / 2, (centerIndex + maxLen) / 2);
    }
    
    /**
     * Main method to test the three palindrome finding algorithms with various examples.
     * 
     * @param args Command line arguments (not used)
     */
    public static void main(String[] args) {
        // Test cases with various patterns
        String[] testCases = {
            "babad",    // Multiple possible answers ("bab" or "aba")
            "cbbd",     // Even length palindrome
            "a",        // Single character
            "ac",       // No palindrome longer than 1 character
            "bananas", // "anana"
            "aaaaaa"    // Entire string is a palindrome
        };
        
        // Test each string with all three algorithms
        for (String test : testCases) {
            System.out.println("\nOriginal string: " + test);
            System.out.println("Expand around center: " + 
                             longestPalindromicSubstring(test));
            System.out.println("Dynamic Programming: " + 
                             longestPalindromicSubstringDP(test));
            System.out.println("Manacher's Algorithm: " + 
                             longestPalindromicSubstringManacher(test));
        }
    }
}