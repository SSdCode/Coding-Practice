/**
 * Next Greater Element Problem in Kotlin
 * 
 * This program demonstrates how to find the next greater element for each element in an array.
 * For each element, the next greater element is the first greater element to its right.
 * If there is no greater element, the result is -1.
 * 
 * Two approaches are implemented:
 * 1. Using a stack and processing the array from right to left
 * 2. Using a stack and processing the array from left to right
 * 
 * Time Complexity: O(n) where n is the size of the array
 * Space Complexity: O(n) for the stack and result array
 */

package Kotlin

import java.util.Stack

/**
 * Find the next greater element for each element in the array
 * Processing the array from right to left
 * 
 * @param arr The input array
 * @return An array containing the next greater element for each element
 */
fun nextGreaterElement(arr: IntArray): IntArray {
    val n = arr.size
    val result = IntArray(n) { -1 } // Initialize with -1 (no greater element)
    val stack = Stack<Int>()
    
    // Process all elements from right to left
    for (i in n - 1 downTo 0) {
        // Remove elements from stack that are smaller than or equal to current element
        while (stack.isNotEmpty() && stack.peek() <= arr[i]) {
            stack.pop()
        }
        
        // If stack is not empty, the top element is the next greater element
        if (stack.isNotEmpty()) {
            result[i] = stack.peek()
        }
        
        // Push current element to stack
        stack.push(arr[i])
    }
    
    return result
}

/**
 * Find the next greater element for each element in the array
 * Processing the array from left to right
 * 
 * @param arr The input array
 * @return An array containing the next greater element for each element
 */
fun nextGreaterElementLeftToRight(arr: IntArray): IntArray {
    val n = arr.size
    val result = IntArray(n) { -1 } // Initialize with -1 (no greater element)
    val stack = Stack<Int>() // Stack to store indices, not values
    
    // Process all elements from left to right
    for (i in 0 until n) {
        // While stack is not empty and current element is greater than element at stack top
        while (stack.isNotEmpty() && arr[i] > arr[stack.peek()]) {
            // For the element at stack top, the next greater element is the current element
            val idx = stack.pop()
            result[idx] = arr[i]
        }
        
        // Push current index to stack
        stack.push(i)
    }
    
    // Elements remaining in stack have no next greater element
    // (result array is already initialized with -1)
    
    return result
}

/**
 * Print the array and its next greater elements
 * 
 * @param arr The original array
 * @param result The array containing next greater elements
 * @param approach The name of the approach used
 */
fun printNextGreaterElements(arr: IntArray, result: IntArray, approach: String) {
    println("$approach:")
    println("Element\tNext Greater")
    for (i in arr.indices) {
        println("${arr[i]}\t\t${result[i]}")
    }
    println()
}

/**
 * Main function to demonstrate the next greater element problem
 */
fun main() {
    println("Next Greater Element Problem in Kotlin")
    println("-------------------------------------")
    
    // Example 1: Basic array
    val arr1 = intArrayOf(4, 5, 2, 10, 8)
    println("\nExample 1: ${arr1.joinToString()}")
    
    val result1RightToLeft = nextGreaterElement(arr1)
    printNextGreaterElements(arr1, result1RightToLeft, "Right to Left Approach")
    
    val result1LeftToRight = nextGreaterElementLeftToRight(arr1)
    printNextGreaterElements(arr1, result1LeftToRight, "Left to Right Approach")
    
    // Example 2: Array with duplicates
    val arr2 = intArrayOf(4, 5, 5, 2, 25, 25)
    println("\nExample 2: ${arr2.joinToString()}")
    
    val result2RightToLeft = nextGreaterElement(arr2)
    printNextGreaterElements(arr2, result2RightToLeft, "Right to Left Approach")
    
    val result2LeftToRight = nextGreaterElementLeftToRight(arr2)
    printNextGreaterElements(arr2, result2LeftToRight, "Left to Right Approach")
    
    // Example 3: Array in descending order (no next greater element)
    val arr3 = intArrayOf(10, 8, 6, 4, 2)
    println("\nExample 3: ${arr3.joinToString()}")
    
    val result3RightToLeft = nextGreaterElement(arr3)
    printNextGreaterElements(arr3, result3RightToLeft, "Right to Left Approach")
    
    val result3LeftToRight = nextGreaterElementLeftToRight(arr3)
    printNextGreaterElements(arr3, result3LeftToRight, "Left to Right Approach")
    
    // Example 4: Array in ascending order
    val arr4 = intArrayOf(1, 3, 5, 7, 9)
    println("\nExample 4: ${arr4.joinToString()}")
    
    val result4RightToLeft = nextGreaterElement(arr4)
    printNextGreaterElements(arr4, result4RightToLeft, "Right to Left Approach")
    
    val result4LeftToRight = nextGreaterElementLeftToRight(arr4)
    printNextGreaterElements(arr4, result4LeftToRight, "Left to Right Approach")
    
    // Example 5: Array with a single element
    val arr5 = intArrayOf(5)
    println("\nExample 5: ${arr5.joinToString()}")
    
    val result5RightToLeft = nextGreaterElement(arr5)
    printNextGreaterElements(arr5, result5RightToLeft, "Right to Left Approach")
    
    val result5LeftToRight = nextGreaterElementLeftToRight(arr5)
    printNextGreaterElements(arr5, result5LeftToRight, "Left to Right Approach")
    
    // Performance comparison
    println("\nPerformance Comparison:")
    println("Both approaches have O(n) time complexity and O(n) space complexity.")
    println("The Left to Right approach is often more intuitive as it processes elements in order.")
    println("The Right to Left approach can be more efficient for certain patterns.")
    
    // Functional approach using Kotlin's features
    println("\nFunctional Approach:")
    val arr6 = intArrayOf(4, 5, 2, 10, 8)
    println("Original array: ${arr6.joinToString()}")
    
    // Using extension function for better readability
    fun IntArray.findNextGreaterElements(): List<Pair<Int, Int>> {
        val result = nextGreaterElementLeftToRight(this)
        return this.zip(result.toList())
    }
    
    val pairs = arr6.findNextGreaterElements()
    println("Element -> Next Greater:")
    pairs.forEach { (element, nextGreater) ->
        println("$element -> $nextGreater")
    }
    
    // Using higher-order functions
    println("\nElements with no next greater element:")
    pairs.filter { (_, nextGreater) -> nextGreater == -1 }
         .map { (element, _) -> element }
         .also { println(it) }
    
    println("\nElements with next greater element > 2x their value:")
    pairs.filter { (element, nextGreater) -> nextGreater > element * 2 }
         .map { (element, nextGreater) -> "$element -> $nextGreater" }
         .also { println(it) }
}