/**
 * Implement Two Stacks in an Array in C
 * 
 * This program demonstrates how to implement two stacks using a single array
 * efficiently. The first stack starts from the beginning of the array and grows
 * towards the end, while the second stack starts from the end and grows towards
 * the beginning.
 * 
 * Time Complexity: O(1) for push, pop, and peek operations for both stacks
 * Space Complexity: O(n) where n is the size of the array
 */

#include <stdio.h>
#include <stdlib.h>
#include <stdbool.h>
#include <limits.h>

#define MAX_SIZE 100

// Two Stacks structure
typedef struct {
    int items[MAX_SIZE];
    int top1; // Top index for stack 1
    int top2; // Top index for stack 2
} TwoStacks;

/**
 * Initialize the two stacks
 * 
 * @param stacks Pointer to the TwoStacks structure
 */
void initTwoStacks(TwoStacks *stacks) {
    stacks->top1 = -1; // Stack 1 starts from the beginning
    stacks->top2 = MAX_SIZE; // Stack 2 starts from the end
}

/**
 * Check if stack 1 is empty
 * 
 * @param stacks Pointer to the TwoStacks structure
 * @return true if stack 1 is empty, false otherwise
 */
bool isStack1Empty(TwoStacks *stacks) {
    return stacks->top1 == -1;
}

/**
 * Check if stack 2 is empty
 * 
 * @param stacks Pointer to the TwoStacks structure
 * @return true if stack 2 is empty, false otherwise
 */
bool isStack2Empty(TwoStacks *stacks) {
    return stacks->top2 == MAX_SIZE;
}

/**
 * Check if the array is full (no space for either stack)
 * 
 * @param stacks Pointer to the TwoStacks structure
 * @return true if the array is full, false otherwise
 */
bool isFull(TwoStacks *stacks) {
    return stacks->top1 + 1 == stacks->top2;
}

/**
 * Push an item onto stack 1
 * 
 * @param stacks Pointer to the TwoStacks structure
 * @param item The item to push
 * @return true if the operation was successful, false if the array is full
 */
bool pushToStack1(TwoStacks *stacks, int item) {
    if (isFull(stacks)) {
        printf("Stack Overflow! Cannot push %d to Stack 1\n", item);
        return false;
    }
    
    stacks->items[++stacks->top1] = item;
    return true;
}

/**
 * Push an item onto stack 2
 * 
 * @param stacks Pointer to the TwoStacks structure
 * @param item The item to push
 * @return true if the operation was successful, false if the array is full
 */
bool pushToStack2(TwoStacks *stacks, int item) {
    if (isFull(stacks)) {
        printf("Stack Overflow! Cannot push %d to Stack 2\n", item);
        return false;
    }
    
    stacks->items[--stacks->top2] = item;
    return true;
}

/**
 * Pop an item from stack 1
 * 
 * @param stacks Pointer to the TwoStacks structure
 * @return The popped item, or INT_MIN if stack 1 is empty
 */
int popFromStack1(TwoStacks *stacks) {
    if (isStack1Empty(stacks)) {
        printf("Stack 1 Underflow! Cannot pop from an empty stack\n");
        return INT_MIN;
    }
    
    return stacks->items[stacks->top1--];
}

/**
 * Pop an item from stack 2
 * 
 * @param stacks Pointer to the TwoStacks structure
 * @return The popped item, or INT_MIN if stack 2 is empty
 */
int popFromStack2(TwoStacks *stacks) {
    if (isStack2Empty(stacks)) {
        printf("Stack 2 Underflow! Cannot pop from an empty stack\n");
        return INT_MIN;
    }
    
    return stacks->items[stacks->top2++];
}

/**
 * Peek at the top item of stack 1 without removing it
 * 
 * @param stacks Pointer to the TwoStacks structure
 * @return The top item of stack 1, or INT_MIN if stack 1 is empty
 */
int peekStack1(TwoStacks *stacks) {
    if (isStack1Empty(stacks)) {
        printf("Stack 1 is empty! Cannot peek\n");
        return INT_MIN;
    }
    
    return stacks->items[stacks->top1];
}

/**
 * Peek at the top item of stack 2 without removing it
 * 
 * @param stacks Pointer to the TwoStacks structure
 * @return The top item of stack 2, or INT_MIN if stack 2 is empty
 */
