// Inverted - half pyramid
/*

 12345
 1234
 123
 12
 1

 * */

fun main() {
    var count = 5
    for (i in count downTo 1) {
        for (j in 1..count) {
            if (j <= i) {
                print(j)
            }
        }
        println()
    }
}
