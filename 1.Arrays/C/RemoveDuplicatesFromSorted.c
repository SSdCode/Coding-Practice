#include <stdio.h>

// Method 1: Using a separate array
void removeDuplicatesSeparateArray(int arr[], int size, int mArr[], int *newSize) {
    int j = 0;
    mArr[0] = arr[0];

    for (int i = 1; i < size; i++) {
        if (mArr[j] != arr[i]) {
            mArr[++j] = arr[i];
        }
    }
    *newSize = j + 1;
}

// Method 2: In-place removal (modifies the original array)
int removeDuplicatesInPlace(int arr[], int n) {
    if (n == 0 || n == 1)
        return n;

    int j = 0;
    for (int i = 0; i < n - 1; i++) {
        if (arr[i] != arr[i + 1]) {
            arr[j++] = arr[i];
        }
    }
    arr[j++] = arr[n - 1]; // Add the last unique element

    return j; // New length of the array
}

// Function to print the array
void printArray(int arr[], int n) {
    for (int i = 0; i < n; i++) {
        printf("%d ", arr[i]);
    }
    printf("\n");
}

int main() {
    int choice;
    // int arr[] = {1, 1, 2, 2, 3, 4, 4, 5, 6, 6, 7};
    int arr[] = {1, 2};
    int n = sizeof(arr) / sizeof(arr[0]);

    printf("Choose the method to remove duplicates:\n");
    printf("1. Using a separate array\n");
    printf("2. In-place removal (modifies original array)\n");
    printf("Enter your choice (1 or 2): ");
    scanf("%d", &choice);

    printf("Original array: ");
    printArray(arr, n);

    if (choice == 1) {
        int mArr[n], newSize;
        removeDuplicatesSeparateArray(arr, n, mArr, &newSize);
        printf("Array after removing duplicates (Separate Array Method): ");
        printArray(mArr, newSize);
    } else if (choice == 2) {
        n = removeDuplicatesInPlace(arr, n);
        printf("Array after removing duplicates (In-Place Method): ");
        printArray(arr, n);
    } else {
        printf("Invalid choice! Please select either 1 or 2.\n");
    }

    return 0;
}
