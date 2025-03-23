
// Triangle
/*

                 *
               * * *
             * * * * *
           * * * * * * *

*/
public class Triengle {

    public static void main(String[] args) {

        Triengle triengle = new Triengle();
        triengle.printPattern();
    }

    public void printPattern()
    {

        int count = 8;
            for (int i = 1; i <= count / 2; i++)
            {
                for (int j = 1; j < count; j++)
                {
                    if (j > count / 2 - i && j < count / 2 + i)
                    {
                        System.out.print("* ");
                    }
                    else
                    {
                        System.out.print("  ");
                    }
                }
                System.out.println();
            }
    }
}
