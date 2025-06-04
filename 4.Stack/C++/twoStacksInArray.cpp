/**
 * Implement Two Stacks in an Array in C++
 * 
 * This program demonstrates how to implement two stacks using a single array
 * efficiently. The first stack starts from the beginning of the array and grows
 * towards the end, while the second stack starts from the end and grows towards
 * the beginning.
 * 
 * Time Complexity: O(1) for push, pop, and peek operations for both stacks
 * Space Complexity: O(n) where n is the size of the array
 */

#include <iostream>
#include <stdexcept>

template <typename T>
class TwoStacks {
private:
    T* array;          // Array to store elements of both stacks
    int capacity;      // Total capacity of the array
    int top1;          // Top index for stack 1
    int top2;          // Top index for stack 2

public:
    /**
     * Constructor to initialize the two stacks
     * 
     * @param size Total capacity of the array
     */
    TwoStacks(int size = 100) {
        capacity = size;
        array = new T[capacity];
        top1 = -1;           // Stack 1 starts from the beginning
        top2 = capacity;     // Stack 2 starts from the end
    }
    
    /**
     * Destructor to free the allocated memory
     */
    ~TwoStacks() {
        delete[] array;
    }
    
    /**
     * Check if stack 1 is empty
     * 
     * @return true if stack 1 is empty, false otherwise
     */
    bool isStack1Empty() const {
        return top1 == -1;
    }
    
    /**
     * Check if stack 2 is empty
     * 
     * @return true if stack 2 is empty, false otherwise
     */
    bool isStack2Empty() const {
        return top2 == capacity;
    }
    
    /**
     * Check if the array is full (no space for either stack)
     * 
     * @return true if the array is full, false otherwise
     */
    bool isFull() const {
        return top1 + 1 == top2;
    }
    
    /**
     * Push an item onto stack 1
     * 
     * @param item The item to push
     * @throws std::overflow_error if the array is full
     */
    void pushToStack1(T item) {
        if (isFull()) {
            throw std::overflow_error("Stack Overflow: Cannot push to stack 1");
        }
        array[++top1] = item;
    }
    
    /**
     * Push an item onto stack 2
     * 
     * @param item The item to push
     * @throws std::overflow_error if the array is full
     */
    void pushToStack2(T item) {
        if (isFull()) {
            throw std::overflow_error("Stack Overflow: Cannot push to stack 2");
        }
        array[--top2] = item;
    }
    
    /**
     * Pop an item from stack 1
     * 
     * @return The popped item
     * @throws std::underflow_error if stack 1 is empty
     */
    T popFromStack1() {
        if (isStack1Empty()) {
            throw std::underflow_error("Stack 1 Underflow: Cannot pop from an empty stack");
        }
        return array[top1--];
    }
    
    /**
     * Pop an item from stack 2
     * 
     * @return The popped item
     * @throws std::underflow_error if stack 2 is empty
     */
    T popFromStack2() {
        if (isStack2Empty()) {
            throw std::underflow_error("Stack 2 Underflow: Cannot pop from an empty stack");
        }
        return array[top2++];
    }
    
    /**
     * Peek at the top item of stack 1 without removing it
     * 
     * @return The top item of stack 1
     * @throws std::underflow_error if stack 1 is empty
     */
    T peekStack1() const {
        if (isStack1Empty()) {
            throw std::underflow_error("Stack 1 is empty: Cannot peek");
        }
        return array[top1];
    }
    
    /**
     * Peek at the top item of stack 2 without removing it
     * 
     * @return The top item of stack 2
     * @throws std::underflow_error if stack 2 is empty
     */
    T peekStack2() const {
        if (isStack2Empty()) {
            throw std::underflow_error("Stack 2 is empty: Cannot peek");
        }
        return array[top2];
    }
    
    /**
     * Get the size of stack 1
     * 
     * @return The number of elements in stack 1
     */
    int sizeOfStack1() const {
        return top1 + 1;
    }
    
    /**
     * Get the size of stack 2
     * 
     * @return The number of elements in stack 2
     */
    int sizeOfStack2() const {
        return capacity - top2;
    }
    
