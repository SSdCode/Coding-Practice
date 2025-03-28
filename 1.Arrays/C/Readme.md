## 📌 **What is an Array in C?**
An **array** is a collection of elements of the **same data type** stored in **contiguous memory locations**.

### **Why Use Arrays?**
✅ To store multiple values of the same type.  
✅ To access elements using an index efficiently.  
✅ To avoid creating multiple separate variables.

---

## 📌 **Types of Arrays in C**
### **1️⃣ One-Dimensional Array**
💡 A list of elements stored in a **single row**.

#### **Declaration & Initialization**
```c
int arr[5];  // Declaring an array of size 5
int arr[] = {10, 20, 30, 40, 50}; // Initialization
int arr[5] = {10, 20, 30};  // Partial initialization (rest = 0)
```

#### **Accessing Elements**
```c
printf("%d", arr[2]);  // Accessing the 3rd element (index starts from 0)
```

#### **Input and Output Example**
```c
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
    
    return 0;
}
```

---

### **2️⃣ Two-Dimensional (2D) Arrays**
💡 A matrix-like structure where elements are stored in **rows and columns**.

#### **Declaration & Initialization**
```c
int matrix[3][3];  // Declaring a 3x3 matrix
int matrix[2][3] = {{1, 2, 3}, {4, 5, 6}};  // Initialization
```

#### **Accessing Elements**
```c
printf("%d", matrix[1][2]);  // Accessing element at row 1, column 2
```

#### **Input and Output Example**
```c
#include <stdio.h>
int main() {
    int matrix[2][2], i, j;

    // Input
    printf("Enter 4 values for a 2x2 matrix:\n");
    for (i = 0; i < 2; i++) {
        for (j = 0; j < 2; j++) {
            scanf("%d", &matrix[i][j]);
        }
    }

    // Output
    printf("Matrix elements:\n");
    for (i = 0; i < 2; i++) {
        for (j = 0; j < 2; j++) {
            printf("%d ", matrix[i][j]);
        }
        printf("\n");
    }

    return 0;
}
```

---

### **3️⃣ Multi-Dimensional Arrays**
💡 Arrays with more than two dimensions (e.g., **3D arrays** for 3D matrices).

#### **Declaration**
```c
int arr[2][3][4];  // 2 blocks, 3 rows, 4 columns
```

#### **Accessing Elements**
```c
arr[1][2][3] = 10;  // Assigning value to a specific index
```

---

## 📌 **Array Operations**
### **🔹 Traversing an Array**
Looping through all elements.
```c
for (int i = 0; i < size; i++) {
    printf("%d ", arr[i]);
}
```

### **🔹 Searching in an Array**
Checking if an element exists.
```c
int search(int arr[], int size, int key) {
    for (int i = 0; i < size; i++) {
        if (arr[i] == key) return i;  // Return index if found
    }
    return -1;  // Return -1 if not found
}
```

### **🔹 Sorting an Array**
Example using **Bubble Sort**:
```c
void bubbleSort(int arr[], int n) {
    for (int i = 0; i < n - 1; i++) {
        for (int j = 0; j < n - i - 1; j++) {
            if (arr[j] > arr[j + 1]) {
                int temp = arr[j];
                arr[j] = arr[j + 1];
                arr[j + 1] = temp;
            }
        }
    }
}
```

### **🔹 Copying an Array**
```c
void copyArray(int src[], int dest[], int size) {
    for (int i = 0; i < size; i++) {
        dest[i] = src[i];
    }
}
```

### **🔹 Reversing an Array**
```c
void reverseArray(int arr[], int size) {
    for (int i = 0, j = size - 1; i < j; i++, j--) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
```

---

## 📌 **Pointers and Arrays**
### **Arrays and Pointers Relationship**
An array name is a **pointer** to the first element.
```c
int arr[5] = {1, 2, 3, 4, 5};
int *ptr = arr;  // Pointer to first element

printf("%d", *(ptr + 2));  // Prints arr[2]
```

---

## 📌 **Dynamic Arrays (Using malloc)**
When you don't know the size at compile time, use **dynamic memory allocation**.
```c
#include <stdio.h>
#include <stdlib.h>

int main() {
    int *arr, size, i;

    printf("Enter size: ");
    scanf("%d", &size);

    arr = (int *)malloc(size * sizeof(int)); // Allocate memory

    printf("Enter %d elements:\n", size);
    for (i = 0; i < size; i++) {
        scanf("%d", &arr[i]);
    }

    printf("Elements are: ");
    for (i = 0; i < size; i++) {
        printf("%d ", arr[i]);
    }

    free(arr); // Free memory
    return 0;
}
```

---

## 📌 **Common Mistakes with Arrays**
🚨 **Out of Bounds Access:**  
```c
int arr[5];
arr[5] = 10;  // ❌ Index 5 is out of bounds (Valid indexes: 0-4)
```

