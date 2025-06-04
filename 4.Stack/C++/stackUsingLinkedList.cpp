/**
 * Implement Stack using Linked List in C++
 * 
 * This program demonstrates how to implement a stack data structure using a linked list in C++.
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

#include <iostream>
#include <stdexcept>

template <typename T>
class Stack {
private:
    // Node structure for the linked list
    struct Node {
        T data;
        Node* next;
        
        // Constructor
        Node(T value) : data(value), next(nullptr) {}
    };
    
    Node* top;  // Pointer to the top node
    int count;  // Number of elements in the stack
    
public:
    /**
     * Constructor to initialize an empty stack
     */
    Stack() : top(nullptr), count(0) {}
    
    /**
     * Destructor to free the allocated memory
     */
    ~Stack() {
        // Delete all nodes
        while (!isEmpty()) {
            pop();
        }
    }
    
    /**
     * Push an element onto the stack
     * 
     * @param item The element to push
     */
    void push(T item) {
        // Create a new node
        Node* newNode = new Node(item);
        
        // Link the new node to the current top
        newNode->next = top;
        
        // Update the top pointer
        top = newNode;
        
        // Increment the count
        count++;
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
        
        // Save the top node and its data
        Node* temp = top;
        T poppedItem = temp->data;
        
        // Update the top pointer
        top = top->next;
        
        // Free the memory of the popped node
        delete temp;
        
        // Decrement the count
        count--;
        
        return poppedItem;
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
        
        return top->data;
    }
    
    /**
     * Check if the stack is empty
     * 
     * @return true if the stack is empty, false otherwise
     */
    bool isEmpty() const {
        return top == nullptr;
    }
    
    /**
     * Get the current size of the stack
     * 
     * @return The number of elements in the stack
     */
    int size() const {
        return count;
    }
    
    /**
     * Print the contents of the stack
     */
    void print() const {
        if (isEmpty()) {
            std::cout << "Stack is empty" << std::endl;
            return;
        }
        
        std::cout << "Stack contents (top to bottom): ";
        
        // Create a temporary pointer to traverse the list
        Node* current = top;
        
        while (current != nullptr) {
            std::cout << current->data << " ";
            current = current->next;
        }
        
        std::cout << std::endl;
    }
};

int main() {
    std::cout << "Stack Implementation using Linked List in C++" << std::endl;
    std::cout << "--------------------------------------------" << std::endl;
    
    // Create a stack of integers
    Stack<int> stack;
    
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
        
        // Pop all elements
        std::cout << "\n6. Popping all elements:" << std::endl;
        while (!stack.isEmpty()) {
            std::cout << "Popped: " << stack.pop() << std::endl;
        }
        
        // Check if stack is empty after popping all elements
        std::cout << "\n7. Is stack empty after popping all elements?" << std::endl;
        std::cout << "Is empty: " << (stack.isEmpty() ? "Yes" : "No") << std::endl;
    } catch (const std::exception& e) {
        std::cout << "Exception: " << e.what() << std::endl;
    }
    
    // Test stack underflow
    std::cout << "\n8. Testing stack underflow:" << std::endl;
    Stack<int> emptyStack;
    try {
        emptyStack.pop();  // This should cause an underflow
    } catch (const std::exception& e) {
        std::cout << "Exception: " << e.what() << std::endl;
    }
    
    // Test with a different data type
    std::cout << "\n9. Testing stack with strings:" << std::endl;
    Stack<std::string> stringStack;
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
    
    // Demonstrate memory management
    std::cout << "\n10. Demonstrating automatic memory cleanup:" << std::endl;
    {
        Stack<int> tempStack;
        tempStack.push(100);
        tempStack.push(200);
        tempStack.push(300);
        std::cout << "Created a temporary stack with 3 elements" << std::endl;
        // Stack will be destroyed when it goes out of scope
    }
    std::cout << "Temporary stack destroyed and memory freed" << std::endl;
    
    return 0;
}