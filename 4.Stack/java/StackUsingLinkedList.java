/**
 * Implement Stack using Linked List in Java
 * 
 * This program demonstrates how to implement a stack data structure using a linked list in Java.
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

package java;

import java.util.EmptyStackException;

public class StackUsingLinkedList<T> {
    // Node class for the linked list
    private static class Node<T> {
        private T data;
        private Node<T> next;
        
        public Node(T data) {
            this.data = data;
            this.next = null;
        }
    }
    
    private Node<T> top;  // Reference to the top node
    private int size;     // Number of elements in the stack
    
    /**
     * Constructor to initialize an empty stack
     */
    public StackUsingLinkedList() {
        top = null;
        size = 0;
    }
    
    /**
     * Push an element onto the stack
     * 
     * @param item The element to push
     */
    public void push(T item) {
        // Create a new node
        Node<T> newNode = new Node<>(item);
        
        // Link the new node to the current top
        newNode.next = top;
        
        // Update the top pointer
        top = newNode;
        
        // Increment the size
        size++;
    }
    
    /**
     * Pop the top element from the stack
     * 
     * @return The popped element
     * @throws EmptyStackException if the stack is empty
     */
    public T pop() {
        if (isEmpty()) {
            throw new EmptyStackException();
        }
        
        // Save the top node and its data
        T poppedItem = top.data;
        
        // Update the top pointer
        top = top.next;
        
        // Decrement the size
        size--;
        
        return poppedItem;
    }
    
    /**
     * Peek at the top element without removing it
     * 
     * @return The top element
     * @throws EmptyStackException if the stack is empty
     */
    public T peek() {
        if (isEmpty()) {
            throw new EmptyStackException();
        }
        
        return top.data;
    }
    
    /**
     * Check if the stack is empty
     * 
     * @return true if the stack is empty, false otherwise
     */
    public boolean isEmpty() {
        return top == null;
    }
    
    /**
     * Get the current size of the stack
     * 
     * @return The number of elements in the stack
     */
    public int size() {
        return size;
    }
    
    /**
     * Print the contents of the stack
     */
    public void print() {
        if (isEmpty()) {
            System.out.println("Stack is empty");
            return;
        }
        
        System.out.print("Stack contents (top to bottom): ");
        
        // Create a temporary pointer to traverse the list
        Node<T> current = top;
        
        while (current != null) {
            System.out.print(current.data + " ");
            current = current.next;
        }
        
        System.out.println();
    }
    
    /**
     * Clear the stack
     */
    public void clear() {
        top = null;
        size = 0;
    }
    
    /**
     * Search for an element in the stack
     * 
     * @param item The element to search for
     * @return The 1-based position of the element from the top, or -1 if not found
     */
    public int search(T item) {
        if (isEmpty()) {
            return -1;
        }
        
        Node<T> current = top;
        int position = 1;
        
        while (current != null) {
            if ((current.data == null && item == null) || 
                (current.data != null && current.data.equals(item))) {
                return position;
            }
            current = current.next;
            position++;
        }
        
        return -1; // Element not found
    }
    
    /**
     * Main method to demonstrate the stack operations
     */
    public static void main(String[] args) {
        System.out.println("Stack Implementation using Linked List in Java");
        System.out.println("--------------------------------------------");
        
        // Create a stack of integers
        StackUsingLinkedList<Integer> stack = new StackUsingLinkedList<>();
        
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
            
            // Test search operation
            System.out.println("\n6. Search operation:");
            System.out.println("Position of 20: " + stack.search(20));
            System.out.println("Position of 50: " + stack.search(50));
            
            // Pop all elements
            System.out.println("\n7. Popping all elements:");
            while (!stack.isEmpty()) {
                System.out.println("Popped: " + stack.pop());
            }
            
            // Check if stack is empty after popping all elements
            System.out.println("\n8. Is stack empty after popping all elements?");
            System.out.println("Is empty: " + stack.isEmpty());
        } catch (Exception e) {
            System.out.println("Exception: " + e);
        }
        
        // Test stack underflow
        System.out.println("\n9. Testing stack underflow:");
        StackUsingLinkedList<Integer> emptyStack = new StackUsingLinkedList<>();
        try {
            emptyStack.pop();  // This should cause an underflow
        } catch (Exception e) {
            System.out.println("Exception: " + e);
        }
        
        // Test with a different data type
        System.out.println("\n10. Testing stack with strings:");
        StackUsingLinkedList<String> stringStack = new StackUsingLinkedList<>();
        try {
            stringStack.push("Hello");
            stringStack.push("World");
            stringStack.push("Java");
            stringStack.print();
            
            System.out.println("Popped element: " + stringStack.pop());
            stringStack.print();
            
            // Test clear operation
            System.out.println("\n11. Testing clear operation:");
            stringStack.clear();
            System.out.println("After clearing the stack:");
            stringStack.print();
            System.out.println("Is empty: " + stringStack.isEmpty());
        } catch (Exception e) {
            System.out.println("Exception: " + e);
        }
    }
}