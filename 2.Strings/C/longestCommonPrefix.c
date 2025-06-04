/**
 * Longest Common Prefix Finder
 * 
 * This program finds the longest common prefix string amongst an array of strings.
 * If there is no common prefix, it returns an empty string.
 * 
 * Algorithm:
 * 1. Handle edge cases (empty array or single string)
 * 2. Take characters from the first string one by one
 * 3. For each character, check if it exists at the same position in all other strings
 * 4. If a mismatch is found, return the prefix found so far
 * 5. Otherwise, add the character to the prefix and continue
 * 
 * Time Complexity: O(S) where S is the sum of all characters in all strings
 * Space Complexity: O(m) where m is the length of the smallest string
 * 
 * Input: Array of strings - ["flower", "flow", "flight"]
 * Output: Longest common prefix - "fl"
 */

#include <stdio.h>
#include <string.h>
#include <stdlib.h>

/**
 * longestCommonPrefix - Find the longest common prefix among an array of strings
 * @strs: Array of strings to compare
 * @strsSize: Number of strings in the array
 * 
 * Returns: Dynamically allocated string containing the longest common prefix
 *          (Caller is responsible for freeing this memory)
 */
char* longestCommonPrefix(char** strs, int strsSize) {
    // Handle edge cases
    if (strsSize == 0) return "";  // Empty array
    if (strsSize == 1) return strs[0];  // Single string is its own prefix
    
    // Allocate memory for the result
    // Assuming max length of 200 characters for any string
    char* prefix = (char*)malloc(201);
    int index = 0;
    char curr;
    
    // Take first string's characters one by one
    while ((curr = strs[0][index]) != '\0') {
        // Check this character in all other strings at the same position
        for (int i = 1; i < strsSize; i++) {
            // If we reach the end of any string or find a mismatch
            if (strs[i][index] != curr) {
                prefix[index] = '\0';  // Terminate the prefix string
                return prefix;
            }
        }
        // Add the matching character to our prefix
        prefix[index] = curr;
        index++;
    }
    
    // Terminate the prefix string
    prefix[index] = '\0';
    return prefix;
}

int main() {
    // Test array of strings
    char* strs[] = {"flower", "flow", "flight"};
    int size = 3;
    
    // Display the input strings
    printf("Strings:\n");
    for (int i = 0; i < size; i++) {
        printf("%s\n", strs[i]);
    }
    
    // Find and display the longest common prefix
    char* result = longestCommonPrefix(strs, size);
    printf("Longest common prefix: %s\n", result);
    
    // Free the dynamically allocated memory
    free(result);
    
    return 0;
}