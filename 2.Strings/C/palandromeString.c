/**
 * Palindrome String Checker
 * 
 * This program checks if a given string is a palindrome.
 * A palindrome is a string that reads the same backward as forward.
 * 
 * Algorithm:
 * 1. Create a reversed copy of the input string
 * 2. Compare the original string with its reversed version
 * 3. If they are identical, the string is a palindrome
 * 
 * Input: A hardcoded string "sdsddsds"
 * Output: Message indicating whether the string is a palindrome or not
 */

#include<stdio.h>
#include<string.h>

int main(){
    // Input string to check
    char myStr[] = "sdsddsds";
    
    // Temporary array to store the reversed string
    // Size is 9 to accommodate 8 characters plus null terminator
    char myStrTemp[9];
    
    // Get the length of the input string
    int len = strlen(myStr);

    // Create a reversed copy of the string
    for (int i = 0; i < len; i++) {
        myStrTemp[i] = myStr[len - 1 - i];
    }
    
    // Add null terminator to make it a valid C string
    myStrTemp[len] = '\0';

    // Compare original and reversed strings
    if (strcmp(myStr, myStrTemp) == 0) {
        printf("String is palindrome.\n");
    } else {
        printf("String is not palindrome.\n");
    }

    return 0;
}