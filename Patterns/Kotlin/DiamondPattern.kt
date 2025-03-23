// Diamond pattern
/*

           *
          ***
         *****
        *******
         *****
          ***
           *

*/
fun main() {
    var count = 8
    for (i in 1..count) {
        for (j in 1..count) {
            if (i <= count / 2) {
                if (j > count / 2 - i && j < count / 2 + i) {
                    System.out.print("*")
                } else {
                    System.out.print(" ")
                }
            } else {
                if (j > count / 2 - (count - i) && j < count / 2 + (count - i)) {
                    System.out.print("*")
                } else {
                    System.out.print(" ")
                }
            }
        }
        System.out.println()
    }
}
