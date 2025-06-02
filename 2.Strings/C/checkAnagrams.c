#include <stdio.h>
#include <string.h>
#include <ctype.h>

#define MAX_CHARS 256

int areAnagrams(const char *str1, const char *str2) {
    int count[MAX_CHARS] = {0};
    
    // Count characters in first string
    for (int i = 0; str1[i]; i++) {
        count[tolower(str1[i])]++;
    }
    
    // Subtract count for second string
    for (int i = 0; str2[i]; i++) {
        count[tolower(str2[i])]--;
    }
    
    // Check if all counts are zero
    for (int i = 0; i < MAX_CHARS; i++) {
        if (count[i] != 0) {
            return 0;
        }
    }
    return 1;
}

int main() {
    char str1[] = "Listen";
    char str2[] = "Silent";
    
    printf("String 1: %s\nString 2: %s\n", str1, str2);
    if (areAnagrams(str1, str2)) {
        printf("The strings are anagrams.\n");
    } else {
        printf("The strings are not anagrams.\n");
    }
    
    return 0;
}