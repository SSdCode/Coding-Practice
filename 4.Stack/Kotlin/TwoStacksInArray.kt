/**
 * Implement Two Stacks in an Array in Kotlin
 * 
 * This program demonstrates how to implement two stacks using a single array.
 * The first stack grows from the beginning of the array (left to right),
 * and the second stack grows from the end of the array (right to left).
 * 
 * Time Complexity:
 * - Push: O(1)
 * - Pop: O(1)
 * - Peek: O(1)
 * - isEmpty: O(1)
 * - isFull: O(1)
 * 
 * Space Complexity: O(n) where n is the size of the array
 */

package Kotlin

import java.util.EmptyStackException

/**
 * Generic class to implement two stacks in a single array
 */
class TwoStacksInArray<T>(private val capacity: Int = 10) {
    // Array to store elements of both stacks
    private val array: Array<Any?> = arrayOfNulls(capacity)
    
    // Top index for the first stack (grows from left to right)
    private var top1: Int = -1
    
    // Top index for the second stack (grows from right to left)
    private var top2: Int = capacity
    
    /**
     * Push an element onto the first stack
     * 
     * @param item The element to push
     * @throws IllegalStateException if the stack is full
     */
    fun push1(item: T) {
        if (isFull()) {
            throw IllegalStateException("Stack Overflow: Both stacks are full")
        }
        
        array[++top1] = item
    }
    
    /**
     * Push an element onto the second stack
     * 
     * @param item The element to push
     * @throws IllegalStateException if the stack is full
     */
    fun push2(item: T) {
        if (isFull()) {
            throw IllegalStateException("Stack Overflow: Both stacks are full")
        }
        
        array[--top2] = item
    }
    
    /**
     * Pop an element from the first stack
     * 
     * @return The popped element
     * @throws EmptyStackException if the stack is empty
     */
    @Suppress("UNCHECKED_CAST")
    fun pop1(): T {
        if (isEmpty1()) {
            throw EmptyStackException()
        }
        
        val item = array[top1] as T
        array[top1--] = null  // Clear the reference
        return item
    }
    
    /**
     * Pop an element from the second stack
     * 
     * @return The popped element
     * @throws EmptyStackException if the stack is empty
     */
    @Suppress("UNCHECKED_CAST")
    fun pop2(): T {
        if (isEmpty2()) {
            throw EmptyStackException()
        }
        
        val item = array[top2] as T
        array[top2++] = null  // Clear the reference
        return item
    }
    
    /**
     * Peek at the top element of the first stack without removing it
     * 
     * @return The top element
     * @throws EmptyStackException if the stack is empty
     */
    @Suppress("UNCHECKED_CAST")
    fun peek1(): T {
        if (isEmpty1()) {
            throw EmptyStackException()
        }
        
        return array[top1] as T
    }
    
    /**
     * Peek at the top element of the second stack without removing it
     * 
     * @return The top element
     * @throws EmptyStackException if the stack is empty
     */
    @Suppress("UNCHECKED_CAST")
    fun peek2(): T {
        if (isEmpty2()) {
            throw EmptyStackException()
        }
        
        return array[top2] as T
    }
    
    /**
     * Check if the first stack is empty
     * 
     * @return true if the first stack is empty, false otherwise
     */
    fun isEmpty1(): Boolean = top1 == -1
    
    /**
     * Check if the second stack is empty
     * 
     * @return true if the second stack is empty, false otherwise
     */
    fun isEmpty2(): Boolean = top2 == capacity
    
    /**
     * Check if both stacks are full
     * 
     * @return true if both stacks are full, false otherwise
     */
    fun isFull(): Boolean = top1 + 1 == top2
    
    /**
     * Get the size of the first stack
     * 
     * @return The number of elements in the first stack
     */
    fun size1(): Int = top1 + 1
    
    /**
     * Get the size of the second stack
     * 
     * @return The number of elements in the second stack
     */
    fun size2(): Int = capacity - top2
    
    /**
     * Get the total capacity of the array
     * 
     * @return The total capacity of the array
     */
    fun totalCapacity(): Int = capacity
    
    /**
     * Get the remaining capacity of the array
     * 
     * @return The number of empty slots in the array
     */
    fun remainingCapacity(): Int = top2 - top1 - 1
    
    /**
     * Print the contents of the first stack
     */
    fun print1() {
        if (isEmpty1()) {
            println("Stack 1 is empty")
            return
        }
        
        print("Stack 1 contents (top to bottom): ")
        for (i in top1 downTo 0) {
            print("${array[i]} ")
        }
        println()
    }
    
    /**
     * Print the contents of the second stack
     */
    fun print2() {
        if (isEmpty2()) {
            println("Stack 2 is empty")
            return
        }
        
        print("Stack 2 contents (top to bottom): ")
        for (i in top2 until capacity) {
            print("${array[i]} ")
        }
        println()
    }
    
    /**
     * Print the contents of both stacks and the array
     */
    fun printBothStacks() {
        println("Array representation: [${array.joinToString()}]")
        println("Stack 1 top: $top1, Stack 2 top: $top2")
        print1()
        print2()
    }
    
