/**
 * Implement Stack using Array in Java
 * 
 * This program demonstrates how to implement a stack data structure using an array in Java.
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

package java;

import java.util.EmptyStackException;

public class StackUsingArray<T> {
    private Object[] array; // Array to store stack elements
    private int capacity;   // Maximum capacity of the stack
    private int top;        // Index of the top element
    
    /**
     * Constructor to initialize the stack with a given capacity
     * 
     * @param size Maximum capacity of the stack
     */
    public StackUsingArray(int size) {
        capacity = size;
        array = new Object[capacity];
        top = -1; // Stack is initially empty
    }
    
    /**
     * Constructor with default capacity of 10
     */
    public StackUsingArray() {
        this(10); // Default capacity is 10
    }
    
    /**
     * Push an element onto the stack
     * 
     * @param item The element to push
     * @throws IllegalStateException if the stack is full
     */
    public void push(T item) {
        if (isFull()) {
            throw new IllegalStateException("Stack Overflow: Cannot push to a full stack");
        }
        array[++top] = item;
    }
    
    /**
     * Pop the top element from the stack
     * 
     * @return The popped element
     * @throws EmptyStackException if the stack is empty
     */
    @SuppressWarnings("unchecked")
    public T pop() {
        if (isEmpty()) {
            throw new EmptyStackException();
        }
        T item = (T) array[top];
        array[top--] = null; // Help garbage collection
        return item;
    }
    
    /**
     * Peek at the top element without removing it
     * 
     * @return The top element
     * @throws EmptyStackException if the stack is empty
     */
    @SuppressWarnings("unchecked")
    public T peek() {
        if (isEmpty()) {
            throw new EmptyStackException();
        }
        return (T) array[top];
    }
    
    /**
     * Check if the stack is empty
     * 
     * @return true if the stack is empty, false otherwise
     */
    public boolean isEmpty() {
        return top == -1;
    }
    
    /**
     * Check if the stack is full
     * 
     * @return true if the stack is full, false otherwise
     */
    public boolean isFull() {
        return top == capacity - 1;
    }
    
    /**
     * Get the current size of the stack
     * 
     * @return The number of elements in the stack
     */
    public int size() {
        return top + 1;
    }
    
    /**
     * Print the contents of the stack
     */
    public void print() {
        if (isEmpty()) {
            System.out.println("Stack is empty");
            return;
        }
        
        System.out.print("Stack contents (bottom to top): ");
        for (int i = 0; i <= top; i++) {
            System.out.print(array[i] + " ");
        }
        System.out.println();
    }
    
    /**
     * Clear the stack
     */
    public void clear() {
        for (int i = 0; i <= top; i++) {
            array[i] = null; // Help garbage collection
        }
        top = -1;
    }
    
    /**
     * Main method to demonstrate the stack operations
     */
    public static void main(String[] args) {
        System.out.println("Stack Implementation using Array in Java");
        System.out.println("----------------------------------------");
        
        // Create a stack of integers with capacity 5
        StackUsingArray<Integer> stack = new StackUsingArray<>(5);
        
        try {
            // Test push operation
            System.out.println("\n1. Pushing elements to the stack:");
            stack.push(10);
            stack.push(20);
            stack.push(30);
            stack.push(40);
            stack.print();
            
            // Test peek operation
            System.out.println("\n2. Peek operation:");
            System.out.println("Top element: " + stack.peek());
            
            // Test pop operation
            System.out.println("\n3. Pop operation:");
            System.out.println("Popped element: " + stack.pop());
            stack.print();
            
            // Test size operation
            System.out.println("\n4. Stack size:");
            System.out.println("Current size: " + stack.size());
            
            // Test isEmpty operation
            System.out.println("\n5. Is stack empty?");
            System.out.println("Is empty: " + stack.isEmpty());
            
            // Test isFull operation
            System.out.println("\n6. Is stack full?");
            System.out.println("Is full: " + stack.isFull());
            
            // Test stack overflow
            System.out.println("\n7. Testing stack overflow:");
            stack.push(50);
            stack.push(60);  // This should cause an overflow
            stack.print();
        } catch (Exception e) {
            System.out.println("Exception: " + e.getMessage());
        }
        
        // Create a new stack to test underflow
        System.out.println("\n8. Testing stack underflow:");
        StackUsingArray<Integer> emptyStack = new StackUsingArray<>(3);
        try {
            emptyStack.pop();  // This should cause an underflow
        } catch (Exception e) {
            System.out.println("Exception: " + e);
        }
        
        // Test with a different data type
        System.out.println("\n9. Testing stack with strings:");
        StackUsingArray<String> stringStack = new StackUsingArray<>(3);
        try {
            stringStack.push("Hello");
            stringStack.push("World");
            stringStack.push("Java");
            stringStack.print();
            
            System.out.println("Popped element: " + stringStack.pop());
            stringStack.print();
        } catch (Exception e) {
            System.out.println("Exception: " + e.getMessage());
        }
        
        // Test clear operation
        System.out.println("\n10. Testing clear operation:");
        stringStack.clear();
        System.out.println("After clearing the stack:");
        stringStack.print();
        System.out.println("Is empty: " + stringStack.isEmpty());
    }
}