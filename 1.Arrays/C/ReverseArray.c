#include<stdio.h>

int main(){
    int arr[5];

    printf("Enter five values: ");

    for (int i = 0; i < 5; i++)
    {
        scanf("%d",&arr[i]);
    }
    printf("\n");
    for (int i = 4; i >=0; i--)
    {
        printf("%d ",arr[i]);
    }
    printf("\n");
    return 0;
}