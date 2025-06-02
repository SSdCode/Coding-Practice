#include <iostream>
#include <string>
#include <algorithm>
#include <cctype>
#include <unordered_map>

bool areAnagrams(std::string str1, std::string str2) {
    // Convert both strings to lowercase
    std::transform(str1.begin(), str1.end(), str1.begin(), ::tolower);
    std::transform(str2.begin(), str2.end(), str2.begin(), ::tolower);
    
    // Sort both strings and compare
    std::sort(str1.begin(), str1.end());
    std::sort(str2.begin(), str2.end());
    
    return str1 == str2;
}

// Alternative implementation using hash map
bool areAnagramsUsingMap(const std::string& str1, const std::string& str2) {
    std::unordered_map<char, int> charCount;
    
    // Count characters in first string
    for (char c : str1) {
        char ch = std::tolower(c);
        charCount[ch]++;
    }
    
    // Decrement count for second string
    for (char c : str2) {
        char ch = std::tolower(c);
        charCount[ch]--;
        if (charCount[ch] < 0) {
            return false;
        }
    }
    
    // Check if all counts are zero
    for (const auto& pair : charCount) {
        if (pair.second != 0) {
            return false;
        }
    }
    
    return true;
}

int main() {
    std::string str1 = "Listen";
    std::string str2 = "Silent";
    
    std::cout << "String 1: " << str1 << "\nString 2: " << str2 << std::endl;
    std::cout << "Are anagrams (using sort)? " << (areAnagrams(str1, str2) ? "Yes" : "No") << std::endl;
    std::cout << "Are anagrams (using map)? " << (areAnagramsUsingMap(str1, str2) ? "Yes" : "No") << std::endl;
    
    return 0;
}