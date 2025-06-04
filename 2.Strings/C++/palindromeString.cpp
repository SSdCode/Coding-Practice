/**
 * Palindrome String Checker
 * 
 * This program checks if a given string is a palindrome, ignoring non-alphanumeric characters
 * and case sensitivity. A palindrome reads the same forward and backward.
 * 
 * For example:
 * - "A man, a plan, a canal: Panama" is a palindrome when ignoring spaces, punctuation, and case
 * - "race a car" is not a palindrome
 * 
 * Time Complexity: O(n) where n is the length of the string
 * Space Complexity: O(n) for storing the cleaned string
 * 
 * Input: Strings like "A man, a plan, a canal: Panama" and "race a car"
 * Output: Whether each string is a palindrome or not
 */

#include <iostream>  // For input/output operations
#include <string>    // For string operations
#include <cctype>    // For character classification and conversion functions

/**
 * isPalindrome - Check if a string is a palindrome
 * @str: The input string (passed by reference for efficiency)
 * 
 * This function performs the following steps:
 * 1. Clean the string by removing non-alphanumeric characters and converting to lowercase
 * 2. Use two pointers (from start and end) to check if the string reads the same in both directions
 * 
 * A string is a palindrome if it reads the same forward and backward after cleaning.
 * 
 * Returns: true if the string is a palindrome, false otherwise
 */
bool isPalindrome(const std::string& str) {
    std::string cleanStr;
    // Remove non-alphanumeric characters and convert to lowercase
    for (char c : str) {
        if (std::isalnum(c)) {  // Check if character is alphanumeric (letter or digit)
            cleanStr += std::tolower(c);  // Convert to lowercase and add to cleaned string
        }
    }
    
    // Use two pointers to check if the string is a palindrome
    int left = 0, right = cleanStr.length() - 1;
    while (left < right) {
        // If characters at left and right pointers don't match, it's not a palindrome
        if (cleanStr[left] != cleanStr[right]) {
            return false;
        }
        // Move pointers toward each other
        left++;
        right--;
    }
    // If we get here, all characters matched, so it's a palindrome
    return true;
}

int main() {
    // Test strings
    std::string str1 = "A man, a plan, a canal: Panama";  // A palindrome
    std::string str2 = "race a car";  // Not a palindrome
    
    // Check and display results for the first string
    std::cout << "String 1: " << str1 << std::endl;
    std::cout << "Is palindrome? " << (isPalindrome(str1) ? "Yes" : "No") << std::endl;
    
    // Check and display results for the second string
    std::cout << "String 2: " << str2 << std::endl;
    std::cout << "Is palindrome? " << (isPalindrome(str2) ? "Yes" : "No") << std::endl;
    
    return 0;
}