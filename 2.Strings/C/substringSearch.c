#include <stdio.h>
#include <string.h>

char* myStrStr(const char* haystack, const char* needle) {
    if (*needle == '\0') return (char*)haystack;
    
    for (int i = 0; haystack[i] != '\0'; i++) {
        int j;
        
        // Check if current position matches the needle
        for (j = 0; needle[j] != '\0'; j++) {
            if (haystack[i + j] != needle[j])
                break;
        }
        
        // If we reached the end of needle, we found a match
        if (needle[j] == '\0')
            return (char*)&haystack[i];
    }
    
    return NULL;
}

int main() {
    const char* haystack = "hello world";
    const char* needle = "world";
    
    printf("Haystack: %s\nNeedle: %s\n", haystack, needle);
    
    char* result = myStrStr(haystack, needle);
    if (result != NULL) {
        printf("Found at position: %ld\n", result - haystack);
    } else {
        printf("Substring not found\n");
    }
    
    return 0;
}