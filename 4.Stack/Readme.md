# Stack Data Structure

This section contains implementations of common stack operations and problems in multiple programming languages (C, C++, Java, and Kotlin).

## What is a Stack?

A stack is a linear data structure that follows the **Last-In-First-Out (LIFO)** principle. This means that the last element added to the stack will be the first one to be removed.

### Visual Representation

```
    ┌───┐
    │ D │ ← Top (Last In, First Out)
    ├───┤
    │ C │
    ├───┤
    │ B │
    ├───┤
    │ A │ ← Bottom (First In, Last Out)
    └───┘
```

### Real-world Analogies

- **Stack of plates**: You add plates to the top and remove from the top
- **Book stack**: Books stacked on top of each other, you typically remove the top book
- **Browser back button**: Tracks the history of visited pages in a stack
- **Undo functionality**: Each action is pushed onto a stack, and undo pops the most recent action

### Key Characteristics

- Elements are added and removed from the same end (the "top" of the stack)
- Only the top element is accessible at any time (limited access)
- Follows the LIFO (Last-In-First-Out) principle
- Operations have constant time complexity O(1)
- Can be implemented using arrays or linked lists

## Problems

### 1. Implement Stack using Array
- **Description**: Implementation of a stack data structure using a fixed-size array
- **Time Complexity**: O(1) for push, pop, and peek operations
- **Space Complexity**: O(n) where n is the maximum size of the stack
- **Implementations**: [C](C/stackUsingArray.c) | [C++](C++/stackUsingArray.cpp) | [Java](java/StackUsingArray.java) | [Kotlin](Kotlin/StackUsingArray.kt)

### 2. Implement Stack using Linked List
- **Description**: Implementation of a stack data structure using a linked list
- **Time Complexity**: O(1) for push, pop, and peek operations
- **Space Complexity**: O(n) where n is the number of elements in the stack
- **Implementations**: [C](C/stackUsingLinkedList.c) | [C++](C++/stackUsingLinkedList.cpp) | [Java](java/StackUsingLinkedList.java) | [Kotlin](Kotlin/StackUsingLinkedList.kt)

### 3. Next Greater Element using Stack
- **Description**: Find the next greater element for each element in an array
- **Time Complexity**: O(n) where n is the size of the array
- **Space Complexity**: O(n) for the stack and result array
- **Implementations**: [C](C/nextGreaterElement.c) | [C++](C++/nextGreaterElement.cpp) | [Java](java/NextGreaterElement.java) | [Kotlin](Kotlin/NextGreaterElement.kt)

### 4. Implement Two Stacks in an Array
- **Description**: Implement two stacks using a single array efficiently
- **Time Complexity**: O(1) for push, pop, and peek operations for both stacks
- **Space Complexity**: O(n) where n is the size of the array
- **Implementations**: [C](C/twoStacksInArray.c) | [C++](C++/twoStacksInArray.cpp) | [Java](java/TwoStacksInArray.java) | [Kotlin](Kotlin/TwoStacksInArray.kt)

### 5. Valid Parentheses Problem
- **Description**: Check if a string containing parentheses, brackets, and braces is valid
- **Time Complexity**: O(n) where n is the length of the string
- **Space Complexity**: O(n) in the worst case
- **Implementations**: [C](C/validParentheses.c) | [C++](C++/validParentheses.cpp) | [Java](java/ValidParentheses.java) | [Kotlin](Kotlin/ValidParentheses.kt)

## Implementation Languages
- [C Implementations](C/)
- [C++ Implementations](C++/)
- [Java Implementations](java/)
- [Kotlin Implementations](Kotlin/)

## Key Stack Concepts

### Basic Operations
- **Push**: Add an element to the top of the stack
- **Pop**: Remove the top element from the stack
- **Peek/Top**: View the top element without removing it
- **isEmpty**: Check if the stack is empty
- **isFull**: Check if the stack is full (for array-based implementations)

### Applications of Stacks
- Function call management (call stack)
- Expression evaluation and syntax parsing
- Undo mechanisms in text editors
- Browser history (back button functionality)
- Backtracking algorithms
- Balanced parentheses checking
- Infix to postfix conversion

### Implementation Approaches
1. **Array-based**: Simple but has a fixed size
2. **Linked List-based**: Dynamic size but requires more memory per element

### Common Stack Problems
- Balancing symbols/parentheses
- Infix, Prefix, and Postfix conversions
- Next Greater/Smaller Element
- Stock Span Problem
- Histogram Area
- Implementing multiple stacks in a single array