/**
 * Valid Parentheses Problem in Kotlin
 * 
 * This program demonstrates how to check if a string of parentheses is valid.
 * A string is valid if:
 * 1. Open brackets must be closed by the same type of brackets.
 * 2. Open brackets must be closed in the correct order.
 * 3. Every close bracket has a corresponding open bracket of the same type.
 * 
 * Time Complexity: O(n) where n is the length of the string
 * Space Complexity: O(n) in the worst case when all characters are opening brackets
 */

package Kotlin

import java.util.Stack

/**
 * Check if a string of parentheses is valid using a map for matching brackets
 * 
 * @param s The input string containing parentheses
 * @return true if the string is valid, false otherwise
 */
fun isValid(s: String): Boolean {
    // If the string is empty, it's valid
    if (s.isEmpty()) {
        return true
    }
    
    // If the string has odd length, it can't be valid
    if (s.length % 2 != 0) {
        return false
    }
    
    // Map to store matching brackets
    val brackets = mapOf(
        ')' to '(',
        '}' to '{',
        ']' to '['
    )
    
    // Stack to keep track of opening brackets
    val stack = Stack<Char>()
    
    // Iterate through each character in the string
    for (char in s) {
        // If it's a closing bracket
        if (char in brackets.keys) {
            // Check if stack is empty or the top doesn't match
            if (stack.isEmpty() || stack.pop() != brackets[char]) {
                return false
            }
        } else {
            // It's an opening bracket, push to stack
            stack.push(char)
        }
    }
    
    // If stack is empty, all brackets were matched
    return stack.isEmpty()
}

/**
 * Check if a string of parentheses is valid using a switch statement approach
 * 
 * @param s The input string containing parentheses
 * @return true if the string is valid, false otherwise
 */
fun isValidSwitch(s: String): Boolean {
    // If the string is empty, it's valid
    if (s.isEmpty()) {
        return true
    }
    
    // If the string has odd length, it can't be valid
    if (s.length % 2 != 0) {
        return false
    }
    
    // Stack to keep track of opening brackets
    val stack = Stack<Char>()
    
    // Iterate through each character in the string
    for (char in s) {
        when (char) {
            '(', '{', '[' -> stack.push(char)
            ')' -> if (stack.isEmpty() || stack.pop() != '(') return false
            '}' -> if (stack.isEmpty() || stack.pop() != '{') return false
            ']' -> if (stack.isEmpty() || stack.pop() != '[') return false
            else -> return false // Invalid character
        }
    }
    
    // If stack is empty, all brackets were matched
    return stack.isEmpty()
}

/**
 * Print the result of the validation
 * 
 * @param s The input string
 * @param result The validation result
 */
fun printResult(s: String, result: Boolean) {
    println("Input: \"$s\"")
    println("Is valid: $result")
}

/**
 * Generate a long valid string for benchmarking
 * 
 * @param length The desired length of the string
 * @return A valid string of parentheses
 */
fun generateLongValidString(length: Int): String {
    require(length % 2 == 0) { "Length must be even" }
    
    val sb = StringBuilder()
    for (i in 0 until length / 2) {
        sb.append('(')
    }
    for (i in 0 until length / 2) {
        sb.append(')')
    }
    return sb.toString()
}

/**
 * Main function to demonstrate the valid parentheses problem
 */
fun main() {
    println("Valid Parentheses Problem in Kotlin")
    println("----------------------------------")
    
    // Test cases
    val testCases = listOf(
        "()",              // Valid: simple case
        "()[]{}",          // Valid: different types
        "([]){}",          // Valid: nested and adjacent
        "",                // Valid: empty string
        "([",              // Invalid: incomplete
        "([)]",            // Invalid: wrong order
        "(())",            // Valid: nested same type
        "((()()))",        // Valid: complex nesting
        "({}[])",          // Valid: nested different types
        "({[]})",          // Valid: complex nesting different types
        "({",              // Invalid: incomplete
        ")}]",             // Invalid: no opening brackets
        "(((",             // Invalid: only opening brackets
        "((()))",          // Valid: multiple nesting
        "(()())()",        // Valid: multiple groups
        "([)]"             // Invalid: interleaved brackets
    )
    
    // Test using the map approach
    println("\nTesting with Map Approach:")
    for (test in testCases) {
        val result = isValid(test)
        printResult(test, result)
    }
    
    // Test using the switch approach
    println("\nTesting with Switch Approach:")
    for (test in testCases) {
        val result = isValidSwitch(test)
        printResult(test, result)
    }
    
    // Performance comparison
    println("\nPerformance Comparison:")
    val longString = generateLongValidString(100000)
    
    println("Testing with a long valid string of length ${longString.length}")
    
    // Benchmark map approach
    val mapStartTime = System.nanoTime()
    val mapResult = isValid(longString)
    val mapEndTime = System.nanoTime()
    val mapDuration = (mapEndTime - mapStartTime) / 1_000_000.0 // Convert to milliseconds
    
    // Benchmark switch approach
    val switchStartTime = System.nanoTime()
    val switchResult = isValidSwitch(longString)
    val switchEndTime = System.nanoTime()
    val switchDuration = (switchEndTime - switchStartTime) / 1_000_000.0 // Convert to milliseconds
    
    println("Map approach result: $mapResult, Time: $mapDuration ms")
    println("Switch approach result: $switchResult, Time: $switchDuration ms")
    
    if (switchDuration < mapDuration) {
        println("The Switch approach is faster by ${mapDuration - switchDuration} ms")
    } else {
        println("The Map approach is faster by ${switchDuration - mapDuration} ms")
    }
    
    // Functional approach using Kotlin's features
    println("\nFunctional Approach:")
    
    // Extension function for String to check if it has valid parentheses
    fun String.hasValidParentheses(): Boolean = isValid(this)
    
    // Test the extension function
    val validString = "({[]})"  
    val invalidString = "([)]"  
    
    println("\"$validString\" has valid parentheses: ${validString.hasValidParentheses()}")
    println("\"$invalidString\" has valid parentheses: ${invalidString.hasValidParentheses()}")
    
    // Using higher-order functions
    println("\nFiltering valid strings:")
    val validStrings = testCases.filter { it.hasValidParentheses() }
    println("Valid strings: $validStrings")
    
    println("\nGrouping by validity:")
    val groupedByValidity = testCases.groupBy { it.hasValidParentheses() }
    
    println("Valid strings (${groupedByValidity[true]?.size ?: 0}):")
    groupedByValidity[true]?.forEach { println("\"$it\"")}  
    
    println("\nInvalid strings (${groupedByValidity[false]?.size ?: 0}):")
    groupedByValidity[false]?.forEach { println("\"$it\"")}  
}