// Longest Common Prefix implementations in Kotlin

// Using horizontal scanning
fun longestCommonPrefix(strs: Array<String>): String {
    if (strs.isEmpty()) return ""
    
    var prefix = strs[0]
    for (i in 1 until strs.size) {
        while (strs[i].indexOf(prefix) != 0) {
            prefix = prefix.substring(0, prefix.length - 1)
            if (prefix.isEmpty()) return ""
        }
    }
    return prefix
}

// Using vertical scanning
fun longestCommonPrefixVertical(strs: Array<String>): String {
    if (strs.isEmpty()) return ""
    
    for (i in strs[0].indices) {
        val char = strs[0][i]
        for (j in 1 until strs.size) {
            if (i >= strs[j].length || strs[j][i] != char) {
                return strs[0].substring(0, i)
            }
        }
    }
    return strs[0]
}

// Using Kotlin's functional approach with reduce
fun longestCommonPrefixFunctional(strs: Array<String>): String {
    if (strs.isEmpty()) return ""
    
    return strs.reduce { acc, str ->
        acc.commonPrefixWith(str)
    }
}

fun main() {
    val testCases = arrayOf(
        arrayOf("flower", "flow", "flight"),
        arrayOf("dog", "racecar", "car"),
        arrayOf("interspecies", "interstellar", "interstate"),
        arrayOf("throne", "throne"),
        arrayOf()
    )
    
    testCases.forEach { testCase ->
        println("\nTest case: ${testCase.contentToString()}")
        println("Horizontal scanning: ${longestCommonPrefix(testCase)}")
        println("Vertical scanning: ${longestCommonPrefixVertical(testCase)}")
        println("Functional approach: ${longestCommonPrefixFunctional(testCase)}")
    }
}