# 🚀 **Complete Revision of Arrays in Java**  

---

# **1️⃣ Declaring and Initializing Arrays**
In Java, arrays are **objects** and are stored in the **heap memory**.

### ✅ **Syntax:**
```java
dataType[] arrayName;  // Declaration (preferred)
dataType arrayName[];  // Also valid (C-style)
```

### ✅ **Example:**
```java
int[] numbers = new int[5];  // Allocates memory for 5 integers
```
---

# **2️⃣ Initializing an Array**
You can initialize an array in **two ways**:

### ✅ **(a) Default Initialization**
Java initializes array elements with **default values**:
| Data Type | Default Value |
|-----------|--------------|
| `int` | `0` |
| `double` | `0.0` |
| `boolean` | `false` |
| `String` (or any Object) | `null` |

```java
int[] arr = new int[3];   // {0, 0, 0}
boolean[] flags = new boolean[2];  // {false, false}
String[] words = new String[2];  // {null, null}
```

### ✅ **(b) Explicit Initialization**
```java
int[] arr = {10, 20, 30, 40, 50};   // Direct initialization
```
---

# **3️⃣ Accessing and Modifying Elements**
Array elements are accessed via **indexing** (starting from `0`).

### ✅ **Example:**
```java
int[] numbers = {5, 10, 15};

System.out.println(numbers[0]);  // Output: 5

numbers[1] = 50;  // Modify an element
System.out.println(numbers[1]);  // Output: 50
```
⚠ **Accessing an out-of-bounds index throws `ArrayIndexOutOfBoundsException`**.
```java
System.out.println(numbers[3]); // Error: Index 3 out of bounds
```

---

# **4️⃣ Finding the Length of an Array**
✅ **Use `.length` (not a method, it's a property!)**
```java
int[] arr = {1, 2, 3, 4, 5};
System.out.println(arr.length);  // Output: 5
```

For **2D arrays**:
```java
int[][] matrix = {
    {1, 2, 3},
    {4, 5, 6}
};

System.out.println(matrix.length);  // Rows: 2
System.out.println(matrix[0].length);  // Columns: 3
```

---

# **5️⃣ Iterating Over an Array**
### ✅ **(a) Using a `for` Loop**
```java
int[] arr = {10, 20, 30, 40};

for (int i = 0; i < arr.length; i++) {
    System.out.println(arr[i]);
}
```

### ✅ **(b) Using an Enhanced `for` Loop (For-Each)**
```java
for (int num : arr) {
    System.out.println(num);
}
```
---

# **6️⃣ Multi-Dimensional Arrays**
### ✅ **Declaring a 2D Array**
```java
int[][] matrix = new int[2][3];  // 2 rows, 3 columns
```

### ✅ **Initializing a 2D Array**
```java
int[][] matrix = {
    {1, 2, 3},
    {4, 5, 6}
};
```

### ✅ **Accessing Elements**
```java
System.out.println(matrix[1][2]);  // Output: 6
```

### ✅ **Iterating Over a 2D Array**
```java
for (int i = 0; i < matrix.length; i++) {  // Rows
    for (int j = 0; j < matrix[i].length; j++) {  // Columns
        System.out.print(matrix[i][j] + " ");
    }
    System.out.println();
}
```

---

# **7️⃣ Jagged Arrays (Irregular 2D Arrays)**
A **jagged array** has **variable column sizes** in each row.

### ✅ **Example:**
```java
int[][] jagged = {
    {1, 2},
    {3, 4, 5},
    {6}
};
```

### ✅ **Iterating Over a Jagged Array**
```java
for (int i = 0; i < jagged.length; i++) {
    for (int j = 0; j < jagged[i].length; j++) {
        System.out.print(jagged[i][j] + " ");
    }
    System.out.println();
}
```

---

# **8️⃣ Sorting an Array**
✅ **Using `Arrays.sort()`**
```java
import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        int[] arr = {5, 2, 8, 1, 3};
        Arrays.sort(arr);

        System.out.println(Arrays.toString(arr));  // Output: [1, 2, 3, 5, 8]
    }
}
```

---

# **9️⃣ Copying an Array**
✅ **Using `Arrays.copyOf()`**
```java
int[] arr = {1, 2, 3};
int[] copy = Arrays.copyOf(arr, arr.length);
```

✅ **Using `System.arraycopy()` (Efficient for large arrays)**
```java
int[] arr = {10, 20, 30, 40};
int[] newArr = new int[4];

System.arraycopy(arr, 0, newArr, 0, arr.length);
```

✅ **Using `.clone()`**
```java
int[] arr = {1, 2, 3};
int[] clonedArr = arr.clone();
```

---

# **🔟 Arrays vs. ArrayList**
| Feature | `Array` | `ArrayList` |
|---------|--------|------------|
| **Size** | Fixed | Dynamic |
| **Performance** | Fast | Slightly slower (resizing overhead) |
| **Storage Type** | Stores primitives & objects | Stores only objects |
| **Length Property** | `arr.length` | `list.size()` |

✅ **Using `ArrayList` Instead of an Array**
```java
import java.util.ArrayList;

ArrayList<Integer> list = new ArrayList<>();
list.add(10);
list.add(20);
System.out.println(list.get(1));  // Output: 20
```

---

# **🔷 Common Interview Questions**
✅ **Find the second largest number in an array**
```java
public class SecondLargest {
    public static void main(String[] args) {
        int[] arr = {10, 5, 20, 8};

        int largest = Integer.MIN_VALUE, secondLargest = Integer.MIN_VALUE;
        
        for (int num : arr) {
            if (num > largest) {
                secondLargest = largest;
                largest = num;
            } else if (num > secondLargest && num != largest) {
                secondLargest = num;
            }
        }

        System.out.println("Second Largest: " + secondLargest);
    }
}
```

✅ **Reverse an array**
```java
public class ReverseArray {
    public static void main(String[] args) {
        int[] arr = {10, 20, 30, 40};

        for (int i = arr.length - 1; i >= 0; i--) {
            System.out.print(arr[i] + " ");
        }
    }
}
```

---

# **🚀 Final Summary**
| Concept | Key Points |
|---------|-----------|
| **Declaration** | `int[] arr = new int[5];` |
| **Initialization** | `int[] arr = {1, 2, 3};` |
| **Accessing Elements** | `arr[0]` |
| **Finding Length** | `arr.length` |
| **Iterating** | `for` loop, `for-each` loop |
| **Sorting** | `Arrays.sort(arr);` |
| **Copying** | `Arrays.copyOf()`, `.clone()`, `System.arraycopy()` |
| **2D Arrays** | `int[][] matrix = new int[2][3];` |
| **Jagged Arrays** | Rows have different lengths |
| **Array vs. ArrayList** | Fixed size vs. dynamic size |

---
