#include <stdio.h>

/* Pattern to print

            *
           **
          ***
         ****

*/

int main()
{

    int count = 4;
    for (int i = count; i > 0; i--)
    {
        for (int j = 0; j <= count; j++)
        {
            if (i <= j)
            {
                printf("*");
            }
            else
            {
                printf(" ");
            }
        }
        printf("\n");
    }
    return 0;
}