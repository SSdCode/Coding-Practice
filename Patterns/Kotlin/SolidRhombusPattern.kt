// Solid rhombus pattern
/*
             *****
            *****
           *****
          *****
         *****

*/

fun main() {
    var count = 10

    for (i in 1..count / 2) {
        for (j in 1..count) {
            if (j > count / 2 - i && j <= count - i) {
                print("*")
            } else {
                print(" ")
            }
        }
        println()
    }
}
