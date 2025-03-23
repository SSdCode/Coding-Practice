// Palindromic pattern
/*

            1
           212
          32123
         4321234
        543212345

*/
fun main() {
        var count = 5;

        for (i in 1..count) {
            for (j in 1..count-i) {
                System.out.print(" ");
            }
            for (j in i downTo 1) {
                System.out.print(j);
            }
            for (j in 2..i) {
                System.out.print(j);
            }
            System.out.println();
        }
    }
