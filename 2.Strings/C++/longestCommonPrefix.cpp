/**
 * Longest Common Prefix
 * 
 * This program finds the longest common prefix string amongst an array of strings
 * using two different approaches:
 * 1. Character-by-character comparison
 * 2. Sorting-based approach
 * 
 * Time Complexity:
 * - Character-by-character: O(S) where S is the sum of all characters in all strings
 * - Sorting-based: O(n log n) for sorting + O(m) for comparison, where n is the number of strings
 *   and m is the length of the shortest string
 * 
 * Space Complexity:
 * - Character-by-character: O(1) extra space
 * - Sorting-based: O(1) extra space if we ignore the sorting space
 * 
 * Input: Array of strings (e.g., ["flower", "flow", "flight"])
 * Output: The longest common prefix (e.g., "fl")
 */

#include <iostream>  // For input/output operations
#include <string>    // For string operations
#include <vector>    // For vector container
#include <algorithm> // For min and sort functions

/**
 * longestCommonPrefix - Find the longest common prefix using character-by-character comparison
 * @strs: Vector of strings to compare
 * 
 * This function compares characters at the same position across all strings.
 * It first finds the length of the shortest string to avoid out-of-bounds access,
 * then compares each character position across all strings until it finds a mismatch.
 * 
 * Returns: The longest common prefix as a string
 */
std::string longestCommonPrefix(const std::vector<std::string>& strs) {
    // Handle edge cases
    if (strs.empty()) return "";  // Empty array
    if (strs.size() == 1) return strs[0];  // Single string is its own prefix
    
    // Find the shortest string length to avoid out-of-bounds access
    size_t minLen = strs[0].length();
    for (const auto& str : strs) {
        minLen = std::min(minLen, str.length());
    }
    
    // Compare characters at each position across all strings
    for (size_t i = 0; i < minLen; i++) {
        char current = strs[0][i];  // Get character from first string
        for (const auto& str : strs) {
            // If we find a mismatch, return the prefix up to this point
            if (str[i] != current) {
                return strs[0].substr(0, i);
            }
        }
    }
    
    // If we get here, the common prefix is the shortest string
    return strs[0].substr(0, minLen);
}

/**
 * longestCommonPrefixUsingSorting - Find the longest common prefix using sorting
 * @strs: Vector of strings to compare (passed by value as we need to sort it)
 * 
 * This function uses the insight that after sorting, the first and last strings
 * in lexicographical order will have the smallest common prefix amongst all strings.
 * 
 * The approach is:
 * 1. Sort the array of strings
 * 2. Compare only the first and last strings
 * 3. The common prefix of these two strings will be the common prefix for all
 * 
 * Returns: The longest common prefix as a string
 */
std::string longestCommonPrefixUsingSorting(std::vector<std::string> strs) {
    // Handle edge cases
    if (strs.empty()) return "";  // Empty array
    if (strs.size() == 1) return strs[0];  // Single string is its own prefix
    
    // Sort the array of strings lexicographically
    std::sort(strs.begin(), strs.end());
    
    // After sorting, we only need to compare the first and last strings
    // Their common prefix will be the common prefix for all strings
    const std::string& first = strs[0];
    const std::string& last = strs[strs.size() - 1];
    
    // Find the common prefix between first and last strings
    size_t i = 0;
    while (i < first.length() && i < last.length() && first[i] == last[i]) {
        i++;
    }
    
    // Return the common prefix
    return first.substr(0, i);
}

int main() {
    // Test array of strings
    std::vector<std::string> strs = {"flower", "flow", "flight"};
    
    // Display the input strings
    std::cout << "Strings:" << std::endl;
    for (const auto& str : strs) {
        std::cout << str << std::endl;
    }
    
    // Find and display the longest common prefix using both methods
    std::cout << "\nLongest common prefix: " << longestCommonPrefix(strs) << std::endl;
    std::cout << "Using sorting method: " << longestCommonPrefixUsingSorting(strs) << std::endl;
    
    return 0;
}