# 🚀 **Arrays in Kotlin (with Java Comparison)**  

# **1️⃣ Declaring and Initializing Arrays**  
### **📌 Java Approach**
```java
int[] numbers = new int[5];  // Creates an array of size 5 (default values = 0)
int[] nums = {1, 2, 3, 4, 5};  // Direct initialization
```

### **📌 Kotlin Equivalent**
```kotlin
val numbers = Array(5) { 0 }   // Creates an array of size 5 with default values as 0
val nums = arrayOf(1, 2, 3, 4, 5)  // Direct initialization
```
✅ **In Kotlin, `arrayOf()` is used to create arrays easily.**  

---

# **2️⃣ Accessing and Modifying Elements**
### **📌 Java**
```java
int[] arr = {10, 20, 30};
System.out.println(arr[1]);  // Output: 20
arr[2] = 50;  
System.out.println(arr[2]);  // Output: 50
```

### **📌 Kotlin**
```kotlin
val arr = arrayOf(10, 20, 30)
println(arr[1])  // Output: 20

arr[2] = 50  
println(arr[2])  // Output: 50
```
✅ **Kotlin uses `[]` for accessing elements, just like Java.**

---

# **3️⃣ Finding the Length of an Array**
### **📌 Java**
```java
int[] arr = {1, 2, 3, 4, 5};
System.out.println(arr.length);  // Output: 5
```

### **📌 Kotlin**
```kotlin
val arr = arrayOf(1, 2, 3, 4, 5)
println(arr.size)  // Output: 5
```
✅ **In Kotlin, `size` is used instead of `length` in Java.**

---

# **4️⃣ Iterating Over an Array**
### **📌 Java (Using `for` Loop)**
```java
int[] arr = {10, 20, 30};

for (int i = 0; i < arr.length; i++) {
    System.out.println(arr[i]);
}
```

### **📌 Kotlin (Using `for` Loop)**
```kotlin
val arr = arrayOf(10, 20, 30)

for (i in arr.indices) {  
    println(arr[i])
}
```

### **📌 Kotlin (Using `forEach` Loop)**
```kotlin
arr.forEach { println(it) }
```
✅ **In Kotlin, we use `forEach` to iterate over elements easily.**

---

# **5️⃣ Multi-Dimensional Arrays (2D Arrays)**
### **📌 Java**
```java
int[][] matrix = {
    {1, 2, 3},
    {4, 5, 6}
};

System.out.println(matrix[1][2]);  // Output: 6
```

### **📌 Kotlin**
```kotlin
val matrix = arrayOf(
    arrayOf(1, 2, 3),
    arrayOf(4, 5, 6)
)

println(matrix[1][2])  // Output: 6
```
✅ **Kotlin uses `arrayOf(arrayOf(...))` to create multi-dimensional arrays.**  

---

# **6️⃣ Kotlin's Specialized Arrays (Primitive Types)**
Unlike Java, Kotlin provides **specialized arrays** for primitive types, which avoid the overhead of boxing.  

### **📌 Java**
```java
int[] intArray = {1, 2, 3};  // int[]
```

### **📌 Kotlin**
```kotlin
val intArray = intArrayOf(1, 2, 3)  // IntArray
val doubleArray = doubleArrayOf(1.1, 2.2, 3.3)  // DoubleArray
val charArray = charArrayOf('a', 'b', 'c')  // CharArray
```
✅ **Using `intArrayOf()` creates an efficient `IntArray` instead of a generic `Array<Int>`.**  

---

# **7️⃣ Sorting an Array**
### **📌 Java**
```java
import java.util.Arrays;
int[] arr = {5, 2, 8, 1, 3};
Arrays.sort(arr);
System.out.println(Arrays.toString(arr));  // Output: [1, 2, 3, 5, 8]
```

### **📌 Kotlin**
```kotlin
val arr = arrayOf(5, 2, 8, 1, 3)
arr.sort()
println(arr.joinToString())  // Output: 1, 2, 3, 5, 8
```
✅ **Kotlin provides the `.sort()` function for in-place sorting.**  

---

# **8️⃣ Copying an Array**
### **📌 Java**
```java
int[] arr = {1, 2, 3};
int[] copy = Arrays.copyOf(arr, arr.length);
```

### **📌 Kotlin**
```kotlin
val arr = arrayOf(1, 2, 3)
val copy = arr.copyOf()
```
✅ **In Kotlin, `copyOf()` is used to create an array copy.**  

---

# **9️⃣ Checking If an Element Exists**
### **📌 Java**
```java
int[] arr = {1, 2, 3};
boolean exists = Arrays.stream(arr).anyMatch(n -> n == 2);  // true
```

### **📌 Kotlin**
```kotlin
val arr = arrayOf(1, 2, 3)
println(2 in arr)  // Output: true
```
✅ **In Kotlin, `in` is used to check if an element exists.**  

---

# **🔟 Arrays vs. Lists in Kotlin**
In Kotlin, **Lists are preferred over Arrays** in many cases because they are **mutable and more flexible**.

| Feature | `Array` | `List` (`ArrayList`) |
|---------|--------|-----------------|
| **Size** | Fixed | Dynamic |
| **Mutability** | Mutable | Can be mutable (`MutableList`) |
| **Performance** | Faster | Slightly slower |
| **Syntax** | `arrayOf(1,2,3)` | `mutableListOf(1,2,3)` |

### ✅ **Using `List` Instead of an Array**
```kotlin
val list = mutableListOf(1, 2, 3)
list.add(4)
println(list)  // Output: [1, 2, 3, 4]
```

---

# **🔷 Common Interview Questions**
✅ **Reverse an array**
```kotlin
val arr = arrayOf(10, 20, 30, 40)
println(arr.reversed())  // Output: [40, 30, 20, 10]
```

✅ **Find the second largest number**
```kotlin
val arr = intArrayOf(10, 5, 20, 8)
val sorted = arr.sortedDescending()
println("Second Largest: ${sorted[1]}")  // Output: 10
```

✅ **Find even numbers in an array**
```kotlin
val arr = arrayOf(1, 2, 3, 4, 5, 6)
println(arr.filter { it % 2 == 0 })  // Output: [2, 4, 6]
```

---

# **🚀 Final Summary**
| Concept | Java | Kotlin |
|---------|------|--------|
| **Declaration** | `int[] arr = new int[5];` | `val arr = Array(5) { 0 }` |
| **Initialization** | `{1, 2, 3}` | `arrayOf(1, 2, 3)` |
| **Accessing Elements** | `arr[0]` | `arr[0]` |
| **Finding Length** | `arr.length` | `arr.size` |
| **Iterating** | `for` loop, `for-each` | `forEach`, `indices` |
| **Sorting** | `Arrays.sort(arr);` | `arr.sort()` |
| **Checking Existence** | `Arrays.stream(arr).anyMatch(n -> n == 2);` | `2 in arr` |

---