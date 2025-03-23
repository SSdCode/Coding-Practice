// Solid rhombus pattern
/*
             *****
            *****
           *****
          *****
         *****

*/

public class SolidRhombusPattern {

    public static void main(String[] args) {
        int count = 10;

        for(int i=1; i<=count/2; i++){
            for(int j=1; j<count; j++){
                if (j>count/2-i && j<=count-i) {
                    System.out.print("*");
                }else{
                    System.out.print(" ");
                }
            }
            System.out.println();
        }
    }
}

