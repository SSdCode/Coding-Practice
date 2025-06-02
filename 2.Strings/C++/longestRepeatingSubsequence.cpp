#include <iostream>
#include <string>
#include <vector>
#include <algorithm>

int longestRepeatingSubsequence(const std::string& str) {
    int n = str.length();
    std::vector<std::vector<int>> dp(n + 1, std::vector<int>(n + 1, 0));
    
    // Fill the dp table
    for (int i = 1; i <= n; i++) {
        for (int j = 1; j <= n; j++) {
            if (str[i - 1] == str[j - 1] && i != j) {
                dp[i][j] = dp[i - 1][j - 1] + 1;
            } else {
                dp[i][j] = std::max(dp[i][j - 1], dp[i - 1][j]);
            }
        }
    }
    
    return dp[n][n];
}

// Function to also print the subsequence
std::string printLongestRepeatingSubsequence(const std::string& str) {
    int n = str.length();
    std::vector<std::vector<int>> dp(n + 1, std::vector<int>(n + 1, 0));
    
    // Fill the dp table
    for (int i = 1; i <= n; i++) {
        for (int j = 1; j <= n; j++) {
            if (str[i - 1] == str[j - 1] && i != j) {
                dp[i][j] = dp[i - 1][j - 1] + 1;
            } else {
                dp[i][j] = std::max(dp[i][j - 1], dp[i - 1][j]);
            }
        }
    }
    
    // Backtrack to find the subsequence
    std::string result;
    int i = n, j = n;
    
    while (i > 0 && j > 0) {
        if (str[i - 1] == str[j - 1] && i != j) {
            result = str[i - 1] + result;
            i--;
            j--;
        }
        else if (dp[i - 1][j] > dp[i][j - 1]) {
            i--;
        }
        else {
            j--;
        }
    }
    
    return result;
}

int main() {
    std::string str = "AABEBCDD";
    
    std::cout << "String: " << str << std::endl;
    std::cout << "Length of longest repeating subsequence: " 
              << longestRepeatingSubsequence(str) << std::endl;
    
    std::string subsequence = printLongestRepeatingSubsequence(str);
    if (!subsequence.empty()) {
        std::cout << "One of the longest repeating subsequences: " << subsequence << std::endl;
    }
    
    return 0;
}