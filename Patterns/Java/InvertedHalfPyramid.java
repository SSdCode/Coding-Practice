// Inverted - half pyramid
/*

 12345
 1234
 123
 12
 1

 * */

public class InvertedHalfPyramid {

    public static void main(String[] args) {
        int count = 5;

        for (int i = count; i >= 1; i--) {
            for (int j = 1; j <= count; j++) {
                if (j <= i) {
                    System.out.print(j);
                }
            }
            System.out.println();
        }
    }
}