#include <iostream>
#include <string>

// Helper function to expand around center
void expandAroundCenter(const std::string& s, int left, int right, int& start, int& maxLen) {
    while (left >= 0 && right < s.length() && s[left] == s[right]) {
        left--;
        right++;
    }
    
    int len = right - left - 1;
    if (len > maxLen) {
        start = left + 1;
        maxLen = len;
    }
}

std::string longestPalindromicSubstring(const std::string& s) {
    if (s.length() < 2) return s;
    
    int start = 0;
    int maxLen = 1;
    
    // Check for odd length palindromes
    for (int i = 0; i < s.length(); i++) {
        expandAroundCenter(s, i, i, start, maxLen);
    }
    
    // Check for even length palindromes
    for (int i = 0; i < s.length() - 1; i++) {
        expandAroundCenter(s, i, i + 1, start, maxLen);
    }
    
    return s.substr(start, maxLen);
}

// Alternative implementation using dynamic programming
std::string longestPalindromicSubstringDP(const std::string& s) {
    int n = s.length();
    if (n < 2) return s;
    
    // dp[i][j] represents whether s[i..j] is palindrome
    std::vector<std::vector<bool>> dp(n, std::vector<bool>(n, false));
    
    // All substrings of length 1 are palindromes
    for (int i = 0; i < n; i++) {
        dp[i][i] = true;
    }
    
    int start = 0;
    int maxLen = 1;
    
    // Check for substrings of length 2
    for (int i = 0; i < n - 1; i++) {
        if (s[i] == s[i + 1]) {
            dp[i][i + 1] = true;
            start = i;
            maxLen = 2;
        }
    }
    
    // Check for lengths greater than 2
    for (int len = 3; len <= n; len++) {
        for (int i = 0; i < n - len + 1; i++) {
            int j = i + len - 1;
            if (s[i] == s[j] && dp[i + 1][j - 1]) {
                dp[i][j] = true;
                if (len > maxLen) {
                    start = i;
                    maxLen = len;
                }
            }
        }
    }
    
    return s.substr(start, maxLen);
}

int main() {
    std::string str = "babad";
    std::cout << "Original string: " << str << std::endl;
    
    std::string result1 = longestPalindromicSubstring(str);
    std::cout << "Longest palindromic substring (expand around center): " << result1 << std::endl;
    
    std::string result2 = longestPalindromicSubstringDP(str);
    std::cout << "Longest palindromic substring (dynamic programming): " << result2 << std::endl;
    
    return 0;
}