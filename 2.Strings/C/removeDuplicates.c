#include <stdio.h>
#include <string.h>

void removeDuplicates(char *str) {
    if (str == NULL)
        return;
    
    int len = strlen(str);
    if (len < 2)
        return;
    
    int tail = 1;
    
    for (int i = 1; i < len; i++) {
        int j;
        for (j = 0; j < tail; j++) {
            if (str[i] == str[j])
                break;
        }
        
        if (j == tail) {
            str[tail] = str[i];
            tail++;
        }
    }
    
    str[tail] = '\0';
}

int main() {
    char str[] = "programming";
    printf("Original string: %s\n", str);
    removeDuplicates(str);
    printf("After removing duplicates: %s\n", str);
    return 0;
}