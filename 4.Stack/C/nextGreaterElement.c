/**
 * Next Greater Element using Stack in C
 * 
 * This program demonstrates how to find the next greater element for each element
 * in an array using a stack.
 * 
 * Time Complexity: O(n) where n is the size of the array
 * Space Complexity: O(n) for the stack and result array
 */

#include <stdio.h>
#include <stdlib.h>
#include <stdbool.h>

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
 * @return The popped item, or -1 if the stack is empty
 */
int pop(Stack *stack) {
    if (isEmpty(stack)) {
        return -1; // Error value
    }
    
    return stack->items[stack->top--];
}

/**
 * Peek at the top item without removing it
 * 
 * @param stack Pointer to the stack
 * @return The top item, or -1 if the stack is empty
 */
int peek(Stack *stack) {
    if (isEmpty(stack)) {
        return -1; // Error value
    }
    
    return stack->items[stack->top];
}

/**
 * Find the next greater element for each element in the array
 * 
 * @param arr The input array
 * @param n The size of the array
 * @param result Array to store the results
 */
void nextGreaterElement(int arr[], int n, int result[]) {
    Stack stack;
    initStack(&stack);
    
    // Initialize result array with -1 (no greater element)
    for (int i = 0; i < n; i++) {
        result[i] = -1;
    }
    
    // Process all elements from right to left
    for (int i = n - 1; i >= 0; i--) {
        // Remove elements smaller than current element
        while (!isEmpty(&stack) && peek(&stack) <= arr[i]) {
            pop(&stack);
        }
        
        // If stack is not empty, top element is the next greater element
        if (!isEmpty(&stack)) {
            result[i] = peek(&stack);
        }
        
        // Push current element to stack
        push(&stack, arr[i]);
    }
}

/**
 * Alternative approach: Find the next greater element for each element in the array
 * Processing elements from left to right
 * 
 * @param arr The input array
 * @param n The size of the array
 * @param result Array to store the results
 */
void nextGreaterElementLeftToRight(int arr[], int n, int result[]) {
    Stack stack;
    initStack(&stack);
    
    // Initialize result array with -1 (no greater element)
    for (int i = 0; i < n; i++) {
        result[i] = -1;
    }
    
    // Process all elements from left to right
    for (int i = 0; i < n; i++) {
        // For all elements on stack smaller than current element,
        // current element is their next greater element
        while (!isEmpty(&stack) && arr[peek(&stack)] < arr[i]) {
            result[pop(&stack)] = arr[i];
        }
        
        // Push current element's index to stack
        push(&stack, i);
    }
}

/**
 * Print an array
 * 
 * @param arr The array to print
 * @param n The size of the array
 */
void printArray(int arr[], int n) {
    for (int i = 0; i < n; i++) {
        printf("%d ", arr[i]);
    }
    printf("\n");
}

int main() {
    int arr1[] = {4, 5, 2, 25, 7, 8};
    int n1 = sizeof(arr1) / sizeof(arr1[0]);
    int result1[n1];
    
    printf("Example 1:\n");
    printf("Array: ");
    printArray(arr1, n1);
    
    nextGreaterElement(arr1, n1, result1);
    
    printf("Next Greater Elements (right to left approach): ");
    printArray(result1, n1);
    
    // Reset result array
    for (int i = 0; i < n1; i++) {
        result1[i] = -1;
    }
    
    nextGreaterElementLeftToRight(arr1, n1, result1);
    
    printf("Next Greater Elements (left to right approach): ");
    printArray(result1, n1);
    
    // Example 2: Array with duplicate elements
    int arr2[] = {11, 13, 21, 3, 4, 6, 8, 8, 11, 12};
    int n2 = sizeof(arr2) / sizeof(arr2[0]);
    int result2[n2];
    
    printf("\nExample 2:\n");
    printf("Array: ");
    printArray(arr2, n2);
    
    nextGreaterElement(arr2, n2, result2);
    
    printf("Next Greater Elements: ");
    printArray(result2, n2);
    
    // Example 3: Array in descending order (no next greater elements)
    int arr3[] = {5, 4, 3, 2, 1};
    int n3 = sizeof(arr3) / sizeof(arr3[0]);
    int result3[n3];
    
    printf("\nExample 3:\n");
    printf("Array: ");
    printArray(arr3, n3);
    
    nextGreaterElement(arr3, n3, result3);
    
    printf("Next Greater Elements: ");
    printArray(result3, n3);
    
    return 0;
}