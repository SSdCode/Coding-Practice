// Palindromic pattern
/*

            1
           212
          32123
         4321234
        543212345

*/
public class PalindromicPattern {

    public static void main(String[] args) {
        int count = 5;

        for (int i = 1; i <= count; i++) {
            for (int j = 1; j <= count - i; j++) {
                System.out.print(" ");
            }
            for (int j = i; j >= 1; j--) {
                System.out.print(j);
            }
            // for (int j = 2; (i>=2) && (j<=count-(count-i)); j++)
            for (int j = 2; j <= i; j++) {
                System.out.print(j);
            }
            System.out.println();
        }
    }
}