int peekStack2(TwoStacks *stacks) {
    if (isStack2Empty(stacks)) {
        printf("Stack 2 is empty! Cannot peek\n");
        return INT_MIN;
    }
    
    return stacks->items[stacks->top2];
}

/**
 * Get the size of stack 1
 * 
 * @param stacks Pointer to the TwoStacks structure
 * @return The number of elements in stack 1
 */
int sizeOfStack1(TwoStacks *stacks) {
    return stacks->top1 + 1;
}

/**
 * Get the size of stack 2
 * 
 * @param stacks Pointer to the TwoStacks structure
 * @return The number of elements in stack 2
 */
int sizeOfStack2(TwoStacks *stacks) {
    return MAX_SIZE - stacks->top2;
}

/**
 * Print the contents of stack 1
 * 
 * @param stacks Pointer to the TwoStacks structure
 */
void printStack1(TwoStacks *stacks) {
    if (isStack1Empty(stacks)) {
        printf("Stack 1 is empty\n");
        return;
    }
    
    printf("Stack 1 contents: ");
    for (int i = 0; i <= stacks->top1; i++) {
        printf("%d ", stacks->items[i]);
    }
    printf("\n");
}

/**
 * Print the contents of stack 2
 * 
 * @param stacks Pointer to the TwoStacks structure
 */
void printStack2(TwoStacks *stacks) {
    if (isStack2Empty(stacks)) {
        printf("Stack 2 is empty\n");
        return;
    }
    
    printf("Stack 2 contents: ");
    for (int i = MAX_SIZE - 1; i >= stacks->top2; i--) {
        printf("%d ", stacks->items[i]);
    }
    printf("\n");
}

int main() {
    TwoStacks stacks;
    initTwoStacks(&stacks);
    
    printf("Two Stacks in an Array Demonstration:\n\n");
    
    // Push elements to stack 1
    printf("1. Pushing elements to Stack 1:\n");
    pushToStack1(&stacks, 10);
    pushToStack1(&stacks, 20);
    pushToStack1(&stacks, 30);
    printStack1(&stacks);
    
    // Push elements to stack 2
    printf("\n2. Pushing elements to Stack 2:\n");
    pushToStack2(&stacks, 100);
    pushToStack2(&stacks, 200);
    pushToStack2(&stacks, 300);
    printStack2(&stacks);
    
    // Peek operations
    printf("\n3. Peek operations:\n");
    printf("Top element of Stack 1: %d\n", peekStack1(&stacks));
    printf("Top element of Stack 2: %d\n", peekStack2(&stacks));
    
    // Pop operations
    printf("\n4. Pop operations:\n");
    printf("Popped from Stack 1: %d\n", popFromStack1(&stacks));
    printf("Popped from Stack 2: %d\n", popFromStack2(&stacks));
    
    // Print stacks after pop
    printf("\n5. Stacks after pop operations:\n");
    printStack1(&stacks);
    printStack2(&stacks);
    
    // Get sizes
    printf("\n6. Stack sizes:\n");
    printf("Size of Stack 1: %d\n", sizeOfStack1(&stacks));
    printf("Size of Stack 2: %d\n", sizeOfStack2(&stacks));
    
    // Test stack limits
    printf("\n7. Testing stack limits:\n");
    
    // Fill the array with elements from both stacks
    printf("Filling the array with elements from both stacks...\n");
    for (int i = 0; i < 45; i++) {
        pushToStack1(&stacks, i + 40);
    }
    
    for (int i = 0; i < 45; i++) {
        pushToStack2(&stacks, i + 400);
    }
    
    // Try to push when array is full
    printf("\nTrying to push when array is full:\n");
    pushToStack1(&stacks, 999);
    pushToStack2(&stacks, 999);
    
    // Empty both stacks
    printf("\n8. Emptying both stacks:\n");
    printf("Emptying Stack 1...\n");
    while (!isStack1Empty(&stacks)) {
        popFromStack1(&stacks);
    }
    
    printf("Emptying Stack 2...\n");
    while (!isStack2Empty(&stacks)) {
        popFromStack2(&stacks);
    }
    
    // Try to pop from empty stacks
    printf("\n9. Trying to pop from empty stacks:\n");
    popFromStack1(&stacks);
    popFromStack2(&stacks);
    
    return 0;
}