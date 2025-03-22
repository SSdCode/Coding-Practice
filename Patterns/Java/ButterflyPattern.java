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
public class ButterflyPattern {

    public static void main(String[] args) {
        int count = 8;

        for (int i = 1; i <= count / 2; i++) {
            for (int j = 1; j <= count; j++) {
                if (j <= i || j >= count - i + 1) {
                    System.out.print("*");
                } else {
                    System.out.print(" ");
                }
            }
            System.out.println();
        }

        for (int i = 1; i <= count / 2; i++) {
            for (int j = 1; j <= count; j++) {
                if (j <= count / 2 - i + 1 || j >= count / 2 + i) {
                    System.out.print("*");
                } else {
                    System.out.print(" ");
                }
            }
            System.out.println();
        }
    }
}