🚨 **Forgetting to Free Memory (for dynamic arrays):**  
```c
int *arr = malloc(10 * sizeof(int));
// Do some work...
free(arr);  // ✅ Always free allocated memory!
```

🚨 **Mixing Pointers and Arrays Without Understanding:**  
```c
int arr[5];
int *p = arr;
p++;  // ✅ Moves to the next element
```

---

## 🔥 **Final Recap**
| Concept                  | Example |
|--------------------------|---------|
| **1D Arrays**            | `int arr[5];` |
| **2D Arrays**            | `int matrix[2][2];` |
| **Looping Through Arrays** | `for (i = 0; i < size; i++)` |
| **Pointer and Arrays**   | `int *ptr = arr;` |
| **Dynamic Arrays**       | `malloc(), free()` |
| **Sorting**              | `Bubble Sort` |
| **Searching**            | `Linear Search` |

---


********************************************************************************************************************************************************************************

### 🔥 **Multi-Dimensional Arrays in C (3D Arrays Explained in Detail)**  

A **multi-dimensional array** is an extension of a 2D array, where elements are arranged in multiple layers (or "blocks").  
A **3D array** can be visualized as a collection of 2D matrices stacked on top of each other.

---

## 📌 **What is a 3D Array?**
A **3D array** consists of **blocks**, **rows**, and **columns**, just like a book has **pages**, **rows of text**, and **words in each row**.

For example:
```c
int arr[2][3][4];  // 3D array with 2 blocks, 3 rows, and 4 columns
```
🔹 **Here’s what this means:**
- **2 blocks (or layers)** → Like having two pages in a book.
- **3 rows in each block** → Like having three lines of text on each page.
- **4 columns in each row** → Like four words in each line.

---

## 📌 **How is a 3D Array Stored in Memory?**
In **row-major order**, elements are stored **block by block**, **row by row**, and **column by column** in **contiguous memory**.

🔹 **Memory layout for** `arr[2][3][4]`:
```
Block 0:
Row 0: arr[0][0][0] arr[0][0][1] arr[0][0][2] arr[0][0][3]
Row 1: arr[0][1][0] arr[0][1][1] arr[0][1][2] arr[0][1][3]
Row 2: arr[0][2][0] arr[0][2][1] arr[0][2][2] arr[0][2][3]

Block 1:
Row 0: arr[1][0][0] arr[1][0][1] arr[1][0][2] arr[1][0][3]
Row 1: arr[1][1][0] arr[1][1][1] arr[1][1][2] arr[1][1][3]
Row 2: arr[1][2][0] arr[1][2][1] arr[1][2][2] arr[1][2][3]
```

---

## 📌 **Initializing a 3D Array**
There are different ways to initialize a 3D array.

### **1️⃣ Default Initialization**
```c
int arr[2][3][4] = {0};  // Initializes all elements to 0
```

### **2️⃣ Partial Initialization**
```c
int arr[2][3][4] = {
    {
        {1, 2, 3, 4},
        {5, 6, 7, 8},
        {9, 10, 11, 12}
    },
    {
        {13, 14, 15, 16},
        {17, 18, 19, 20},
        {21, 22, 23, 24}
    }
};
```
This initializes:
- **Block 0** → First 3 rows with 4 values each.
- **Block 1** → Next 3 rows with 4 values each.

---

## 📌 **Accessing Elements in a 3D Array**
Use **three indices** `[block][row][column]` to access an element.

```c
arr[1][2][3] = 10;  // Assign value 10 to block 1, row 2, column 3
printf("%d", arr[1][2][3]);  // Prints: 10
```
📌 **Breaking it down:**
- `arr[1]` → **Selects Block 1** (second block).
- `arr[1][2]` → **Selects Row 2** (third row inside block 1).
- `arr[1][2][3]` → **Selects Column 3** (fourth element in row 2 of block 1).

---

## 📌 **Looping Through a 3D Array**
We need **three nested loops** to traverse all elements.

```c
#include <stdio.h>

int main() {
    int arr[2][3][4] = {
        {
            {1, 2, 3, 4},
            {5, 6, 7, 8},
            {9, 10, 11, 12}
        },
        {
            {13, 14, 15, 16},
            {17, 18, 19, 20},
            {21, 22, 23, 24}
        }
    };

    // Traverse the 3D array
    for (int i = 0; i < 2; i++) {  // Blocks
        printf("\nBlock %d:\n", i);
        for (int j = 0; j < 3; j++) {  // Rows
            for (int k = 0; k < 4; k++) {  // Columns
                printf("%d ", arr[i][j][k]);
            }
            printf("\n");
        }
    }

    return 0;
}
```
✅ **Output:**
```
Block 0:
1 2 3 4
5 6 7 8
9 10 11 12

Block 1:
13 14 15 16
17 18 19 20
21 22 23 24
```

