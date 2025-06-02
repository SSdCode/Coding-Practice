// Implementation of string reversal in Kotlin
fun reverseString(str: String): String {
    return str.reversed()
}

// Manual implementation
fun reverseStringManual(str: String): String {
    val chars = str.toCharArray()
    var left = 0
    var right = chars.size - 1
    
    while (left < right) {
        val temp = chars[left]
        chars[left] = chars[right]
        chars[right] = temp
        left++
        right--
    }
    
    return String(chars)
}

fun main() {
    val testStrings = listOf(
        "Hello, World!",
        "Programming",
        "Kotlin",
        "A man a plan a canal Panama"
    )
    
    for (str in testStrings) {
        println("\nOriginal string: $str")
        println("Using built-in reversed(): ${reverseString(str)}")
        println("Using manual implementation: ${reverseStringManual(str)}")
    }
}