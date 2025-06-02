// Count vowels and consonants in strings using Kotlin

// Traditional approach
fun countVowelsAndConsonants(str: String) {
    var vowels = 0
    var consonants = 0
    
    str.lowercase().forEach { ch ->
        if (ch.isLetter()) {
            if (ch in "aeiou") {
                vowels++
            } else {
                consonants++
            }
        }
    }
    
    println("Using traditional approach:")
    println("Vowels: $vowels")
    println("Consonants: $consonants")
}

// Using Kotlin collections and functional programming
fun countVowelsAndConsonantsFunction(str: String) {
    val counts = str.lowercase()
        .filter { it.isLetter() }
        .partition { it in "aeiou" }
    
    println("Using functional approach:")
    println("Vowels: ${counts.first.count()}")
    println("Consonants: ${counts.second.count()}")
}

fun main() {
    val testStrings = listOf(
        "Hello World",
        "OpenAI GPT",
        "Programming is fun",
        "Kotlin Programming"
    )
    
    testStrings.forEach { str ->
        println("\nString: $str")
        countVowelsAndConsonants(str)
        countVowelsAndConsonantsFunction(str)
    }
}