/**
 * Count Vowels and Consonants
 * 
 * This program counts the number of vowels and consonants in a given string.
 * It handles both uppercase and lowercase letters and ignores non-alphabetic characters.
 * 
 * Time Complexity: O(n) where n is the length of the string
 * Space Complexity: O(1) as we only use a constant amount of extra space
 * 
 * Input: Strings like "Hello World" and "OpenAI GPT"
 * Output: The count of vowels and consonants in each string
 */

#include <iostream>  // For input/output operations
#include <string>    // For string operations
#include <cctype>    // For character classification functions (isalpha, tolower)

/**
 * countVowelsAndConsonants - Count the number of vowels and consonants in a string
 * @str: The input string (passed by reference for efficiency)
 * 
 * This function iterates through each character of the string, checks if it's an
 * alphabetic character, and then determines if it's a vowel or consonant.
 * Non-alphabetic characters (spaces, numbers, symbols) are ignored.
 * 
 * The function is case-insensitive, treating uppercase and lowercase letters the same.
 * 
 * Vowels are: a, e, i, o, u (in any case)
 * Consonants are all other alphabetic characters
 */
void countVowelsAndConsonants(const std::string& str) {
    int vowels = 0, consonants = 0;
    
    // Iterate through each character in the string
    for (char c : str) {
        // Check if the character is alphabetic (a-z or A-Z)
        if (std::isalpha(c)) {
            // Convert to lowercase for case-insensitive comparison
            char ch = std::tolower(c);
            
            // Check if the character is a vowel
            if (ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u') {
                vowels++;
            } else {
                // If it's not a vowel but is alphabetic, it's a consonant
                consonants++;
            }
        }
        // Non-alphabetic characters are ignored
    }
    
    // Display the results
    std::cout << "Vowels: " << vowels << "\nConsonants: " << consonants << std::endl;
}

int main() {
    // Test with first example string
    std::string str = "Hello World";
    std::cout << "String: " << str << std::endl;
    countVowelsAndConsonants(str);
    
    // Test with second example string
    str = "OpenAI GPT";
    std::cout << "\nString: " << str << std::endl;
    countVowelsAndConsonants(str);
    
    return 0;
}