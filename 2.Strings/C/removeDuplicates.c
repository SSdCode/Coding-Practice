/**
 * Remove Duplicates from String
 * 
 * This program removes duplicate characters from a string, preserving the
 * order of the first occurrence of each character.
 * 
 * Algorithm:
 * 1. Handle edge cases (NULL string or string with length < 2)
 * 2. Keep track of unique characters seen so far using a 'tail' index
 * 3. For each character in the string, check if it already exists in the processed part
 * 4. If it's a new character, add it to the result at the 'tail' position
 * 5. Terminate the string at the new length
 * 
 * Time Complexity: O(n²) where n is the length of the string
 * Space Complexity: O(1) as we modify the string in-place
 * 
 * Input: A string - "programming"
 * Output: String with duplicates removed - "progamin"
 */

#include <stdio.h>
#include <string.h>

/**
 * removeDuplicates - Remove duplicate characters from a string in-place
 * @str: The input string to modify
 * 
 * This function removes all duplicate characters from the string while
 * preserving the order of the first occurrence of each character.
 */
void removeDuplicates(char *str) {
    // Handle NULL string
    if (str == NULL)
        return;
    
    // Get string length
    int len = strlen(str);
    
    // No duplicates possible in strings of length 0 or 1
    if (len < 2)
        return;
    
    // 'tail' keeps track of the position where the next unique character will be placed
    // We assume the first character is always unique, so start with tail = 1
    int tail = 1;
    
    // Process each character starting from the second one
    for (int i = 1; i < len; i++) {
        int j;
        // Check if the current character already exists in the processed part
        for (j = 0; j < tail; j++) {
            if (str[i] == str[j])
                break;  // Duplicate found
        }
        
        // If we went through the entire processed part without finding a duplicate
        if (j == tail) {
            str[tail] = str[i];  // Add this unique character to the result
            tail++;  // Move the tail pointer forward
        }
    }
    
    // Terminate the string at the new length
    str[tail] = '\0';
}

int main() {
    // Test string
    char str[] = "programming";
    
    // Display the original string
    printf("Original string: %s\n", str);
    
    // Remove duplicates and display the result
    removeDuplicates(str);
    printf("After removing duplicates: %s\n", str);
    
    return 0;
}