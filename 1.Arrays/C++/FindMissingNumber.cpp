#include <iostream>

int main() {
    int arr[] = {1,3,2,4,6,7};
    int n = 7;
    int origionalsum = n * (n + 1) / 2;
    int actualSum = 0;

    for (int i = 0; i < 6; i++)
    {
        actualSum += arr[i];
    }
    
    std::cout<<"Missing number is "<< origionalsum-actualSum;

    return 0;
}