#include <iostream>
#include <string>

// Implementation of strstr-like functionality
size_t myStrStr(const std::string& haystack, const std::string& needle) {
    if (needle.empty()) return 0;
    
    for (size_t i = 0; i <= haystack.length() - needle.length(); i++) {
        size_t j;
        for (j = 0; j < needle.length(); j++) {
            if (haystack[i + j] != needle[j])
                break;
        }
        if (j == needle.length())
            return i;
    }
    
    return std::string::npos;
}

// Alternative implementation using STL
size_t findSubstring(const std::string& haystack, const std::string& needle) {
    return haystack.find(needle);
}

int main() {
    std::string haystack = "hello world";
    std::string needle = "world";
    
    std::cout << "Haystack: " << haystack << "\nNeedle: " << needle << std::endl;
    
    // Using custom implementation
    size_t pos = myStrStr(haystack, needle);
    if (pos != std::string::npos) {
        std::cout << "Found at position (custom): " << pos << std::endl;
    } else {
        std::cout << "Substring not found (custom)" << std::endl;
    }
    
    // Using STL implementation
    pos = findSubstring(haystack, needle);
    if (pos != std::string::npos) {
        std::cout << "Found at position (STL): " << pos << std::endl;
    } else {
        std::cout << "Substring not found (STL)" << std::endl;
    }
    
    return 0;
}