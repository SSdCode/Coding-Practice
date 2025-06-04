/**
 * Implement Two Stacks in an Array in Java
 * 
 * This program demonstrates how to implement two stacks using a single array
 * efficiently. The first stack starts from the beginning of the array and grows
 * towards the end, while the second stack starts from the end and grows towards
 * the beginning.
 * 
 * Time Complexity: O(1) for push, pop, and peek operations for both stacks
 * Space Complexity: O(n) where n is the size of the array
 */

package java;

import java.util.EmptyStackException;

public class TwoStacksInArray<T> {
    private Object[] array;  // Array to store elements of both stacks
    private int capacity;   // Total capacity of the array
    private int top1;       // Top index for stack 1
    private int top2;       // Top index for stack 2
    
    /**
     * Constructor to initialize the two stacks
     * 
     * @param size Total capacity of the array
     */
    public TwoStacksInArray(int size) {
        capacity = size;
        array = new Object[capacity];
        top1 = -1;           // Stack 1 starts from the beginning
        top2 = capacity;     // Stack 2 starts from the end
    }
    
    /**
     * Constructor with default capacity of 10
     */
    public TwoStacksInArray() {
        this(10); // Default capacity is 10
    }
    
    /**
     * Check if stack 1 is empty
     * 
     * @return true if stack 1 is empty, false otherwise
     */
    public boolean isStack1Empty() {
        return top1 == -1;
    }
    
    /**
     * Check if stack 2 is empty
     * 
     * @return true if stack 2 is empty, false otherwise
     */
    public boolean isStack2Empty() {
        return top2 == capacity;
    }
    
    /**
     * Check if the array is full (no space for either stack)
     * 
     * @return true if the array is full, false otherwise
     */
    public boolean isFull() {
        return top1 + 1 == top2;
    }
    
    /**
     * Push an item onto stack 1
     * 
     * @param item The item to push
     * @throws IllegalStateException if the array is full
     */
    public void pushToStack1(T item) {
        if (isFull()) {
            throw new IllegalStateException("Stack Overflow: Cannot push to stack 1");
        }
        array[++top1] = item;
    }
    
    /**
     * Push an item onto stack 2
     * 
     * @param item The item to push
     * @throws IllegalStateException if the array is full
     */
    public void pushToStack2(T item) {
        if (isFull()) {
            throw new IllegalStateException("Stack Overflow: Cannot push to stack 2");
        }
        array[--top2] = item;
    }
    
    /**
     * Pop an item from stack 1
     * 
     * @return The popped item
     * @throws EmptyStackException if stack 1 is empty
     */
    @SuppressWarnings("unchecked")
    public T popFromStack1() {
        if (isStack1Empty()) {
            throw new EmptyStackException();
        }
        T item = (T) array[top1];
        array[top1--] = null; // Help garbage collection
        return item;
    }
    
    /**
     * Pop an item from stack 2
     * 
     * @return The popped item
     * @throws EmptyStackException if stack 2 is empty
     */
    @SuppressWarnings("unchecked")
    public T popFromStack2() {
        if (isStack2Empty()) {
            throw new EmptyStackException();
        }
        T item = (T) array[top2];
        array[top2++] = null; // Help garbage collection
        return item;
    }
    
    /**
     * Peek at the top item of stack 1 without removing it
     * 
     * @return The top item of stack 1
     * @throws EmptyStackException if stack 1 is empty
     */
    @SuppressWarnings("unchecked")
    public T peekStack1() {
        if (isStack1Empty()) {
            throw new EmptyStackException();
        }
        return (T) array[top1];
    }
    
    /**
     * Peek at the top item of stack 2 without removing it
     * 
     * @return The top item of stack 2
     * @throws EmptyStackException if stack 2 is empty
     */
    @SuppressWarnings("unchecked")
    public T peekStack2() {
        if (isStack2Empty()) {
            throw new EmptyStackException();
        }
        return (T) array[top2];
    }
    
    /**
     * Get the size of stack 1
     * 
     * @return The number of elements in stack 1
     */
    public int sizeOfStack1() {
        return top1 + 1;
    }
    
    /**
     * Get the size of stack 2
     * 
     * @return The number of elements in stack 2
     */
    public int sizeOfStack2() {
        return capacity - top2;
    }
    
    /**
     * Print the contents of stack 1
     */
    public void printStack1() {
        if (isStack1Empty()) {
            System.out.println("Stack 1 is empty");
            return;
        }
        
        System.out.print("Stack 1 contents: ");
        for (int i = 0; i <= top1; i++) {
            System.out.print(array[i] + " ");
        }
        System.out.println();
    }
    