    /**
     * Clear both stacks
     */
    fun clear() {
        for (i in array.indices) {
            array[i] = null
        }
        top1 = -1
        top2 = capacity
    }
}

/**
 * Main function to demonstrate the two stacks in an array
 */
fun main() {
    println("Two Stacks in an Array Implementation in Kotlin")
    println("--------------------------------------------")
    
    // Create two stacks in an array with capacity 10
    val twoStacks = TwoStacksInArray<Int>(10)
    
    try {
        // Test push operation for both stacks
        println("\n1. Pushing elements to both stacks:")
        println("Pushing to Stack 1: 10, 20, 30")
        twoStacks.push1(10)
        twoStacks.push1(20)
        twoStacks.push1(30)
        
        println("Pushing to Stack 2: 100, 200, 300")
        twoStacks.push2(100)
        twoStacks.push2(200)
        twoStacks.push2(300)
        
        twoStacks.printBothStacks()
        
        // Test peek operation for both stacks
        println("\n2. Peek operation:")
        println("Stack 1 top element: ${twoStacks.peek1()}")
        println("Stack 2 top element: ${twoStacks.peek2()}")
        
        // Test pop operation for both stacks
        println("\n3. Pop operation:")
        println("Popped from Stack 1: ${twoStacks.pop1()}")
        println("Popped from Stack 2: ${twoStacks.pop2()}")
        
        twoStacks.printBothStacks()
        
        // Test size operation for both stacks
        println("\n4. Stack sizes:")
        println("Stack 1 size: ${twoStacks.size1()}")
        println("Stack 2 size: ${twoStacks.size2()}")
        println("Total capacity: ${twoStacks.totalCapacity()}")
        println("Remaining capacity: ${twoStacks.remainingCapacity()}")
        
        // Test isEmpty operation for both stacks
        println("\n5. Is stack empty?")
        println("Is Stack 1 empty: ${twoStacks.isEmpty1()}")
        println("Is Stack 2 empty: ${twoStacks.isEmpty2()}")
        
        // Test filling the array completely
        println("\n6. Filling the array completely:")
        println("Pushing more elements to Stack 1")
        twoStacks.push1(40)
        twoStacks.push1(50)
        
        println("Pushing more elements to Stack 2")
        twoStacks.push2(400)
        twoStacks.push2(500)
        twoStacks.push2(600)
        
        twoStacks.printBothStacks()
        
        println("\nRemaining capacity: ${twoStacks.remainingCapacity()}")
        
        // Test stack overflow
        println("\n7. Testing stack overflow:")
        try {
            println("Trying to push one more element to Stack 1")
            twoStacks.push1(60)  // This should cause an overflow
        } catch (e: Exception) {
            println("Exception: $e")
        }
        
        // Pop all elements from both stacks
        println("\n8. Popping all elements:")
        println("Popping all elements from Stack 1:")
        while (!twoStacks.isEmpty1()) {
            println("Popped: ${twoStacks.pop1()}")
        }
        
        println("\nPopping all elements from Stack 2:")
        while (!twoStacks.isEmpty2()) {
            println("Popped: ${twoStacks.pop2()}")
        }
        
        twoStacks.printBothStacks()
        
        // Test stack underflow
        println("\n9. Testing stack underflow:")
        try {
            println("Trying to pop from empty Stack 1")
            twoStacks.pop1()  // This should cause an underflow
        } catch (e: Exception) {
            println("Exception: $e")
        }
    } catch (e: Exception) {
        println("Exception: $e")
    }
    
    // Test with a different data type
    println("\n10. Testing with strings:")
    val stringStacks = TwoStacksInArray<String>(6)
    try {
        stringStacks.push1("Hello")
        stringStacks.push1("World")
        stringStacks.push2("Kotlin")
        stringStacks.push2("Programming")
        
        stringStacks.printBothStacks()
        
        println("\nPopped from Stack 1: ${stringStacks.pop1()}")
        println("Popped from Stack 2: ${stringStacks.pop2()}")
        
        stringStacks.printBothStacks()
        
        // Test clear operation
        println("\n11. Testing clear operation:")
        stringStacks.clear()
        println("After clearing both stacks:")
        stringStacks.printBothStacks()
    } catch (e: Exception) {
        println("Exception: $e")
    }
    
    // Demonstrate Kotlin's functional approach
    println("\n12. Demonstrating Kotlin's functional approach:")
    val twoStacksFunc = TwoStacksInArray<Int>(5)
    
    // Using apply for initialization
    twoStacksFunc.apply {
        push1(10)
        push1(20)
        push2(100)
        push2(200)
    }
    
    println("After initialization:")
    twoStacksFunc.printBothStacks()
    
    // Using run for operations and getting a result
    val sum1 = twoStacksFunc.run {
        val a = pop1()
        val b = pop1()
        a + b
    }
    
    val sum2 = twoStacksFunc.run {
        val a = pop2()
        val b = pop2()
        a + b
    }
    
    println("\nSum of popped elements from Stack 1: $sum1")
    println("Sum of popped elements from Stack 2: $sum2")
    
    println("\nAfter operations:")
    twoStacksFunc.printBothStacks()
}