---

## 📌 **Dynamic Memory Allocation for 3D Arrays**
When you don’t know the size of the array at compile time, use **malloc()**.

```c
#include <stdio.h>
#include <stdlib.h>

int main() {
    int ***arr;
    int i, j, k;
    int x = 2, y = 3, z = 4;  // 2 blocks, 3 rows, 4 columns

    // Allocating memory
    arr = (int ***)malloc(x * sizeof(int **));
    for (i = 0; i < x; i++) {
        arr[i] = (int **)malloc(y * sizeof(int *));
        for (j = 0; j < y; j++) {
            arr[i][j] = (int *)malloc(z * sizeof(int));
        }
    }

    // Assigning values
    for (i = 0; i < x; i++) {
        for (j = 0; j < y; j++) {
            for (k = 0; k < z; k++) {
                arr[i][j][k] = i + j + k;  // Example assignment
            }
        }
    }

    // Printing values
    printf("3D Array Values:\n");
    for (i = 0; i < x; i++) {
        for (j = 0; j < y; j++) {
            for (k = 0; k < z; k++) {
                printf("%d ", arr[i][j][k]);
            }
            printf("\n");
        }
        printf("\n");
    }

    // Freeing allocated memory
    for (i = 0; i < x; i++) {
        for (j = 0; j < y; j++) {
            free(arr[i][j]);
        }
        free(arr[i]);
    }
    free(arr);

    return 0;
}
```
✅ **Output (Example values):**
```
3D Array Values:
0 1 2 3
1 2 3 4
2 3 4 5

1 2 3 4
2 3 4 5
3 4 5 6
```

---

## 📌 **Real-World Applications of 3D Arrays**
🔹 **Graphics Processing** (3D images, voxels)  
🔹 **Machine Learning** (storing multiple datasets)  
🔹 **Game Development** (3D maps, game worlds)  
🔹 **Medical Imaging** (CT scans, MRI scans)  

---

## 🔥 **Final Recap**
| **Concept**              | **Example** |
|--------------------------|------------|
| **Declaring a 3D Array** | `int arr[2][3][4];` |
| **Initializing a 3D Array** | `{{{1,2,3},{4,5,6}},{{7,8,9},{10,11,12}}}` |
| **Accessing Elements** | `arr[1][2][3] = 10;` |
| **Looping Through 3D Arrays** | `for (i=0;i<blocks;i++) for (j=0;j<rows;j++) for (k=0;k<cols;k++)` |
| **Dynamic Allocation** | `malloc() and free()` |


****************************************************************************************************************************************************************

### 🔍 **How to Get the Length of an Array in C? (`arr.length` Equivalent)**
Unlike Java or Python, **C does not have a built-in `arr.length` property** to get the size of an array. Instead, you have to calculate it manually.

---

## **1️⃣ Finding the Length of a 1D Array**
You can use the **`sizeof` operator** to determine the number of elements.

### 🔹 **Formula:**
```c
length = sizeof(arr) / sizeof(arr[0]);
```
🔸 `sizeof(arr)`: Total memory occupied by the array.  
🔸 `sizeof(arr[0])`: Memory occupied by one element.

### ✅ **Example:**
```c
#include <stdio.h>

int main() {
    int arr[] = {10, 20, 30, 40, 50};
    int length = sizeof(arr) / sizeof(arr[0]);

    printf("Length of array: %d\n", length);
    return 0;
}
```
**🟢 Output:**
```
Length of array: 5
```

⚠️ **Important:** This only works **inside the same function** where the array is declared. If passed to another function, `sizeof(arr)` won't work because arrays decay into pointers.

---

## **2️⃣ Finding the Length of a 2D Array**
For a **2D array**, you need to divide the total size by the size of one **row** or **element**.

### ✅ **Example:**
```c
#include <stdio.h>

int main() {
    int arr[3][4] = {
        {1, 2, 3, 4},
        {5, 6, 7, 8},
        {9, 10, 11, 12}
    };

    int rows = sizeof(arr) / sizeof(arr[0]);    // Number of rows
    int cols = sizeof(arr[0]) / sizeof(arr[0][0]);  // Number of columns

    printf("Rows: %d, Columns: %d\n", rows, cols);
    return 0;
}
```
**🟢 Output:**
```
Rows: 3, Columns: 4
```


## **🚀 Summary**
| **Scenario**            | **Solution** |
|-------------------------|-------------|
| **1D array (static)** | `sizeof(arr) / sizeof(arr[0])` |
| **2D array (static)** | `sizeof(arr) / sizeof(arr[0])` (rows) <br> `sizeof(arr[0]) / sizeof(arr[0][0])` (cols) |
| **Passed to a function** | Pass size explicitly as a parameter |
| **Dynamic arrays (`malloc`)** | Track size manually |
