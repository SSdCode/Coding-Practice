// 0-1 triangle pattern
/*

         1
         01
         101
         0101
         10101

* */

fun main() {
    for (i in 1..5) {
        for (j in 1..5) {
            if (j <= i) {
                if (i % 2 == 1) {
                    if (j % 2 == 0) {
                        System.out.print("0")
                    } else {
                        System.out.print("1")
                    }
                }

                if (i % 2 == 0) {
                    if (j % 2 == 0) {
                        System.out.print("1")
                    } else {
                        System.out.print("0")
                    }
                }
            }
        }
        println()
    }
}
