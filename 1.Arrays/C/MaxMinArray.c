#include<stdio.h>

// Find Maximum and Minimum in an Array
int main(){
    int arr[5] = {50,10,2,40,90};
    int max = arr[0], min = arr[0];
    for (int i = 0; i < 5; i++)
    {
        if (arr[i] > max){
            max = arr[i];
        }
        if (arr[i] < min){
            min = arr[i];
        }        
    }
    printf("\n Max = %d \n Min = %d",max,min);
    return 0;
}