    /**
     * Print the contents of stack 1
     */
    void printStack1() const {
        if (isStack1Empty()) {
            std::cout << "Stack 1 is empty" << std::endl;
            return;
        }
        
        std::cout << "Stack 1 contents: ";
        for (int i = 0; i <= top1; i++) {
            std::cout << array[i] << " ";
        }
        std::cout << std::endl;
    }
    
    /**
     * Print the contents of stack 2
     */
    void printStack2() const {
        if (isStack2Empty()) {
            std::cout << "Stack 2 is empty" << std::endl;
            return;
        }
        
        std::cout << "Stack 2 contents: ";
        for (int i = capacity - 1; i >= top2; i--) {
            std::cout << array[i] << " ";
        }
        std::cout << std::endl;
    }
};

int main() {
    std::cout << "Two Stacks in an Array Demonstration in C++" << std::endl;
    std::cout << "------------------------------------------" << std::endl;
    
    // Create two stacks with a total capacity of 10
    TwoStacks<int> stacks(10);
    
    try {
        // Push elements to stack 1
        std::cout << "\n1. Pushing elements to Stack 1:" << std::endl;
        stacks.pushToStack1(10);
        stacks.pushToStack1(20);
        stacks.pushToStack1(30);
        stacks.printStack1();
        
        // Push elements to stack 2
        std::cout << "\n2. Pushing elements to Stack 2:" << std::endl;
        stacks.pushToStack2(100);
        stacks.pushToStack2(200);
        stacks.pushToStack2(300);
        stacks.printStack2();
        
        // Peek operations
        std::cout << "\n3. Peek operations:" << std::endl;
        std::cout << "Top element of Stack 1: " << stacks.peekStack1() << std::endl;
        std::cout << "Top element of Stack 2: " << stacks.peekStack2() << std::endl;
        
        // Pop operations
        std::cout << "\n4. Pop operations:" << std::endl;
        std::cout << "Popped from Stack 1: " << stacks.popFromStack1() << std::endl;
        std::cout << "Popped from Stack 2: " << stacks.popFromStack2() << std::endl;
        
        // Print stacks after pop
        std::cout << "\n5. Stacks after pop operations:" << std::endl;
        stacks.printStack1();
        stacks.printStack2();
        
        // Get sizes
        std::cout << "\n6. Stack sizes:" << std::endl;
        std::cout << "Size of Stack 1: " << stacks.sizeOfStack1() << std::endl;
        std::cout << "Size of Stack 2: " << stacks.sizeOfStack2() << std::endl;
        
        // Test stack limits
        std::cout << "\n7. Testing stack limits:" << std::endl;
        
        // Fill the array with elements from both stacks
        std::cout << "Filling the array with elements from both stacks..." << std::endl;
        for (int i = 0; i < 2; i++) {
            stacks.pushToStack1(i + 40);
        }
        
        for (int i = 0; i < 2; i++) {
            stacks.pushToStack2(i + 400);
        }
        
        stacks.printStack1();
        stacks.printStack2();
        
        // Try to push when array is full
        std::cout << "\n8. Trying to push when array is full:" << std::endl;
        stacks.pushToStack1(999);  // This should cause an overflow
    } catch (const std::exception& e) {
        std::cout << "Exception: " << e.what() << std::endl;
    }
    
    // Create a new instance to test underflow
    std::cout << "\n9. Testing stack underflow:" << std::endl;
    TwoStacks<int> emptyStacks(5);
    try {
        emptyStacks.popFromStack1();  // This should cause an underflow
    } catch (const std::exception& e) {
        std::cout << "Exception: " << e.what() << std::endl;
    }
    
    // Test with a different data type
    std::cout << "\n10. Testing with strings:" << std::endl;
    TwoStacks<std::string> stringStacks(5);
    try {
        stringStacks.pushToStack1("Hello");
        stringStacks.pushToStack1("World");
        stringStacks.pushToStack2("C++");
        stringStacks.pushToStack2("Programming");
        
        stringStacks.printStack1();
        stringStacks.printStack2();
        
        std::cout << "Popped from Stack 1: " << stringStacks.popFromStack1() << std::endl;
        std::cout << "Popped from Stack 2: " << stringStacks.popFromStack2() << std::endl;
        
        stringStacks.printStack1();
        stringStacks.printStack2();
    } catch (const std::exception& e) {
        std::cout << "Exception: " << e.what() << std::endl;
    }
    
    return 0;
}