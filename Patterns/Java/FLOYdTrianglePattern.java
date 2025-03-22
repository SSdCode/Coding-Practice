// FLOYD's Triangle pattern
/*
         1
         2 3
         4 5 6
         7 8 9 10
         11 12 13 14 15

 * */

public class FLOYdTrianglePattern {

    public static void main(String[] args) {
        int count = 1;
        for (int i = 1; i <= 5; i++) {
            for (int j = 1; j <= 5; j++) {
                if (j <= i) {
                    System.out.print(count + " ");
                    count++;
                }
            }
            System.out.println();
        }
    }
}
