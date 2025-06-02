// Anagram check implementations in Kotlin

// Using sorting approach
fun areAnagrams(str1: String, str2: String): Boolean {
    val s1 = str1.replace(Regex("[^A-Za-z0-9]"), "").lowercase()
    val s2 = str2.replace(Regex("[^A-Za-z0-9]"), "").lowercase()
    
    if (s1.length != s2.length) return false
    
    return s1.toCharArray().sorted() == s2.toCharArray().sorted()
}

// Using frequency map approach
fun areAnagramsUsingMap(str1: String, str2: String): Boolean {
    val s1 = str1.replace(Regex("[^A-Za-z0-9]"), "").lowercase()
    val s2 = str2.replace(Regex("[^A-Za-z0-9]"), "").lowercase()
    
    if (s1.length != s2.length) return false
    
    val charCount = mutableMapOf<Char, Int>()
    
    // Count characters in first string
    s1.forEach { char ->
        charCount[char] = charCount.getOrDefault(char, 0) + 1
    }
    
    // Decrement count for second string
    s2.forEach { char ->
        charCount[char] = charCount.getOrDefault(char, 0) - 1
        if (charCount[char] == 0) charCount.remove(char)
    }
    
    return charCount.isEmpty()
}

// Using functional programming approach
fun areAnagramsFunctional(str1: String, str2: String): Boolean {
    val s1 = str1.replace(Regex("[^A-Za-z0-9]"), "").lowercase()
    val s2 = str2.replace(Regex("[^A-Za-z0-9]"), "").lowercase()
    
    return s1.length == s2.length && 
           s1.groupBy { it }.mapValues { it.value.size } ==
           s2.groupBy { it }.mapValues { it.value.size }
}

fun main() {
    val testPairs = listOf(
        Pair("Listen", "Silent"),
        Pair("Triangle", "Integral"),
        Pair("Hello", "World"),
        Pair("A gentleman", "Elegant man"),
        Pair("Debit card", "Bad credit")
    )
    
    testPairs.forEach { (str1, str2) ->
        println("\nChecking strings: \"$str1\" and \"$str2\"")
        println("Using sorting approach: ${areAnagrams(str1, str2)}")
        println("Using map approach: ${areAnagramsUsingMap(str1, str2)}")
        println("Using functional approach: ${areAnagramsFunctional(str1, str2)}")
    }
}