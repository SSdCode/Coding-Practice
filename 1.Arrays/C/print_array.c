#include <stdio.h>

int main() {
    int arr[5], i;

    // Input values
    printf("Enter 5 numbers:\n");
    for (i = 0; i < 5; i++) {
        scanf("%d", &arr[i]);
    }

    // Print values
    printf("Array elements are: ");
    for (i = 0; i < 5; i++) {
        printf("%d ", arr[i]);
    }
    printf("\n\n");
    return 0;
}