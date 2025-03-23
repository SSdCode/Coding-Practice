// Triangle
/*

                 *
               * * *
             * * * * *
           * * * * * * *

*/
fun main() {

    var count = 8
    for (i in 1..count / 2) {
        for (j in 1..count - 1) {
            if (j > count / 2 - i && j < count / 2 + i) {
                System.out.print("* ")
            } else {
                System.out.print("  ")
            }
        }
        System.out.println()
    }
}
