/**
 * Implement Stack using Array in C++
 * 
 * This program demonstrates how to implement a stack data structure using an array in C++.
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

#include <iostream>
#include <stdexcept>

template <typename T>
class Stack {
private:
    T* array;          // Array to store stack elements
    int capacity;      // Maximum capacity of the stack
    int topIndex;      // Index of the top element

public:
    /**
     * Constructor to initialize the stack with a given capacity
     * 
     * @param size Maximum capacity of the stack
     */
    Stack(int size = 100) {
        capacity = size;
        array = new T[capacity];
        topIndex = -1;  // Stack is initially empty
    }
    
    /**
     * Destructor to free the allocated memory
     */
    ~Stack() {
        delete[] array;
    }
    
    /**
     * Push an element onto the stack
     * 
     * @param item The element to push
     * @throws std::overflow_error if the stack is full
     */
    void push(T item) {
        if (isFull()) {
            throw std::overflow_error("Stack Overflow: Cannot push to a full stack");
        }
        array[++topIndex] = item;
    }
    
    /**
     * Pop the top element from the stack
     * 
     * @return The popped element
     * @throws std::underflow_error if the stack is empty
     */
    T pop() {
        if (isEmpty()) {
            throw std::underflow_error("Stack Underflow: Cannot pop from an empty stack");
        }
        return array[topIndex--];
    }
    
    /**
     * Peek at the top element without removing it
     * 
     * @return The top element
     * @throws std::underflow_error if the stack is empty
     */
    T peek() const {
        if (isEmpty()) {
            throw std::underflow_error("Stack is empty: Cannot peek");
        }
        return array[topIndex];
    }
    
    /**
     * Check if the stack is empty
     * 
     * @return true if the stack is empty, false otherwise
     */
    bool isEmpty() const {
        return topIndex == -1;
    }
    
    /**
     * Check if the stack is full
     * 
     * @return true if the stack is full, false otherwise
     */
    bool isFull() const {
        return topIndex == capacity - 1;
    }
    
    /**
     * Get the current size of the stack
     * 
     * @return The number of elements in the stack
     */
    int size() const {
        return topIndex + 1;
    }
    
    /**
     * Print the contents of the stack
     */
    void print() const {
        if (isEmpty()) {
            std::cout << "Stack is empty" << std::endl;
            return;
        }
        
        std::cout << "Stack contents (bottom to top): ";
        for (int i = 0; i <= topIndex; i++) {
            std::cout << array[i] << " ";
        }
        std::cout << std::endl;
    }
};

int main() {
    std::cout << "Stack Implementation using Array in C++" << std::endl;
    std::cout << "----------------------------------------" << std::endl;
    
    // Create a stack of integers with capacity 5
    Stack<int> stack(5);
    
    try {
        // Test push operation
        std::cout << "\n1. Pushing elements to the stack:" << std::endl;
        stack.push(10);
        stack.push(20);
        stack.push(30);
        stack.push(40);
        stack.print();
        
        // Test peek operation
        std::cout << "\n2. Peek operation:" << std::endl;
        std::cout << "Top element: " << stack.peek() << std::endl;
        
        // Test pop operation
        std::cout << "\n3. Pop operation:" << std::endl;
        std::cout << "Popped element: " << stack.pop() << std::endl;
        stack.print();
        
        // Test size operation
        std::cout << "\n4. Stack size:" << std::endl;
        std::cout << "Current size: " << stack.size() << std::endl;
        
        // Test isEmpty operation
        std::cout << "\n5. Is stack empty?" << std::endl;
        std::cout << "Is empty: " << (stack.isEmpty() ? "Yes" : "No") << std::endl;
        
        // Test isFull operation
        std::cout << "\n6. Is stack full?" << std::endl;
        std::cout << "Is full: " << (stack.isFull() ? "Yes" : "No") << std::endl;
        
        // Test stack overflow
        std::cout << "\n7. Testing stack overflow:" << std::endl;
        stack.push(50);
        stack.push(60);  // This should cause an overflow
        stack.print();
    } catch (const std::exception& e) {
        std::cout << "Exception: " << e.what() << std::endl;
    }
    
    // Create a new stack to test underflow
    std::cout << "\n8. Testing stack underflow:" << std::endl;
    Stack<int> emptyStack(3);
    try {
        emptyStack.pop();  // This should cause an underflow
    } catch (const std::exception& e) {
        std::cout << "Exception: " << e.what() << std::endl;
    }
    
    // Test with a different data type
    std::cout << "\n9. Testing stack with strings:" << std::endl;
    Stack<std::string> stringStack(3);
    try {
        stringStack.push("Hello");
        stringStack.push("World");
        stringStack.push("C++");
        stringStack.print();
        
        std::cout << "Popped element: " << stringStack.pop() << std::endl;
        stringStack.print();
    } catch (const std::exception& e) {
        std::cout << "Exception: " << e.what() << std::endl;
    }
    
    return 0;
}