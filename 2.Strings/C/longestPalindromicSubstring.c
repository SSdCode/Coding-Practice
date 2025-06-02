#include <stdio.h>
#include <string.h>

// Helper function to expand around center
void expandAroundCenter(const char* s, int left, int right, int* start, int* maxLen) {
    while (left >= 0 && s[right] != '\0' && s[left] == s[right]) {
        left--;
        right++;
    }
    
    int len = right - left - 1;
    if (len > *maxLen) {
        *start = left + 1;
        *maxLen = len;
    }
}

void longestPalindromicSubstring(const char* s, char* result) {
    int n = strlen(s);
    if (n < 2) {
        strcpy(result, s);
        return;
    }
    
    int start = 0;
    int maxLen = 1;
    
    // Check for odd length palindromes
    for (int i = 0; s[i] != '\0'; i++) {
        expandAroundCenter(s, i, i, &start, &maxLen);
    }
    
    // Check for even length palindromes
    for (int i = 0; s[i] != '\0'; i++) {
        expandAroundCenter(s, i, i + 1, &start, &maxLen);
    }
    
    // Copy the longest palindromic substring to result
    strncpy(result, s + start, maxLen);
    result[maxLen] = '\0';
}

int main() {
    const char* str = "babad";
    char result[1000];
    
    printf("Original string: %s\n", str);
    longestPalindromicSubstring(str, result);
    printf("Longest palindromic substring: %s\n", result);
    
    return 0;
}