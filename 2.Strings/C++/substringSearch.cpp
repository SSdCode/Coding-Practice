/**
 * Substring Search
 * 
 * This program demonstrates two different approaches to search for a substring within a string:
 * 1. A custom implementation similar to the C strstr function (brute force approach)
 * 2. Using the standard library's string::find method
 * 
 * Time Complexity:
 * - Custom implementation (myStrStr): O(n*m) where n is the length of the haystack and m is the length of the needle
 * - STL implementation (string::find): Typically O(n*m) but can be more efficient with optimizations
 * 
 * Space Complexity: O(1) for both implementations (constant extra space)
 * 
 * Input: A haystack string "hello world" and a needle string "world"
 * Output: The position where the needle is found in the haystack, or string::npos if not found
 */

#include <iostream>  // For input/output operations
#include <string>    // For string operations

/**
 * myStrStr - Find the first occurrence of a substring in a string (custom implementation)
 * @haystack: The string to search in (passed by reference for efficiency)
 * @needle: The substring to search for (passed by reference for efficiency)
 * 
 * This function implements a brute force approach to substring searching:
 * 1. For each position in the haystack, try to match the needle
 * 2. If a mismatch is found, move to the next position in the haystack
 * 3. If the entire needle matches, return the starting position
 * 
 * Edge case: If the needle is empty, return 0 (matches at the beginning)
 * 
 * Returns: The position of the first occurrence, or string::npos if not found
 */
size_t myStrStr(const std::string& haystack, const std::string& needle) {
    // Edge case: empty needle matches at position 0
    if (needle.empty()) return 0;
    
    // Try each potential starting position in the haystack
    // We only need to check positions up to (haystack.length() - needle.length())
    for (size_t i = 0; i <= haystack.length() - needle.length(); i++) {
        size_t j;
        // Try to match the entire needle starting at position i
        for (j = 0; j < needle.length(); j++) {
            if (haystack[i + j] != needle[j])
                break;  // Mismatch found, break inner loop
        }
        // If we matched the entire needle (j reached needle.length())
        if (j == needle.length())
            return i;  // Return the starting position
    }
    
    // Needle not found in haystack
    return std::string::npos;  // Special value indicating "not found"
}

/**
 * findSubstring - Find the first occurrence of a substring using the STL
 * @haystack: The string to search in
 * @needle: The substring to search for
 * 
 * This function is a simple wrapper around the string::find method,
 * which is part of the C++ Standard Library. The string::find method
 * typically uses more efficient algorithms than the brute force approach,
 * such as the Boyer-Moore or Knuth-Morris-Pratt algorithms.
 * 
 * Returns: The position of the first occurrence, or string::npos if not found
 */
size_t findSubstring(const std::string& haystack, const std::string& needle) {
    return haystack.find(needle);  // Use the built-in find method
}

int main() {
    // Test strings
    std::string haystack = "hello world";
    std::string needle = "world";
    
    // Display the input strings
    std::cout << "Haystack: " << haystack << "\nNeedle: " << needle << std::endl;
    
    // Test the custom implementation
    size_t pos = myStrStr(haystack, needle);
    if (pos != std::string::npos) {
        std::cout << "Found at position (custom): " << pos << std::endl;
    } else {
        std::cout << "Substring not found (custom)" << std::endl;
    }
    
    // Test the STL implementation
    pos = findSubstring(haystack, needle);
    if (pos != std::string::npos) {
        std::cout << "Found at position (STL): " << pos << std::endl;
    } else {
        std::cout << "Substring not found (STL)" << std::endl;
    }
    
    return 0;
}