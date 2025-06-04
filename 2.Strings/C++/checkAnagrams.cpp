/**
 * Anagram Checker
 * 
 * This program checks if two strings are anagrams of each other using two different methods:
 * 1. Sorting approach - Sort both strings and compare them
 * 2. Hash map approach - Count character frequencies and verify they match
 * 
 * Two strings are anagrams if they contain the same characters with the same frequencies,
 * regardless of order. For example, "listen" and "silent" are anagrams.
 * 
 * Time Complexity:
 * - Sorting approach: O(n log n) where n is the length of the strings
 * - Hash map approach: O(n) where n is the total length of both strings
 * 
 * Space Complexity:
 * - Sorting approach: O(1) if sorting in-place, otherwise O(n)
 * - Hash map approach: O(k) where k is the size of the character set (constant for ASCII)
 * 
 * Input: Two strings - "Listen" and "Silent"
 * Output: Whether the strings are anagrams using both methods
 */

#include <iostream>  // For input/output operations
#include <string>    // For string operations
#include <algorithm> // For transform and sort functions
#include <cctype>    // For tolower function
#include <unordered_map> // For hash map implementation

/**
 * areAnagrams - Check if two strings are anagrams using sorting approach
 * @str1: First string to compare
 * @str2: Second string to compare
 * 
 * This function takes copies of the strings, converts them to lowercase,
 * sorts them, and then compares them. If they are identical after sorting,
 * they are anagrams.
 * 
 * Returns: true if the strings are anagrams, false otherwise
 */
bool areAnagrams(std::string str1, std::string str2) {
    // Convert both strings to lowercase for case-insensitive comparison
    std::transform(str1.begin(), str1.end(), str1.begin(), ::tolower);
    std::transform(str2.begin(), str2.end(), str2.begin(), ::tolower);
    
    // Sort both strings and compare
    // After sorting, anagrams will have identical character sequences
    std::sort(str1.begin(), str1.end());
    std::sort(str2.begin(), str2.end());
    
    return str1 == str2;
}

/**
 * areAnagramsUsingMap - Check if two strings are anagrams using hash map approach
 * @str1: First string to compare (passed by reference for efficiency)
 * @str2: Second string to compare (passed by reference for efficiency)
 * 
 * This function uses a hash map to count character frequencies in both strings.
 * It increments counters for the first string and decrements for the second.
 * If all counters are zero at the end, the strings are anagrams.
 * 
 * This method is more efficient for longer strings as it avoids sorting.
 * It also allows for early termination if a character in the second string
 * appears more times than in the first string.
 * 
 * Returns: true if the strings are anagrams, false otherwise
 */
bool areAnagramsUsingMap(const std::string& str1, const std::string& str2) {
    std::unordered_map<char, int> charCount;
    
    // Count characters in first string (increment counters)
    for (char c : str1) {
        char ch = std::tolower(c);  // Convert to lowercase for case-insensitive comparison
        charCount[ch]++;
    }
    
    // Decrement count for second string
    for (char c : str2) {
        char ch = std::tolower(c);  // Convert to lowercase for case-insensitive comparison
        charCount[ch]--;
        // If any character appears more times in str2 than in str1, they're not anagrams
        if (charCount[ch] < 0) {
            return false;
        }
    }
    
    // Check if all counts are zero (all characters matched exactly)
    for (const auto& pair : charCount) {
        if (pair.second != 0) {
            return false;  // Some character appears more times in str1 than in str2
        }
    }
    
    return true;  // All character counts match
}

int main() {
    // Test strings
    std::string str1 = "Listen";
    std::string str2 = "Silent";
    
    // Display input strings
    std::cout << "String 1: " << str1 << "\nString 2: " << str2 << std::endl;
    
    // Check if strings are anagrams using both methods and display results
    std::cout << "Are anagrams (using sort)? " << (areAnagrams(str1, str2) ? "Yes" : "No") << std::endl;
    std::cout << "Are anagrams (using map)? " << (areAnagramsUsingMap(str1, str2) ? "Yes" : "No") << std::endl;
    
    return 0;
}