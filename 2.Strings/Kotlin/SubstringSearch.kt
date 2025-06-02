// Substring search implementations in Kotlin

// Manual implementation of strstr
fun strStr(haystack: String, needle: String): Int {
    if (needle.isEmpty()) return 0
    if (needle.length > haystack.length) return -1
    
    for (i in 0..haystack.length - needle.length) {
        var j = 0
        while (j < needle.length && haystack[i + j] == needle[j]) {
            j++
        }
        if (j == needle.length) {
            return i
        }
    }
    return -1
}

// Using KMP (Knuth-Morris-Pratt) Algorithm
fun strStrKMP(haystack: String, needle: String): Int {
    if (needle.isEmpty()) return 0
    if (needle.length > haystack.length) return -1
    
    // Build pattern table
    val pattern = IntArray(needle.length)
    var i = 1
    var j = 0
    
    while (i < needle.length) {
        if (needle[i] == needle[j]) {
            pattern[i] = j + 1
            i++
            j++
        } else if (j > 0) {
            j = pattern[j - 1]
        } else {
            pattern[i] = 0
            i++
        }
    }
    
    // Search
    i = 0
    j = 0
    while (i < haystack.length) {
        if (haystack[i] == needle[j]) {
            if (j == needle.length - 1) {
                return i - j
            }
            i++
            j++
        } else if (j > 0) {
            j = pattern[j - 1]
        } else {
            i++
        }
    }
    
    return -1
}

// Using Kotlin's built-in functions
fun strStrBuiltin(haystack: String, needle: String): Int {
    return haystack.indexOf(needle)
}

fun main() {
    val testCases = listOf(
        "hello world" to "world",
        "aaaaa" to "bba",
        "mississippi" to "issip",
        "" to "",
        "abc" to "c"
    )
    
    testCases.forEach { (haystack, needle) ->
        println("\nHaystack: \"$haystack\"")
        println("Needle: \"$needle\"")
        println("Basic implementation: ${strStr(haystack, needle)}")
        println("KMP implementation: ${strStrKMP(haystack, needle)}")
        println("Built-in method: ${strStrBuiltin(haystack, needle)}")
    }
}