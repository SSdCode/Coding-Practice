// Butterfly pattern
/*

        *      *
        **    **
        ***  ***
        ********
        ********
        ***  ***
        **    **
        *      *

*/

    fun main() {
        var count = 8;

        for (i in 1..4) {
            for (j in 1..count) {
                if (j <= i || j >= count - i + 1) {
                    print("*");
                } else {
                    print(" ");
                }
            }
            println();
        }

        for (i in 1..4) {
            for (j in 1..count) {
                if (j <= count / 2 - i + 1 || j >= count / 2 + i) {
                    print("*");
                } else {
                    print(" ");
                }
            }
            println();
        }
    }