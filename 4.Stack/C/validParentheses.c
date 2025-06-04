/**
 * Valid Parentheses Problem in C
 * 
 * This program checks if a string containing parentheses, brackets, and braces
 * is valid. A string is valid if:
 * 1. Open brackets must be closed by the same type of brackets.
 * 2. Open brackets must be closed in the correct order.
 * 3. Every close bracket has a corresponding open bracket of the same type.
 * 
 * Time Complexity: O(n) where n is the length of the string
 * Space Complexity: O(n) in the worst case
 */

#include <stdio.h>
#include <stdlib.h>
#include <stdbool.h>
#include <string.h>

#define MAX_SIZE 1000

// Stack structure
typedef struct {
    char items[MAX_SIZE];
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
bool push(Stack *stack, char item) {
    if (isFull(stack)) {
        printf("Stack Overflow! Cannot push %c\n", item);
        return false;
    }
    
    stack->items[++stack->top] = item;
    return true;
}

/**
 * Pop an item from the stack
 * 
 * @param stack Pointer to the stack
 * @return The popped item, or '\0' if the stack is empty
 */
char pop(Stack *stack) {
    if (isEmpty(stack)) {
        return '\0'; // Error value
    }
    
    return stack->items[stack->top--];
}

/**
 * Peek at the top item without removing it
 * 
 * @param stack Pointer to the stack
 * @return The top item, or '\0' if the stack is empty
 */
char peek(Stack *stack) {
    if (isEmpty(stack)) {
        return '\0'; // Error value
    }
    
    return stack->items[stack->top];
}

/**
 * Check if a string containing parentheses, brackets, and braces is valid
 * 
 * @param s The input string
 * @return true if the string is valid, false otherwise
 */
bool isValid(const char *s) {
    Stack stack;
    initStack(&stack);
    
    for (int i = 0; s[i] != '\0'; i++) {
        char current = s[i];
        
        // If current character is an opening bracket, push it to the stack
        if (current == '(' || current == '{' || current == '[') {
            push(&stack, current);
        }
        // If current character is a closing bracket
        else if (current == ')' || current == '}' || current == ']') {
            // If stack is empty, there's no matching opening bracket
            if (isEmpty(&stack)) {
                return false;
            }
            
            char top = pop(&stack);
            
            // Check if the popped opening bracket matches the current closing bracket
            if ((current == ')' && top != '(') ||
                (current == '}' && top != '{') ||
                (current == ']' && top != '[')) {
                return false;
            }
        }
    }
    
    // If stack is empty, all brackets are matched
    return isEmpty(&stack);
}

/**
 * Print the result of the validation
 * 
 * @param s The input string
 * @param result The validation result
 */
void printResult(const char *s, bool result) {
    printf("Input: \"%s\"\n", s);
    printf("Output: %s\n\n", result ? "true" : "false");
}

int main() {
    printf("Valid Parentheses Problem Demonstration:\n\n");
    
    // Test cases
    const char *test1 = "()";
    bool result1 = isValid(test1);
    printResult(test1, result1);
    
    const char *test2 = "()[]{}";
    bool result2 = isValid(test2);
    printResult(test2, result2);
    
    const char *test3 = "(]";
    bool result3 = isValid(test3);
    printResult(test3, result3);
    
    const char *test4 = "([)]";
    bool result4 = isValid(test4);
    printResult(test4, result4);
    
    const char *test5 = "{[]}";
    bool result5 = isValid(test5);
    printResult(test5, result5);
    
    const char *test6 = "";
    bool result6 = isValid(test6);
    printResult(test6, result6);
    
    const char *test7 = "{";
    bool result7 = isValid(test7);
    printResult(test7, result7);
    
    const char *test8 = "{[()]}";
    bool result8 = isValid(test8);
    printResult(test8, result8);
    
    const char *test9 = "{[()]()}";
    bool result9 = isValid(test9);
    printResult(test9, result9);
    
    return 0;
}