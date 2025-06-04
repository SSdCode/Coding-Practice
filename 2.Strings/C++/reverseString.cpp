/**
 * Reverse String
 * 
 * This program demonstrates two different approaches to reverse a string in-place:
 * 1. Using the standard library function std::reverse
 * 2. Using a manual two-pointer approach
 * 
 * Time Complexity: O(n) for both approaches, where n is the length of the string
 * Space Complexity: O(1) for both approaches (in-place reversal)
 * 
 * Input: Strings like "Hello, World!" and "Programming"
 * Output: The reversed strings (e.g., "!dlroW ,olleH" and "gnimmargorP")
 */

#include <iostream>  // For input/output operations
#include <string>    // For string operations
#include <algorithm> // For std::reverse and std::swap functions

/**
 * reverseString - Reverse a string using the standard library function
 * @str: The input string (passed by reference to modify in-place)
 * 
 * This function uses std::reverse from the <algorithm> header to reverse
 * the string in-place. std::reverse is highly optimized and is generally
 * the preferred method when available.
 * 
 * The function works by swapping characters from both ends moving inward
 * until the pointers meet in the middle.
 */
void reverseString(std::string& str) {
    std::reverse(str.begin(), str.end());
}

/**
 * reverseStringManual - Reverse a string manually using two pointers
 * @str: The input string (passed by reference to modify in-place)
 * 
 * This function implements the two-pointer technique to reverse a string in-place:
 * 1. Initialize two pointers, one at the beginning and one at the end of the string
 * 2. Swap the characters at the two pointers
 * 3. Move the pointers toward each other
 * 4. Repeat until the pointers meet or cross
 * 
 * This approach is equivalent to what std::reverse does internally but is
 * implemented manually for educational purposes.
 */
void reverseStringManual(std::string& str) {
    int left = 0, right = str.length() - 1;  // Initialize pointers
    
    // Continue until pointers meet or cross
    while (left < right) {
        // Swap characters at left and right pointers
        std::swap(str[left], str[right]);
        
        // Move pointers toward each other
        left++;
        right--;
    }
}

int main() {
    // Test strings
    std::string str = "Hello, World!";
    std::string str2 = "Programming";
    
    // Display original strings
    std::cout << "Original strings:\n" << str << "\n" << str2 << std::endl;
    
    // Reverse strings using both methods
    reverseString(str);  // Using std::reverse
    reverseStringManual(str2);  // Using manual implementation
    
    // Display reversed strings
    std::cout << "After reversal:\n" << str << "\n" << str2 << std::endl;
    
    return 0;
}