#include <stdio.h>
#include <string.h>
#include <stdlib.h>

char* longestCommonPrefix(char** strs, int strsSize) {
    if (strsSize == 0) return "";
    if (strsSize == 1) return strs[0];
    
    char* prefix = (char*)malloc(201); // Assuming max length of 200
    int index = 0;
    char curr;
    
    // Take first string's characters one by one
    while ((curr = strs[0][index]) != '\0') {
        // Check this character in all other strings
        for (int i = 1; i < strsSize; i++) {
            if (strs[i][index] != curr) {
                prefix[index] = '\0';
                return prefix;
            }
        }
        prefix[index] = curr;
        index++;
    }
    
    prefix[index] = '\0';
    return prefix;
}

int main() {
    char* strs[] = {"flower", "flow", "flight"};
    int size = 3;
    
    printf("Strings:\n");
    for (int i = 0; i < size; i++) {
        printf("%s\n", strs[i]);
    }
    
    char* result = longestCommonPrefix(strs, size);
    printf("Longest common prefix: %s\n", result);
    free(result);
    
    return 0;
}