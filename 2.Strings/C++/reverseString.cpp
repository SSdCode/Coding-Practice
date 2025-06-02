#include <iostream>
#include <string>
#include <algorithm>

void reverseString(std::string& str) {
    std::reverse(str.begin(), str.end());
}

// Alternative implementation without using std::reverse
void reverseStringManual(std::string& str) {
    int left = 0, right = str.length() - 1;
    while (left < right) {
        std::swap(str[left], str[right]);
        left++;
        right--;
    }
}

int main() {
    std::string str = "Hello, World!";
    std::string str2 = "Programming";
    
    std::cout << "Original strings:\n" << str << "\n" << str2 << std::endl;
    
    reverseString(str);
    reverseStringManual(str2);
    
    std::cout << "After reversal:\n" << str << "\n" << str2 << std::endl;
    
    return 0;
}