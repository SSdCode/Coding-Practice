#include <stdio.h>
// Triangle
/*

                 *
               * * *
             * * * * *
           * * * * * * *

*/

int main()
{

    int count = 8;
    for (int i = 1; i <= count / 2; i++)
    {
        for (int j = 1; j < count; j++)
        {
            if (j > count / 2 - i && j < count / 2 + i)
            {
                printf("* ");
            }
            else
            {
                printf("  ");
            }
        }
        printf("\n");
    }

    return 0;
}