

import java.util.Scanner

fun main(){
    print("Enter Five Numbers: ")
    var sc = Scanner(System.`in`)
    var arr = Array(5) { 0 }

    for(i in 0..arr.size-1){
        arr[i] = sc.nextInt()
    }
    // println("hehe - ${arr.size-1}\n")
    for(i in 4 downTo 0){
        print("${arr[i]} ")
    }
    sc.close()
    println()
}