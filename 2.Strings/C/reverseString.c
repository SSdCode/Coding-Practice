#include<stdio.h>

int main(){
    char myName[] = {'s','a','m','i','r'};

    // printf("My name is %s.",myName);

    for (int i = 4; i >= 0; i--)
    {
        printf("%c",myName[i]);
    }
    

    return 0;
}