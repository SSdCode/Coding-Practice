/**
 * Longest Palindromic Substring
 * 
 * This program finds the longest palindromic substring within a given string.
 * It uses the "expand around center" technique, which is an efficient approach
 * with O(n²) time complexity.
 * 
 * Algorithm:
 * 1. For each character in the string, consider it as a potential center of a palindrome
 * 2. Expand outward from this center in both directions as long as characters match
 * 3. Consider both odd-length palindromes (single character center) and 
 *    even-length palindromes (between two characters)
 * 4. Keep track of the longest palindromic substring found
 * 
 * Time Complexity: O(n²) where n is the length of the input string
 * Space Complexity: O(1) excluding the output string
 * 
 * Input: A string (e.g., "babad")
 * Output: The longest palindromic substring (e.g., "bab" or "aba")
 */

#include <stdio.h>
#include <string.h>

/**
 * expandAroundCenter - Helper function to expand around a potential palindrome center
 * @s: The input string
 * @left: Left index of the center (or left of center for even-length palindromes)
 * @right: Right index of the center (or right of center for even-length palindromes)
 * @start: Pointer to store the starting index of the longest palindrome found
 * @maxLen: Pointer to store the length of the longest palindrome found
 * 
 * This function expands outward from a center position as long as the characters match,
 * updating the longest palindrome information if a longer one is found.
 */
void expandAroundCenter(const char* s, int left, int right, int* start, int* maxLen) {
    // Expand as long as characters match and we're within bounds
    while (left >= 0 && s[right] != '\0' && s[left] == s[right]) {
        left--;
        right++;
    }
    
    // Calculate the length of the palindrome
    // We subtract 1 because the while loop incremented/decremented once too far
    int len = right - left - 1;
    
    // Update the longest palindrome if this one is longer
    if (len > *maxLen) {
        *start = left + 1;  // +1 because left was decremented in the last iteration
        *maxLen = len;
    }
}

/**
 * longestPalindromicSubstring - Find the longest palindromic substring
 * @s: The input string
 * @result: Buffer to store the result
 * 
 * This function finds the longest palindromic substring in the input string
 * and stores it in the result buffer.
 */
void longestPalindromicSubstring(const char* s, char* result) {
    int n = strlen(s);
    
    // Handle base case: empty string or single character
    if (n < 2) {
        strcpy(result, s);
        return;
    }
    
    // Initialize variables to track the longest palindrome
    int start = 0;    // Starting index of the longest palindrome
    int maxLen = 1;   // Length of the longest palindrome (default to 1 for single char)
    
    // Check for odd length palindromes (single character center)
    for (int i = 0; s[i] != '\0'; i++) {
        expandAroundCenter(s, i, i, &start, &maxLen);
    }
    
    // Check for even length palindromes (between two characters)
    for (int i = 0; s[i] != '\0'; i++) {
        expandAroundCenter(s, i, i + 1, &start, &maxLen);
    }
    
    // Copy the longest palindromic substring to result
    strncpy(result, s + start, maxLen);
    result[maxLen] = '\0';  // Null-terminate the result string
}

int main() {
    // Test string
    const char* str = "babad";
    char result[1000];  // Buffer to store the result
    
    // Display the original string
    printf("Original string: %s\n", str);
    
    // Find the longest palindromic substring
    longestPalindromicSubstring(str, result);
    
    // Display the result
    printf("Longest palindromic substring: %s\n", result);
    
    return 0;
}