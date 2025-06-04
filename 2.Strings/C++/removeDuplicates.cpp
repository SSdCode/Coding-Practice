/**
 * Remove Duplicates from String
 * 
 * This program demonstrates two different approaches to remove duplicate characters from a string:
 * 1. Using an unordered_set (hash set) to track seen characters
 * 2. Using a manual in-place approach without additional data structures
 * 
 * Time Complexity:
 * - Hash set approach: O(n) where n is the length of the string
 * - Manual approach: O(n²) due to the nested loops
 * 
 * Space Complexity:
 * - Hash set approach: O(k) where k is the number of unique characters (at most 256 for ASCII)
 * - Manual approach: O(1) extra space (in-place modification)
 * 
 * Input: Strings like "programming" and "hello world"
 * Output: The strings with duplicate characters removed (e.g., "progamin" and "helo wrd")
 */

#include <iostream>  // For input/output operations
#include <string>    // For string operations
#include <unordered_set>  // For hash set implementation

/**
 * removeDuplicates - Remove duplicate characters using a hash set
 * @str: The input string (passed by reference for efficiency)
 * 
 * This function uses an unordered_set (hash set) to track characters that have been seen.
 * It builds a new string containing only the first occurrence of each character.
 * 
 * The approach is:
 * 1. Create an empty result string and an empty hash set
 * 2. Iterate through each character in the input string
 * 3. If the character hasn't been seen before (can be inserted into the set),
 *    add it to the result string
 * 
 * Returns: A new string with duplicate characters removed
 */
std::string removeDuplicates(const std::string& str) {
    std::string result;  // Will hold the string with duplicates removed
    std::unordered_set<char> seen;  // Tracks characters we've already seen
    
    for (char c : str) {
        // insert() returns a pair where .second is true if insertion took place
        // (meaning the character wasn't already in the set)
        if (seen.insert(c).second) {
            result += c;  // Add character to result only if it's the first occurrence
        }
    }
    
    return result;
}

/**
 * removeDuplicatesManual - Remove duplicate characters without using additional data structures
 * @str: The input string (passed by value as we'll modify it)
 * 
 * This function uses an in-place approach to remove duplicates:
 * 1. Keep track of a write index that points to the end of the result string
 * 2. For each character, check if it already exists in the result portion
 * 3. If not, add it to the result portion and increment the write index
 * 
 * Note: This implementation assumes the first character is always part of the result
 * and starts checking from the second character.
 * 
 * Returns: The modified string with duplicate characters removed
 */
std::string removeDuplicatesManual(std::string str) {
    if (str.empty()) return str;  // Handle empty string case
    
    int writeIndex = 0;  // Points to the end of the result string
    
    // Start from the second character (index 1)
    for (int i = 1; i < str.length(); i++) {
        // Check if the current character already exists in the result portion
        int j;
        for (j = 0; j <= writeIndex; j++) {
            if (str[i] == str[j])
                break;  // Character already exists
        }
        
        // If we went through the entire result portion without finding a match
        if (j == writeIndex + 1) {
            writeIndex++;  // Increment the write index
            str[writeIndex] = str[i];  // Add the character to the result portion
        }
    }
    
    // Resize the string to remove unused characters
    str.resize(writeIndex + 1);
    return str;
}

int main() {
    // Test strings
    std::string str1 = "programming";
    std::string str2 = "hello world";
    
    // Test the hash set approach
    std::cout << "Original string 1: " << str1 << std::endl;
    std::cout << "After removing duplicates: " << removeDuplicates(str1) << std::endl;
    
    // Test the manual approach
    std::cout << "\nOriginal string 2: " << str2 << std::endl;
    std::cout << "After removing duplicates (manual): " << removeDuplicatesManual(str2) << std::endl;
    
    return 0;
}