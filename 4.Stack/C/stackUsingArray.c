/**
 * Stack Implementation using Array in C
 * 
 * This program demonstrates how to implement a stack data structure
 * using a fixed-size array in C.
 * 
 * Time Complexity: O(1) for push, pop, and peek operations
 * Space Complexity: O(n) where n is the maximum size of the stack
 */

#include <stdio.h>
#include <stdlib.h>
#include <stdbool.h>
#include <limits.h>

#define MAX_SIZE 100

// Stack structure
typedef struct {
    int items[MAX_SIZE];
    int top;
} Stack;

/**
 * Initialize a new stack
 * 
 * @param stack Pointer to the stack to initialize
 */
void initStack(Stack *stack) {
    stack->top = -1;
}

/**
 * Check if the stack is empty
 * 
 * @param stack Pointer to the stack
 * @return true if the stack is empty, false otherwise
 */
bool isEmpty(Stack *stack) {
    return stack->top == -1;
}

/**
 * Check if the stack is full
 * 
 * @param stack Pointer to the stack
 * @return true if the stack is full, false otherwise
 */
bool isFull(Stack *stack) {
    return stack->top == MAX_SIZE - 1;
}

/**
 * Push an item onto the stack
 * 
 * @param stack Pointer to the stack
 * @param item The item to push
 * @return true if the operation was successful, false if the stack is full
 */
bool push(Stack *stack, int item) {
    if (isFull(stack)) {
        printf("Stack Overflow! Cannot push %d\n", item);
        return false;
    }
    
    stack->items[++stack->top] = item;
    return true;
}

/**
 * Pop an item from the stack
 * 
 * @param stack Pointer to the stack
 * @return The popped item, or INT_MIN if the stack is empty
 */
int pop(Stack *stack) {
    if (isEmpty(stack)) {
        printf("Stack Underflow! Cannot pop from an empty stack\n");
        return INT_MIN;
    }
    
    return stack->items[stack->top--];
}

/**
 * Peek at the top item without removing it
 * 
 * @param stack Pointer to the stack
 * @return The top item, or INT_MIN if the stack is empty
 */
int peek(Stack *stack) {
    if (isEmpty(stack)) {
        printf("Stack is empty! Cannot peek\n");
        return INT_MIN;
    }
    
    return stack->items[stack->top];
}

/**
 * Get the size of the stack
 * 
 * @param stack Pointer to the stack
 * @return The number of elements in the stack
 */
int size(Stack *stack) {
    return stack->top + 1;
}

/**
 * Print the contents of the stack
 * 
 * @param stack Pointer to the stack
 */
void printStack(Stack *stack) {
    if (isEmpty(stack)) {
        printf("Stack is empty\n");
        return;
    }
    
    printf("Stack contents: ");
    for (int i = 0; i <= stack->top; i++) {
        printf("%d ", stack->items[i]);
    }
    printf("\n");
}

int main() {
    Stack stack;
    initStack(&stack);
    
    printf("Stack operations demonstration:\n");
    printf("1. Push operations:\n");
    
    push(&stack, 10);
    push(&stack, 20);
    push(&stack, 30);
    push(&stack, 40);
    push(&stack, 50);
    
    printStack(&stack);
    
    printf("\n2. Peek operation: Top element is %d\n", peek(&stack));
    
    printf("\n3. Pop operations:\n");
    printf("Popped: %d\n", pop(&stack));
    printf("Popped: %d\n", pop(&stack));
    
    printf("\n4. After pop operations:\n");
    printStack(&stack);
    
    printf("\n5. Stack size: %d\n", size(&stack));
    
    printf("\n6. Testing stack limits:\n");
    // Try to pop from a stack until it's empty
    printf("Popping all elements:\n");
    while (!isEmpty(&stack)) {
        printf("Popped: %d\n", pop(&stack));
    }
    
    // Try to pop from an empty stack
    printf("\nTrying to pop from an empty stack:\n");
    pop(&stack);
    
    return 0;
}