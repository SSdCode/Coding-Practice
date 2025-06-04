/**
 * Implement Stack using Array in Kotlin
 * 
 * This program demonstrates how to implement a stack data structure using an array in Kotlin.
 * The implementation includes standard stack operations like push, pop, peek, isEmpty, isFull, etc.
 * 
 * Time Complexity:
 * - Push: O(1)
 * - Pop: O(1)
 * - Peek: O(1)
 * - isEmpty: O(1)
 * - isFull: O(1)
 * 
 * Space Complexity: O(n) where n is the maximum size of the stack
 */

package Kotlin

import java.util.EmptyStackException

/**
 * Generic Stack class implemented using an array
 */
class StackUsingArray<T>(private val capacity: Int = 10) {
    private val array: Array<Any?> = arrayOfNulls(capacity)
    private var top: Int = -1 // Stack is initially empty
    
    /**
     * Push an element onto the stack
     * 
     * @param item The element to push
     * @throws IllegalStateException if the stack is full
     */
    fun push(item: T) {
        if (isFull()) {
            throw IllegalStateException("Stack Overflow: Cannot push to a full stack")
        }
        array[++top] = item
    }
    
    /**
     * Pop the top element from the stack
     * 
     * @return The popped element
     * @throws EmptyStackException if the stack is empty
     */
    @Suppress("UNCHECKED_CAST")
    fun pop(): T {
        if (isEmpty()) {
            throw EmptyStackException()
        }
        val item = array[top] as T
        array[top--] = null // Help garbage collection
        return item
    }
    
    /**
     * Peek at the top element without removing it
     * 
     * @return The top element
     * @throws EmptyStackException if the stack is empty
     */
    @Suppress("UNCHECKED_CAST")
    fun peek(): T {
        if (isEmpty()) {
            throw EmptyStackException()
        }
        return array[top] as T
    }
    
    /**
     * Check if the stack is empty
     * 
     * @return true if the stack is empty, false otherwise
     */
    fun isEmpty(): Boolean = top == -1
    
    /**
     * Check if the stack is full
     * 
     * @return true if the stack is full, false otherwise
     */
    fun isFull(): Boolean = top == capacity - 1
    
    /**
     * Get the current size of the stack
     * 
     * @return The number of elements in the stack
     */
    fun size(): Int = top + 1
    
    /**
     * Print the contents of the stack
     */
    fun print() {
        if (isEmpty()) {
            println("Stack is empty")
            return
        }
        
        print("Stack contents (bottom to top): ")
        for (i in 0..top) {
            print("${array[i]} ")
        }
        println()
    }
    
    /**
     * Clear the stack
     */
    fun clear() {
        for (i in 0..top) {
            array[i] = null // Help garbage collection
        }
        top = -1
    }
}

/**
 * Extension function to create a stack from a collection
 */
fun <T> Collection<T>.toStack(capacity: Int = this.size): StackUsingArray<T> {
    val stack = StackUsingArray<T>(capacity)
    this.forEach { stack.push(it) }
    return stack
}

/**
 * Main function to demonstrate the stack operations
 */
fun main() {
    println("Stack Implementation using Array in Kotlin")
    println("----------------------------------------")
    
    // Create a stack of integers with capacity 5
    val stack = StackUsingArray<Int>(5)
    
    try {
        // Test push operation
        println("\n1. Pushing elements to the stack:")
        stack.push(10)
        stack.push(20)
        stack.push(30)
        stack.push(40)
        stack.print()
        
        // Test peek operation
        println("\n2. Peek operation:")
        println("Top element: ${stack.peek()}")
        
        // Test pop operation
        println("\n3. Pop operation:")
        println("Popped element: ${stack.pop()}")
        stack.print()
        
        // Test size operation
        println("\n4. Stack size:")
        println("Current size: ${stack.size()}")
        
        // Test isEmpty operation
        println("\n5. Is stack empty?")
        println("Is empty: ${stack.isEmpty()}")
        
        // Test isFull operation
        println("\n6. Is stack full?")
        println("Is full: ${stack.isFull()}")
        
        // Test stack overflow
        println("\n7. Testing stack overflow:")
        stack.push(50)
        stack.push(60)  // This should cause an overflow
        stack.print()
    } catch (e: Exception) {
        println("Exception: ${e.message}")
    }
    
    // Create a new stack to test underflow
    println("\n8. Testing stack underflow:")
    val emptyStack = StackUsingArray<Int>(3)
    try {
        emptyStack.pop()  // This should cause an underflow
    } catch (e: Exception) {
        println("Exception: $e")
    }
    
    // Test with a different data type
    println("\n9. Testing stack with strings:")
    val stringStack = StackUsingArray<String>(3)
    try {
        stringStack.push("Hello")
        stringStack.push("World")
        stringStack.push("Kotlin")
        stringStack.print()
        
        println("Popped element: ${stringStack.pop()}")
        stringStack.print()
    } catch (e: Exception) {
        println("Exception: ${e.message}")
    }
    
    // Test clear operation
    println("\n10. Testing clear operation:")
    stringStack.clear()
    println("After clearing the stack:")
    stringStack.print()
    println("Is empty: ${stringStack.isEmpty()}")
    
    // Test the extension function
    println("\n11. Testing extension function:")
    val list = listOf(1, 2, 3, 4, 5)
    val stackFromList = list.toStack()
    println("Stack created from list:")
    stackFromList.print()
    
    // Demonstrate Kotlin's functional approach
    println("\n12. Demonstrating Kotlin's functional approach:")
    val numbers = (1..5).toList()
    val stackFromNumbers = numbers.toStack()
    println("Stack created from numbers 1 to 5:")
    stackFromNumbers.print()
    
    // Pop all elements and collect them
    val poppedElements = mutableListOf<Int>()
    while (!stackFromNumbers.isEmpty()) {
        poppedElements.add(stackFromNumbers.pop())
    }
    println("Popped elements (in reverse order): $poppedElements")
}