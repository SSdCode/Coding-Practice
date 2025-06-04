/**
 * Stack Implementation using Linked List in C
 * 
 * This program demonstrates how to implement a stack data structure
 * using a linked list in C.
 * 
 * Time Complexity: O(1) for push, pop, and peek operations
 * Space Complexity: O(n) where n is the number of elements in the stack
 */

#include <stdio.h>
#include <stdlib.h>
#include <stdbool.h>
#include <limits.h>

// Node structure for the linked list
typedef struct Node {
    int data;
    struct Node* next;
} Node;

// Stack structure
typedef struct {
    Node* top;
    int size;
} Stack;

/**
 * Create a new node
 * 
 * @param data The data to store in the node
 * @return Pointer to the new node, or NULL if memory allocation failed
 */
Node* createNode(int data) {
    Node* newNode = (Node*)malloc(sizeof(Node));
    if (newNode == NULL) {
        printf("Memory allocation failed!\n");
        return NULL;
    }
    
    newNode->data = data;
    newNode->next = NULL;
    return newNode;
}

/**
 * Initialize a new stack
 * 
 * @param stack Pointer to the stack to initialize
 */
void initStack(Stack* stack) {
    stack->top = NULL;
    stack->size = 0;
}

/**
 * Check if the stack is empty
 * 
 * @param stack Pointer to the stack
 * @return true if the stack is empty, false otherwise
 */
bool isEmpty(Stack* stack) {
    return stack->top == NULL;
}

/**
 * Push an item onto the stack
 * 
 * @param stack Pointer to the stack
 * @param data The data to push
 * @return true if the operation was successful, false if memory allocation failed
 */
bool push(Stack* stack, int data) {
    Node* newNode = createNode(data);
    if (newNode == NULL) {
        return false;
    }
    
    newNode->next = stack->top;
    stack->top = newNode;
    stack->size++;
    return true;
}

/**
 * Pop an item from the stack
 * 
 * @param stack Pointer to the stack
 * @return The popped item, or INT_MIN if the stack is empty
 */
int pop(Stack* stack) {
    if (isEmpty(stack)) {
        printf("Stack Underflow! Cannot pop from an empty stack\n");
        return INT_MIN;
    }
    
    Node* temp = stack->top;
    int poppedData = temp->data;
    
    stack->top = stack->top->next;
    free(temp);
    stack->size--;
    
    return poppedData;
}

/**
 * Peek at the top item without removing it
 * 
 * @param stack Pointer to the stack
 * @return The top item, or INT_MIN if the stack is empty
 */
int peek(Stack* stack) {
    if (isEmpty(stack)) {
        printf("Stack is empty! Cannot peek\n");
        return INT_MIN;
    }
    
    return stack->top->data;
}

/**
 * Get the size of the stack
 * 
 * @param stack Pointer to the stack
 * @return The number of elements in the stack
 */
int size(Stack* stack) {
    return stack->size;
}

/**
 * Print the contents of the stack
 * 
 * @param stack Pointer to the stack
 */
void printStack(Stack* stack) {
    if (isEmpty(stack)) {
        printf("Stack is empty\n");
        return;
    }
    
    printf("Stack contents (top to bottom): ");
    Node* current = stack->top;
    while (current != NULL) {
        printf("%d ", current->data);
        current = current->next;
    }
    printf("\n");
}

/**
 * Free all memory used by the stack
 * 
 * @param stack Pointer to the stack
 */
void freeStack(Stack* stack) {
    Node* current = stack->top;
    Node* next;
    
    while (current != NULL) {
        next = current->next;
        free(current);
        current = next;
    }
    
    stack->top = NULL;
    stack->size = 0;
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
    
    // Clean up
    freeStack(&stack);
    
    return 0;
}