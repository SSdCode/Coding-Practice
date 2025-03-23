//Number pyramid pattern
/*
            1
           2 2
          3 3 3
         4 4 4 4
        5 5 5 5 5

*/
fun main() {
        var count = 5;
        for (i in 1..count) {
            for (j in 1..count-i) {
                System.out.print(" ");
            }

            for (j in 1..i) {
                System.out.print("$i ");
            }
            System.out.println();
        }
    }
