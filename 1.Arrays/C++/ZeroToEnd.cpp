#include<iostream>

int main(){
    int arr[5] = {20,0,60,0,8};
    int count = 0;
    
    for (int i = 0; i < 5; i++)
    {
        if (arr[i] != 0)
        {
            arr[count++] = arr[i];
        }
    }

    while (count < 5){
        arr[count++] = 0;
    }    
    
    printf("Now array elements are: ");
    for (int i = 0; i < 5; i++) {
        printf("%d ", arr[i]);
    }
    return 0;
}