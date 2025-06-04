/**
 * Substring Search Implementation (strstr)
 * 
 * This program implements a custom version of the strstr() function,
 * which searches for the first occurrence of a substring (needle)
 * within a string (haystack).
 * 
 * Algorithm:
 * 1. Iterate through each position in the haystack string
 * 2. For each position, check if the substring starting at that position
 *    matches the needle string
 * 3. If a match is found, return a pointer to the starting position
 * 4. If no match is found, return NULL
 * 
 * Time Complexity: O(n*m) where n is the length of haystack and m is the length of needle
 * Space Complexity: O(1) as we only use a constant amount of extra space
 * 
 * Input: Two strings - haystack ("hello world") and needle ("world")
 * Output: Position of the first occurrence of needle in haystack, or message if not found
 */

#include <stdio.h>
#include <string.h>

/**
 * myStrStr - Custom implementation of strstr function
 * @haystack: The string to search in
 * @needle: The substring to search for
 * 
 * Returns: Pointer to the first occurrence of needle in haystack,
 *          or NULL if needle is not found
 */
char* myStrStr(const char* haystack, const char* needle) {
    // Edge case: empty needle always matches at the beginning
    if (*needle == '\0') return (char*)haystack;
    
    // Iterate through each position in the haystack
    for (int i = 0; haystack[i] != '\0'; i++) {
        int j;
        
        // Check if substring starting at current position matches the needle
        for (j = 0; needle[j] != '\0'; j++) {
            // If characters don't match, break the inner loop
            if (haystack[i + j] != needle[j])
                break;
        }
        
        // If we reached the end of needle, we found a match
        // (j equals the length of needle)
        if (needle[j] == '\0')
            return (char*)&haystack[i];
    }
    
    // Needle not found in haystack
    return NULL;
}

int main() {
    // Test strings
    const char* haystack = "hello world";
    const char* needle = "world";
    
    // Display input strings
    printf("Haystack: %s\nNeedle: %s\n", haystack, needle);
    
    // Search for needle in haystack
    char* result = myStrStr(haystack, needle);
    
    // Display result
    if (result != NULL) {
        // Calculate position by pointer arithmetic
        printf("Found at position: %ld\n", result - haystack);
    } else {
        printf("Substring not found\n");
    }
    
    return 0;
}