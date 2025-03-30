#include <stdio.h>

int main() {
    int i, mCount = 0;
    int arr[5] = {50,0,2,0,90};

    for (int i = 0; i < 5; i++)
    {
        if (arr[i] != 0)
        {
            arr[mCount++] = arr[i];
        }
        
    }

    while (mCount < 5)
    {
        arr[mCount++] = 0;
    }
    

    printf("Now array elements are: ");
    for (i = 0; i < 5; i++) {
        printf("%d ", arr[i]);
    }
    printf("\n\n");
    return 0;
}