public class LongestPalindromicSubstring {
    // Expand around center approach
    public static String longestPalindromicSubstring(String s) {
        if (s == null || s.length() < 2) return s;
        
        int start = 0;
        int maxLen = 1;
        
        for (int i = 0; i < s.length(); i++) {
            // Check for odd length palindromes
            expandAroundCenter(s, i, i, start, maxLen);
            
            // Check for even length palindromes
            expandAroundCenter(s, i, i + 1, start, maxLen);
        }
        
        return s.substring(start, start + maxLen);
    }
    
    private static void expandAroundCenter(String s, int left, int right, int start, int maxLen) {
        while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
            int len = right - left + 1;
            if (len > maxLen) {
                start = left;
                maxLen = len;
            }
            left--;
            right++;
        }
    }
    
    // Dynamic Programming approach
    public static String longestPalindromicSubstringDP(String s) {
        if (s == null || s.length() < 2) return s;
        
        int n = s.length();
        boolean[][] dp = new boolean[n][n];
        int start = 0;
        int maxLen = 1;
        
        // All substrings of length 1 are palindromes
        for (int i = 0; i < n; i++) {
            dp[i][i] = true;
        }
        
        // Check for substrings of length 2
        for (int i = 0; i < n - 1; i++) {
            if (s.charAt(i) == s.charAt(i + 1)) {
                dp[i][i + 1] = true;
                start = i;
                maxLen = 2;
            }
        }
        
        // Check for lengths greater than 2
        for (int len = 3; len <= n; len++) {
            for (int i = 0; i < n - len + 1; i++) {
                int j = i + len - 1;
                if (s.charAt(i) == s.charAt(j) && dp[i + 1][j - 1]) {
                    dp[i][j] = true;
                    if (len > maxLen) {
                        start = i;
                        maxLen = len;
                    }
                }
            }
        }
        
        return s.substring(start, start + maxLen);
    }
    
    // Manacher's Algorithm for linear time solution
    public static String longestPalindromicSubstringManacher(String s) {
        if (s == null || s.length() < 2) return s;
        
        // Transform string to handle even length palindromes
        String t = "^#" + String.join("#", s.split("")) + "#$";
        int n = t.length();
        int[] p = new int[n];
        int c = 0, r = 0;
        
        for (int i = 1; i < n - 1; i++) {
            if (r > i) {
                p[i] = Math.min(r - i, p[2 * c - i]);
            }
            
            // Attempt to expand palindrome centered at i
            while (t.charAt(i + 1 + p[i]) == t.charAt(i - 1 - p[i])) {
                p[i]++;
            }
            
            // If palindrome centered at i expands past r,
            // adjust center based on expanded palindrome
            if (i + p[i] > r) {
                c = i;
                r = i + p[i];
            }
        }
        
        // Find the maximum element in p
        int maxLen = 0;
        int centerIndex = 0;
        for (int i = 1; i < n - 1; i++) {
            if (p[i] > maxLen) {
                maxLen = p[i];
                centerIndex = i;
            }
        }
        
        return s.substring((centerIndex - maxLen) / 2, (centerIndex + maxLen) / 2);
    }
    
    public static void main(String[] args) {
        String[] testCases = {
            "babad",
            "cbbd",
            "a",
            "ac",
            "bananas",
            "aaaaaa"
        };
        
        for (String test : testCases) {
            System.out.println("\nOriginal string: " + test);
            System.out.println("Expand around center: " + 
                             longestPalindromicSubstring(test));
            System.out.println("Dynamic Programming: " + 
                             longestPalindromicSubstringDP(test));
            System.out.println("Manacher's Algorithm: " + 
                             longestPalindromicSubstringManacher(test));
        }
    }
}