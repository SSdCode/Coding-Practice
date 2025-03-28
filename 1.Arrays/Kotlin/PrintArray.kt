

import java.util.Scanner;
fun main() {
    var arr = Array(5) { 0 }
    var sc = Scanner(System.`in`)
    print("Enter five values: ")

    for (i in 0..arr.size-1) {
        arr[i] = sc.nextInt()
    }

    for (i in arr) {
        print("$i ")
    }
    println()
}