// Remove duplicates from strings using Kotlin

// Using LinkedHashSet to maintain order
fun removeDuplicates(str: String): String {
    return str.toList()
        .toLinkedHashSet()
        .joinToString("")
}

// Using sequence for better performance with large strings
fun removeDuplicatesSequence(str: String): String {
    return str.asSequence()
        .distinct()
        .joinToString("")
}

// Manual implementation
fun removeDuplicatesManual(str: String): String {
    if (str.length <= 1) return str
    
    val result = StringBuilder()
    str.forEach { char ->
        if (!result.contains(char)) {
            result.append(char)
        }
    }
    return result.toString()
}

fun main() {
    val testStrings = listOf(
        "programming",
        "hello world",
        "kotlin is fun",
        "aabbccdd"
    )
    
    testStrings.forEach { str ->
        println("\nOriginal string: $str")
        println("Using LinkedHashSet: ${removeDuplicates(str)}")
        println("Using Sequence: ${removeDuplicatesSequence(str)}")
        println("Using manual implementation: ${removeDuplicatesManual(str)}")
    }
}