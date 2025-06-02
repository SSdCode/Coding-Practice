// Longest Palindromic Substring implementations in Kotlin

// Expand around center approach
fun longestPalindromicSubstring(s: String): String {
    if (s.length < 2) return s
    
    var start = 0
    var maxLen = 1
    
    fun expandAroundCenter(left: Int, right: Int) {
        var l = left
        var r = right
        while (l >= 0 && r < s.length && s[l] == s[r]) {
            val len = r - l + 1
            if (len > maxLen) {
                start = l
                maxLen = len
            }
            l--
            r++
        }
    }
    
    for (i in s.indices) {
        expandAroundCenter(i, i) // Odd length palindromes
        expandAroundCenter(i, i + 1) // Even length palindromes
    }
    
    return s.substring(start, start + maxLen)
}

// Dynamic Programming approach
fun longestPalindromicSubstringDP(s: String): String {
    if (s.length < 2) return s
    
    val n = s.length
    val dp = Array(n) { BooleanArray(n) }
    var start = 0
    var maxLen = 1
    
    // All substrings of length 1 are palindromes
    for (i in s.indices) {
        dp[i][i] = true
    }
    
    // Check for substrings of length 2
    for (i in 0 until n - 1) {
        if (s[i] == s[i + 1]) {
            dp[i][i + 1] = true
            start = i
            maxLen = 2
        }
    }
    
    // Check for lengths greater than 2
    for (len in 3..n) {
        for (i in 0..n - len) {
            val j = i + len - 1
            if (s[i] == s[j] && dp[i + 1][j - 1]) {
                dp[i][j] = true
                if (len > maxLen) {
                    start = i
                    maxLen = len
                }
            }
        }
    }
    
    return s.substring(start, start + maxLen)
}

// Manacher's Algorithm
fun longestPalindromicSubstringManacher(s: String): String {
    if (s.length < 2) return s
    
    // Transform string to handle even length palindromes
    val t = StringBuilder("^")
    for (c in s) {
        t.append("#").append(c)
    }
    t.append("#$")
    
    val n = t.length
    val p = IntArray(n)
    var center = 0
    var right = 0
    
    for (i in 1 until n - 1) {
        if (right > i) {
            p[i] = minOf(right - i, p[2 * center - i])
        }
        
        // Attempt to expand palindrome centered at i
        while (t[i + 1 + p[i]] == t[i - 1 - p[i]]) {
            p[i]++
        }
        
        // If palindrome centered at i expands past right,
        // adjust center based on expanded palindrome
        if (i + p[i] > right) {
            center = i
            right = i + p[i]
        }
    }
    
    // Find the maximum element in p
    var maxLen = 0
    var centerIndex = 0
    for (i in 1 until n - 1) {
        if (p[i] > maxLen) {
            maxLen = p[i]
            centerIndex = i
        }
    }
    
    return s.substring((centerIndex - maxLen) / 2, (centerIndex + maxLen) / 2)
}

fun main() {
    val testCases = listOf(
        "babad",
        "cbbd",
        "a",
        "ac",
        "bananas",
        "aaaaaa"
    )
    
    testCases.forEach { test ->
        println("\nOriginal string: $test")
        println("Expand around center: ${longestPalindromicSubstring(test)}")
        println("Dynamic Programming: ${longestPalindromicSubstringDP(test)}")
        println("Manacher's Algorithm: ${longestPalindromicSubstringManacher(test)}")
    }
}