public class InvertedRotatedHalfPyramid {

    public static void main(String[] args) {
        int count = 4;
        // System.out.print("*");
        for (int i = count; i > 0; i--) {
            for (int j = 0; j <= count; j++) {
                if (j >= i) {
                    System.out.print("*");
                } else {
                    System.out.print(" ");
                }
            }
            System.out.println();
        }
    }
}