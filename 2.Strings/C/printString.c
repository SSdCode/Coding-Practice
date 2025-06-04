/**
 * Print String Program
 * 
 * This program demonstrates how to print a character array in C.
 * Note: This example has a potential issue as the character array is not null-terminated,
 * which can lead to undefined behavior when using %s format specifier.
 * 
 * In C, strings should be null-terminated (end with '\0') to be properly printed
 * with the %s format specifier. Without the null terminator, printf will continue
 * reading memory until it finds a null byte, which can cause unexpected output
 * or even program crashes.
 * 
 * Input: A character array - {'s','a','m','i','r'}
 * Expected Output: "My name is samir."
 * Actual Output: May include garbage characters or cause undefined behavior
 */

#include <stdio.h>

int main() {
    // Original approach - NOT null-terminated (potential issue)
    char myName[] = {'s','a','m','i','r'};
    
    // This may cause undefined behavior as myName is not null-terminated
    printf("Original (potentially unsafe): My name is %s.\n", myName);
    
    // Correct approach 1: Add null terminator to the array
    char myNameCorrect[] = {'s','a','m','i','r', '\0'};
    printf("Corrected with null terminator: My name is %s.\n", myNameCorrect);
    
    // Correct approach 2: Use string literal (automatically null-terminated)
    char myNameString[] = "samir";
    printf("Using string literal: My name is %s.\n", myNameString);
    
    // Correct approach 3: Print character by character
    printf("Printing character by character: My name is ");
    for (int i = 0; i < 5; i++) {
        printf("%c", myName[i]);
    }
    printf(".\n");
    
    return 0;
}