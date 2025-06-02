#include <stdio.h>
#include <ctype.h>

void countVowelsAndConsonants(const char *str) {
    int vowels = 0, consonants = 0;
    
    while (*str) {
        char ch = tolower(*str);
        if (isalpha(ch)) {
            if (ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u') {
                vowels++;
            } else {
                consonants++;
            }
        }
        str++;
    }
    
    printf("Vowels: %d\nConsonants: %d\n", vowels, consonants);
}

int main() {
    char str[] = "Hello World";
    printf("String: %s\n", str);
    countVowelsAndConsonants(str);
    return 0;
}