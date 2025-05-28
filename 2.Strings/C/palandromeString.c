#include<stdio.h>
#include<string.h>

int main(){
    char myStr[] = "sdsddsds";
    char myStrTemp[9];
    int len = strlen(myStr);

    for (int i = 0; i < len; i++) {
        myStrTemp[i] = myStr[len - 1 - i];
    }
    myStrTemp[len] = '\0';

    if (strcmp(myStr, myStrTemp) == 0) {
        printf("String is palindrome.\n");
    } else {
        printf("String is not palindrome.\n");
    }

    return 0;
}