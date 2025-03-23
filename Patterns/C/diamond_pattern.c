#include <stdio.h>
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

int main()
{

    int count = 8;
    for (int i = 1; i <= count; i++)
    {
        for (int j = 1; j <= count; j++)
        {
            if (i <= count / 2)
            {
                if (j > count / 2 - i && j < count / 2 + i)
                {
                    printf("*");
                }
                else
                {
                    printf(" ");
                }
            }else
            {
                if (j > count / 2 - (count-i) && j< count/2 + (count-i))
                {
                    printf("*");
                }
                else
                {
                    printf(" ");
                }
            }
            
        }
        printf("\n");
    }

    return 0;
}