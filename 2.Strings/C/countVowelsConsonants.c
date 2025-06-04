/**
 * Vowels and Consonants Counter
 * 
 * This program counts the number of vowels and consonants in a given string.
 * It ignores non-alphabetic characters and is case-insensitive.
 * 
 * Algorithm:
 * 1. Iterate through each character of the string
 * 2. Convert the character to lowercase
 * 3. Check if the character is alphabetic
 * 4. If it's a vowel (a, e, i, o, u), increment vowel counter
 * 5. If it's a consonant, increment consonant counter
 * 
 * Time Complexity: O(n) where n is the length of the string
 * Space Complexity: O(1) as we only use two counter variables
 * 
 * Input: A string - "Hello World"
 * Output: Count of vowels and consonants in the string
 */

#include <stdio.h>
#include <ctype.h>  // For tolower() and isalpha() functions

/**
 * countVowelsAndConsonants - Count vowels and consonants in a string
 * @str: The input string to analyze
 * 
 * This function counts and prints the number of vowels and consonants
 * in the given string. It ignores non-alphabetic characters.
 */
void countVowelsAndConsonants(const char *str) {
    int vowels = 0, consonants = 0;
    
    // Process each character in the string
    while (*str) {
        // Convert to lowercase for case-insensitive comparison
        char ch = tolower(*str);
        
        // Only count alphabetic characters
        if (isalpha(ch)) {
            // Check if the character is a vowel
            if (ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u') {
                vowels++;
            } else {
                consonants++;
            }
        }
        // Move to the next character
        str++;
    }
    
    // Display the results
    printf("Vowels: %d\nConsonants: %d\n", vowels, consonants);
}

int main() {
    // Test string
    char str[] = "Hello World";
    
    // Display the input string
    printf("String: %s\n", str);
    
    // Count and display vowels and consonants
    countVowelsAndConsonants(str);
    
    return 0;
}