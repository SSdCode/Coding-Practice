#include <iostream>
#include <string>
#include <unordered_set>

std::string removeDuplicates(const std::string& str) {
    std::string result;
    std::unordered_set<char> seen;
    
    for (char c : str) {
        if (seen.insert(c).second) {
            result += c;
        }
    }
    
    return result;
}

// Alternative implementation without using hash set
std::string removeDuplicatesManual(std::string str) {
    if (str.empty()) return str;
    
    int writeIndex = 0;
    
    for (int i = 1; i < str.length(); i++) {
        int j;
        for (j = 0; j <= writeIndex; j++) {
            if (str[i] == str[j])
                break;
        }
        
        if (j == writeIndex + 1) {
            writeIndex++;
            str[writeIndex] = str[i];
        }
    }
    
    str.resize(writeIndex + 1);
    return str;
}

int main() {
    std::string str1 = "programming";
    std::string str2 = "hello world";
    
    std::cout << "Original string 1: " << str1 << std::endl;
    std::cout << "After removing duplicates: " << removeDuplicates(str1) << std::endl;
    
    std::cout << "\nOriginal string 2: " << str2 << std::endl;
    std::cout << "After removing duplicates (manual): " << removeDuplicatesManual(str2) << std::endl;
    
    return 0;
}