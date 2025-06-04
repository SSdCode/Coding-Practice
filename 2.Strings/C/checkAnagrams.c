/**
 * Anagram Checker
 * 
 * This program checks if two strings are anagrams of each other.
 * Two strings are anagrams if they contain the same characters with the same frequencies,
 * regardless of order. For example, "listen" and "silent" are anagrams.
 * 
 * Algorithm:
 * 1. Create a frequency counter array for all possible characters
 * 2. Increment counters for characters in the first string
 * 3. Decrement counters for characters in the second string
 * 4. If all counters are zero at the end, the strings are anagrams
 * 
 * Time Complexity: O(n) where n is the total length of both strings
 * Space Complexity: O(1) as we use a fixed-size array for character counting
 * 
 * Input: Two strings - "Listen" and "Silent"
 * Output: Message indicating whether the strings are anagrams
 */

#include <stdio.h>
#include <string.h>
#include <ctype.h>  // For tolower() function

// Define the size of the character count array
// Using 256 to cover all possible ASCII characters
#define MAX_CHARS 256

/**
 * areAnagrams - Check if two strings are anagrams
 * @str1: First string to compare
 * @str2: Second string to compare
 * 
 * Returns: 1 if the strings are anagrams, 0 otherwise
 */
int areAnagrams(const char *str1, const char *str2) {
    // Initialize character count array with zeros
    int count[MAX_CHARS] = {0};
    
    // Count characters in first string (case-insensitive)
    for (int i = 0; str1[i]; i++) {
        // Convert to lowercase to make comparison case-insensitive
        count[tolower(str1[i])]++;
    }
    
    // Subtract count for second string
    for (int i = 0; str2[i]; i++) {
        count[tolower(str2[i])]--;
    }
    
    // Check if all counts are zero
    // If any count is non-zero, the strings have different character frequencies
    for (int i = 0; i < MAX_CHARS; i++) {
        if (count[i] != 0) {
            return 0;  // Not anagrams
        }
    }
    return 1;  // Anagrams
}

int main() {
    // Test strings
    char str1[] = "Listen";
    char str2[] = "Silent";
    
    // Display input strings
    printf("String 1: %s\nString 2: %s\n", str1, str2);
    
    // Check if strings are anagrams and display result
    if (areAnagrams(str1, str2)) {
        printf("The strings are anagrams.\n");
    } else {
        printf("The strings are not anagrams.\n");
    }
    
    return 0;
}