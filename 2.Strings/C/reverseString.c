/**
 * Reverse String Program
 * 
 * This program demonstrates how to reverse a string by printing its characters
 * in reverse order. It uses a character array and iterates from the end to the beginning.
 * 
 * Algorithm:
 * 1. Define a character array with the input string
 * 2. Iterate through the array from the last character to the first
 * 3. Print each character during iteration
 * 
 * Time Complexity: O(n) where n is the length of the string
 * Space Complexity: O(1) as we only use the original array
 * 
 * Input: A hardcoded character array - {'s','a','m','i','r'}
 * Output: The reversed string - "rimas"
 */

#include <stdio.h>
#include <string.h>  // For strlen function

/**
 * reverseAndPrint - Reverses and prints a character array
 * @str: The character array to reverse and print
 * @length: The length of the character array
 */
void reverseAndPrint(char str[], int length) {
    printf("Original string: ");
    for (int i = 0; i < length; i++) {
        printf("%c", str[i]);
    }
    printf("\n");
    
    printf("Reversed string: ");
    // Iterate from the end to the beginning
    for (int i = length - 1; i >= 0; i--) {
        printf("%c", str[i]);
    }
    printf("\n");
}

int main() {
    // Define the input character array
    char myName[] = {'s', 'a', 'm', 'i', 'r'};
    int length = sizeof(myName) / sizeof(myName[0]);
    
    // Call the function to reverse and print the string
    reverseAndPrint(myName, length);
    
    // Alternative approach with a null-terminated string
    char myNameStr[] = "samir";
    printf("\nAlternative approach with null-terminated string:\n");
    printf("Original string: %s\n", myNameStr);
    
    printf("Reversed string: ");
    for (int i = strlen(myNameStr) - 1; i >= 0; i--) {
        printf("%c", myNameStr[i]);
    }
    printf("\n");
    
    return 0;
}