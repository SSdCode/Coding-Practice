// Palindrome string check implementations in Kotlin

// Using standard approach
fun isPalindrome(str: String): Boolean {
    // Remove non-alphanumeric characters and convert to lowercase
    val cleanStr = str.replace(Regex("[^A-Za-z0-9]"), "").lowercase()
    
    var left = 0
    var right = cleanStr.length - 1
    
    while (left < right) {
        if (cleanStr[left] != cleanStr[right]) {
            return false
        }
        left++
        right--
    }
    return true
}

// Using Kotlin's built-in functions
fun isPalindromeUsingBuiltin(str: String): Boolean {
    val cleanStr = str.replace(Regex("[^A-Za-z0-9]"), "").lowercase()
    return cleanStr == cleanStr.reversed()
}

fun main() {
    val testStrings = listOf(
        "A man, a plan, a canal: Panama",
        "race a car",
        "Was it a car or a cat I saw?",
        "hello",
        "Kotlin"
    )
    
    testStrings.forEach { str ->
        println("\nString: $str")
        println("Is Palindrome (iterative): ${isPalindrome(str)}")
        println("Is Palindrome (using built-in): ${isPalindromeUsingBuiltin(str)}")
    }
}