/**
 * Implement Stack using Linked List in Kotlin
 * 
 * This program demonstrates how to implement a stack data structure using a linked list in Kotlin.
 * The implementation includes standard stack operations like push, pop, peek, isEmpty, etc.
 * 
 * Time Complexity:
 * - Push: O(1)
 * - Pop: O(1)
 * - Peek: O(1)
 * - isEmpty: O(1)
 * 
 * Space Complexity: O(n) where n is the number of elements in the stack
 */

package Kotlin

import java.util.EmptyStackException

/**
 * Generic Stack class implemented using a linked list
 */
class StackUsingLinkedList<T> {
    // Node class for the linked list
    private class Node<T>(val data: T, var next: Node<T>? = null)
    
    private var top: Node<T>? = null  // Reference to the top node
    private var size: Int = 0         // Number of elements in the stack
    
    /**
     * Push an element onto the stack
     * 
     * @param item The element to push
     */
    fun push(item: T) {
        // Create a new node and link it to the current top
        val newNode = Node(item, top)
        
        // Update the top pointer
        top = newNode
        
        // Increment the size
        size++
    }
    
    /**
     * Pop the top element from the stack
     * 
     * @return The popped element
     * @throws EmptyStackException if the stack is empty
     */
    fun pop(): T {
        if (isEmpty()) {
            throw EmptyStackException()
        }
        
        // Save the top node and its data
        val poppedItem = top!!.data
        
        // Update the top pointer
        top = top!!.next
        
        // Decrement the size
        size--
        
        return poppedItem
    }
    
    /**
     * Peek at the top element without removing it
     * 
     * @return The top element
     * @throws EmptyStackException if the stack is empty
     */
    fun peek(): T {
        if (isEmpty()) {
            throw EmptyStackException()
        }
        
        return top!!.data
    }
    
    /**
     * Check if the stack is empty
     * 
     * @return true if the stack is empty, false otherwise
     */
    fun isEmpty(): Boolean = top == null
    
    /**
     * Get the current size of the stack
     * 
     * @return The number of elements in the stack
     */
    fun size(): Int = size
    
    /**
     * Print the contents of the stack
     */
    fun print() {
        if (isEmpty()) {
            println("Stack is empty")
            return
        }
        
        print("Stack contents (top to bottom): ")
        
        // Create a temporary pointer to traverse the list
        var current = top
        
        while (current != null) {
            print("${current.data} ")
            current = current.next
        }
        
        println()
    }
    
    /**
     * Clear the stack
     */
    fun clear() {
        top = null
        size = 0
    }
    
    /**
     * Search for an element in the stack
     * 
     * @param item The element to search for
     * @return The 1-based position of the element from the top, or -1 if not found
     */
    fun search(item: T): Int {
        if (isEmpty()) {
            return -1
        }
        
        var current = top
        var position = 1
        
        while (current != null) {
            if (current.data == item) {
                return position
            }
            current = current.next
            position++
        }
        
        return -1 // Element not found
    }
    
    /**
     * Convert the stack to a list
     * 
     * @return A list containing all elements in the stack (top to bottom)
     */
    fun toList(): List<T> {
        val result = mutableListOf<T>()
        var current = top
        
        while (current != null) {
            result.add(current.data)
            current = current.next
        }
        
        return result
    }
}

/**
 * Extension function to create a stack from a collection
 */
fun <T> Collection<T>.toLinkedStack(): StackUsingLinkedList<T> {
    val stack = StackUsingLinkedList<T>()
    // Push in reverse order to maintain the original order from bottom to top
    this.reversed().forEach { stack.push(it) }
    return stack
}

/**
 * Main function to demonstrate the stack operations
 */
fun main() {
    println("Stack Implementation using Linked List in Kotlin")
    println("--------------------------------------------")
    
    // Create a stack of integers
    val stack = StackUsingLinkedList<Int>()
    
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
        
        // Test search operation
        println("\n6. Search operation:")
        println("Position of 20: ${stack.search(20)}")
        println("Position of 50: ${stack.search(50)}")
        
        // Test toList operation
        println("\n7. Convert to list:")
        val list = stack.toList()
        println("Stack as list: $list")
        
        // Pop all elements
        println("\n8. Popping all elements:")
        while (!stack.isEmpty()) {
            println("Popped: ${stack.pop()}")
        }
        
        // Check if stack is empty after popping all elements
        println("\n9. Is stack empty after popping all elements?")
        println("Is empty: ${stack.isEmpty()}")
    } catch (e: Exception) {
        println("Exception: $e")
    }
    
    // Test stack underflow
    println("\n10. Testing stack underflow:")
    val emptyStack = StackUsingLinkedList<Int>()
    try {
        emptyStack.pop()  // This should cause an underflow
    } catch (e: Exception) {
        println("Exception: $e")
    }
    
    // Test with a different data type
    println("\n11. Testing stack with strings:")
    val stringStack = StackUsingLinkedList<String>()
    try {
        stringStack.push("Hello")
        stringStack.push("World")
        stringStack.push("Kotlin")
        stringStack.print()
        
        println("Popped element: ${stringStack.pop()}")
        stringStack.print()
        
        // Test clear operation
        println("\n12. Testing clear operation:")
        stringStack.clear()
        println("After clearing the stack:")
        stringStack.print()
        println("Is empty: ${stringStack.isEmpty()}")
    } catch (e: Exception) {
        println("Exception: $e")
    }
    
    // Test the extension function
    println("\n13. Testing extension function:")
    val collection = listOf("A", "B", "C", "D", "E")
    val stackFromCollection = collection.toLinkedStack()
    println("Stack created from collection:")
    stackFromCollection.print()
    
    // Demonstrate Kotlin's functional approach
    println("\n14. Demonstrating Kotlin's functional approach:")
    val numbers = (1..5).toList()
    val stackFromNumbers = numbers.toLinkedStack()
    println("Stack created from numbers 1 to 5:")
    stackFromNumbers.print()
    
    // Use functional operations on the stack elements
    println("\n15. Using functional operations:")
    val stackElements = stackFromNumbers.toList()
    val sum = stackElements.sum()
    val doubled = stackElements.map { it * 2 }
    val filtered = stackElements.filter { it % 2 == 0 }
    
    println("Stack elements: $stackElements")
    println("Sum of elements: $sum")
    println("Doubled elements: $doubled")
    println("Even elements: $filtered")
}