    /**
     * Print the contents of stack 2
     */
    public void printStack2() {
        if (isStack2Empty()) {
            System.out.println("Stack 2 is empty");
            return;
        }
        
        System.out.print("Stack 2 contents: ");
        for (int i = capacity - 1; i >= top2; i--) {
            System.out.print(array[i] + " ");
        }
        System.out.println();
    }
    
    /**
     * Clear both stacks
     */
    public void clear() {
        // Clear stack 1
        for (int i = 0; i <= top1; i++) {
            array[i] = null;
        }
        
        // Clear stack 2
        for (int i = capacity - 1; i >= top2; i--) {
            array[i] = null;
        }
        
        top1 = -1;
        top2 = capacity;
    }
    
    /**
     * Main method to demonstrate the two stacks operations
     */
    public static void main(String[] args) {
        System.out.println("Two Stacks in an Array Demonstration in Java");
        System.out.println("------------------------------------------");
        
        // Create two stacks with a total capacity of 10
        TwoStacksInArray<Integer> stacks = new TwoStacksInArray<>(10);
        
        try {
            // Push elements to stack 1
            System.out.println("\n1. Pushing elements to Stack 1:");
            stacks.pushToStack1(10);
            stacks.pushToStack1(20);
            stacks.pushToStack1(30);
            stacks.printStack1();
            
            // Push elements to stack 2
            System.out.println("\n2. Pushing elements to Stack 2:");
            stacks.pushToStack2(100);
            stacks.pushToStack2(200);
            stacks.pushToStack2(300);
            stacks.printStack2();
            
            // Peek operations
            System.out.println("\n3. Peek operations:");
            System.out.println("Top element of Stack 1: " + stacks.peekStack1());
            System.out.println("Top element of Stack 2: " + stacks.peekStack2());
            
            // Pop operations
            System.out.println("\n4. Pop operations:");
            System.out.println("Popped from Stack 1: " + stacks.popFromStack1());
            System.out.println("Popped from Stack 2: " + stacks.popFromStack2());
            
            // Print stacks after pop
            System.out.println("\n5. Stacks after pop operations:");
            stacks.printStack1();
            stacks.printStack2();
            
            // Get sizes
            System.out.println("\n6. Stack sizes:");
            System.out.println("Size of Stack 1: " + stacks.sizeOfStack1());
            System.out.println("Size of Stack 2: " + stacks.sizeOfStack2());
            
            // Test stack limits
            System.out.println("\n7. Testing stack limits:");
            
            // Fill the array with elements from both stacks
            System.out.println("Filling the array with elements from both stacks...");
            for (int i = 0; i < 2; i++) {
                stacks.pushToStack1(i + 40);
            }
            
            for (int i = 0; i < 2; i++) {
                stacks.pushToStack2(i + 400);
            }
            
            stacks.printStack1();
            stacks.printStack2();
            
            // Try to push when array is full
            System.out.println("\n8. Trying to push when array is full:");
            stacks.pushToStack1(999);  // This should cause an overflow
        } catch (Exception e) {
            System.out.println("Exception: " + e.getMessage());
        }
        
        // Create a new instance to test underflow
        System.out.println("\n9. Testing stack underflow:");
        TwoStacksInArray<Integer> emptyStacks = new TwoStacksInArray<>(5);
        try {
            emptyStacks.popFromStack1();  // This should cause an underflow
        } catch (Exception e) {
            System.out.println("Exception: " + e);
        }
        
        // Test with a different data type
        System.out.println("\n10. Testing with strings:");
        TwoStacksInArray<String> stringStacks = new TwoStacksInArray<>(5);
        try {
            stringStacks.pushToStack1("Hello");
            stringStacks.pushToStack1("World");
            stringStacks.pushToStack2("Java");
            stringStacks.pushToStack2("Programming");
            
            stringStacks.printStack1();
            stringStacks.printStack2();
            
            System.out.println("Popped from Stack 1: " + stringStacks.popFromStack1());
            System.out.println("Popped from Stack 2: " + stringStacks.popFromStack2());
            
            stringStacks.printStack1();
            stringStacks.printStack2();
            
            // Test clear operation
            System.out.println("\n11. Testing clear operation:");
            stringStacks.clear();
            System.out.println("After clearing the stacks:");
            stringStacks.printStack1();
            stringStacks.printStack2();
        } catch (Exception e) {
            System.out.println("Exception: " + e.getMessage());
        }
    }
}