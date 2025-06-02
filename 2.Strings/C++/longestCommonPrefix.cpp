#include <iostream>
#include <string>
#include <vector>
#include <algorithm>

std::string longestCommonPrefix(const std::vector<std::string>& strs) {
    if (strs.empty()) return "";
    if (strs.size() == 1) return strs[0];
    
    // Find the shortest string length
    size_t minLen = strs[0].length();
    for (const auto& str : strs) {
        minLen = std::min(minLen, str.length());
    }
    
    // Compare characters
    for (size_t i = 0; i < minLen; i++) {
        char current = strs[0][i];
        for (const auto& str : strs) {
            if (str[i] != current) {
                return strs[0].substr(0, i);
            }
        }
    }
    
    return strs[0].substr(0, minLen);
}

// Alternative implementation using sorting
std::string longestCommonPrefixUsingSorting(std::vector<std::string> strs) {
    if (strs.empty()) return "";
    if (strs.size() == 1) return strs[0];
    
    // Sort the array of strings
    std::sort(strs.begin(), strs.end());
    
    // Compare first and last string
    const std::string& first = strs[0];
    const std::string& last = strs[strs.size() - 1];
    
    size_t i = 0;
    while (i < first.length() && i < last.length() && first[i] == last[i]) {
        i++;
    }
    
    return first.substr(0, i);
}

int main() {
    std::vector<std::string> strs = {"flower", "flow", "flight"};
    
    std::cout << "Strings:" << std::endl;
    for (const auto& str : strs) {
        std::cout << str << std::endl;
    }
    
    std::cout << "\nLongest common prefix: " << longestCommonPrefix(strs) << std::endl;
    std::cout << "Using sorting method: " << longestCommonPrefixUsingSorting(strs) << std::endl;
    
    return 0;
}