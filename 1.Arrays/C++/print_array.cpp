#include<iostream>

int main(){

    int arr[5]={4,5,8,7,9};
    int length = sizeof(arr) / sizeof(arr[0]);
    for (int i = 0; i < length; i++)
    {
        std::cout<<arr[i]<<" ";
    }
    std::cout<<"\n\n";
    return 0;
}