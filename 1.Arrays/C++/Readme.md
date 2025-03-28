# **🔹 1. What is an Array?**
An **array** is a collection of elements of the **same data type** stored in **contiguous memory locations**.

✅ **In C and C++**, arrays are **zero-indexed**, meaning the first element is at index `0`.

---

# **🔹 2. Declaring Arrays**
### **📌 C Syntax**
```c
int arr[5];  // Declaring an integer array of size 5
```
### **📌 C++ Syntax (Same as C)**
```cpp
int arr[5];  // Same declaration as in C
```
✅ **No difference between C and C++ in basic array declaration.**

---

# **🔹 3. Initializing Arrays**
### **📌 C Style Initialization**
```c
int arr1[5] = {1, 2, 3, 4, 5};  // Explicit initialization
int arr2[] = {10, 20, 30};      // Compiler infers size (3)
int arr3[5] = {1, 2};           // Partially initialized (rest are 0)
```

### **📌 C++ Style (Supports More Features)**
```cpp
int arr1[5] = {1, 2, 3, 4, 5};  // Same as C
int arr2[] = {10, 20, 30};      // Compiler infers size
int arr3[5] = {1, 2};           // Rest elements will be 0

// Modern C++ supports std::array (C++11)
#include <array>
std::array<int, 5> arr4 = {1, 2, 3, 4, 5};
```
✅ **C++ supports `std::array` from C++11, which is safer than raw arrays.**

---

# **🔹 4. Accessing Array Elements**
### **📌 C (Using Index)**
```c
printf("%d", arr1[2]);  // Access 3rd element
```

### **📌 C++ (Using Index & Range-Based Loop)**
```cpp
std::cout << arr1[2];  // Same as C

// Modern C++ (C++11) supports range-based for loops:
for (int x : arr1) {
    std::cout << x << " ";
}
```
✅ **C++ offers better ways to access arrays using `std::array` and `range-based for loops`.**

---

# **🔹 5. Multi-Dimensional Arrays**
### **📌 C and C++ Syntax**
```c
int arr[2][3] = { {1, 2, 3}, {4, 5, 6} };  // 2D Array
printf("%d", arr[1][2]);  // Accessing an element
```

```cpp
int arr[2][3] = { {1, 2, 3}, {4, 5, 6} };  
std::cout << arr[1][2];  // Same syntax in C++
```
✅ **C++ provides `std::vector` for dynamic multidimensional arrays.**

---

# **🔹 6. Passing Arrays to Functions**
### **📌 C Style**
```c
void printArray(int arr[], int size) {
    for (int i = 0; i < size; i++)
        printf("%d ", arr[i]);
}
```

### **📌 C++ Style**
```cpp
void printArray(int arr[], int size) {
    for (int i = 0; i < size; i++)
        std::cout << arr[i] << " ";
}
```
✅ **C++ also supports `std::vector` for easier array management.**

---

# **🔹 7. Dynamic Arrays (Heap Allocation)**
### **📌 C (Using `malloc`)**
```c
int *arr = (int*)malloc(5 * sizeof(int));  // Allocating 5 integers
free(arr);  // Free memory
```

### **📌 C++ (Using `new` & `delete`)**
```cpp
int *arr = new int[5];  // Allocating 5 integers
delete[] arr;  // Free memory
```
✅ **C++ supports `std::vector` for safer dynamic memory handling.**

---

# **🔹 8. `std::vector` (Alternative to Arrays in C++)**
Unlike C, C++ provides **`std::vector`**, which is a **dynamic array** with many useful features.

```cpp
#include <vector>

std::vector<int> v = {1, 2, 3, 4, 5};
v.push_back(6);  // Adds element
v.pop_back();    // Removes last element
std::cout << v.size();  // Get size
```
✅ **Use `std::vector` instead of raw arrays for safer memory management.**

---

# **🔹 9. Getting Array Length**
### **📌 C (Manual Calculation)**
```c
int arr[5] = {1, 2, 3, 4, 5};
int length = sizeof(arr) / sizeof(arr[0]);  // 5
```

### **📌 C++ (Same as C + `std::array`)**
```cpp
int arr[5] = {1, 2, 3, 4, 5};
int length = sizeof(arr) / sizeof(arr[0]);  // 5

#include <array>
std::array<int, 5> arr2 = {1, 2, 3, 4, 5};
int len = arr2.size();  // Safer method
```
✅ **C++ provides `std::array::size()`, which is safer than manual size calculation.**

---

# **🔹 10. Differences Between C and C++ Arrays**
| Feature           | C Arrays                 | C++ Arrays (`std::array` & `std::vector`) |
|------------------|-------------------------|--------------------------------------|
| **Size Fixed?**  | Yes (fixed at compile-time) | `std::vector` is dynamic |
| **Memory Safety?** | No (prone to buffer overflows) | `std::vector` prevents memory errors |
| **Easier Syntax?** | No (manual memory handling) | Yes (`std::vector` & `std::array` provide safer handling) |
| **Looping Methods** | Only `for` loops | Supports range-based loops |

---

## **🎯 Conclusion**
✅ **If you're writing modern C++, use `std::vector` instead of raw arrays!**  
✅ **For small, fixed-size arrays, use `std::array<int, N>` instead of C-style arrays.**  
✅ **For dynamic allocation, `new` and `delete` should be avoided in favor of `std::vector`.**  
