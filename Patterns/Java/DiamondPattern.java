// Diamond pattern
/*

           *
          ***
         *****
        *******
         *****
          ***
           *

*/
public class DiamondPattern {

    public static void main(String[] args) {
        int count = 8;
        for (int i = 1; i <= count; i++)
        {
            for (int j = 1; j <= count; j++)
            {
                if (i <= count / 2)
                {
                    if (j > count / 2 - i && j < count / 2 + i)
                    {
                        System.out.print("*");
                    }
                    else
                    {
                        System.out.print(" ");
                    }
                }
                else
                {
                    if (j > count / 2 - (count - i) && j < count / 2 + (count - i))
                    {
                        System.out.print("*");
                    }
                    else
                    {
                        System.out.print(" ");
                    }
                }
            }
            System.out.println();
        }
    }
}