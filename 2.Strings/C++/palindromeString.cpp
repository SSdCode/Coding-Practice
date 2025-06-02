#include <iostream>
#include <string>
#include <cctype>

bool isPalindrome(const std::string& str) {
    std::string cleanStr;
    // Remove non-alphanumeric characters and convert to lowercase
    for (char c : str) {
        if (std::isalnum(c)) {
            cleanStr += std::tolower(c);
        }
    }
    
    int left = 0, right = cleanStr.length() - 1;
    while (left < right) {
        if (cleanStr[left] != cleanStr[right]) {
            return false;
        }
        left++;
        right--;
    }
    return true;
}

int main() {
    std::string str1 = "A man, a plan, a canal: Panama";
    std::string str2 = "race a car";
    
    std::cout << "String 1: " << str1 << std::endl;
    std::cout << "Is palindrome? " << (isPalindrome(str1) ? "Yes" : "No") << std::endl;
    
    std::cout << "String 2: " << str2 << std::endl;
    std::cout << "Is palindrome? " << (isPalindrome(str2) ? "Yes" : "No") << std::endl;
    
    return 0;
}