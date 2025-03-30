#include<iostream>

using namespace std;

int main(){
    int arr[5] = {10,6,70,89,3};

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