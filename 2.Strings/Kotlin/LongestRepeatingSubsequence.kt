// Longest Repeating Subsequence implementations in Kotlin

// Dynamic Programming approach to find length
fun findLRSLength(str: String): Int {
    val n = str.length
    val dp = Array(n + 1) { IntArray(n + 1) }
    
    // Fill the dp table
    for (i in 1..n) {
        for (j in 1..n) {
            if (str[i - 1] == str[j - 1] && i != j) {
                dp[i][j] = dp[i - 1][j - 1] + 1
            } else {
                dp[i][j] = maxOf(dp[i][j - 1], dp[i - 1][j])
            }
        }
    }
    
    return dp[n][n]
}

// Function to find and print the subsequence
fun findLRS(str: String): String {
    val n = str.length
    val dp = Array(n + 1) { IntArray(n + 1) }
    
    // Fill the dp table
    for (i in 1..n) {
        for (j in 1..n) {
            if (str[i - 1] == str[j - 1] && i != j) {
                dp[i][j] = dp[i - 1][j - 1] + 1
            } else {
                dp[i][j] = maxOf(dp[i][j - 1], dp[i - 1][j])
            }
        }
    }
    
    // Backtrack to find the subsequence
    val result = StringBuilder()
    var i = n
    var j = n
    
    while (i > 0 && j > 0) {
        if (str[i - 1] == str[j - 1] && i != j) {
            result.insert(0, str[i - 1])
            i--
            j--
        } else if (dp[i - 1][j] > dp[i][j - 1]) {
            i--
        } else {
            j--
        }
    }
    
    return result.toString()
}

// Extension function to handle nullable results
fun String.findLongestRepeatingSubsequence(): Pair<Int, String> {
    val length = findLRSLength(this)
    val subsequence = findLRS(this)
    return Pair(length, subsequence)
}

fun main() {
    val testCases = listOf(
        "AABEBCDD",
        "AAAAAA",
        "ABCDEF",
        "AAAA",
        "ABCABC"
    )
    
    testCases.forEach { test ->
        println("\nString: $test")
        val (length, subsequence) = test.findLongestRepeatingSubsequence()
        println("Length of longest repeating subsequence: $length")
        if (subsequence.isNotEmpty()) {
            println("One possible longest repeating subsequence: $subsequence")
        } else {
            println("No repeating subsequence found")
        }
    }
}