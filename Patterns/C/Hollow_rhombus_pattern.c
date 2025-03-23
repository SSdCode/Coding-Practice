#include <stdio.h>

// Hollow rhombus pattern
/*

             *****
            *   *
           *   *
          *   *
         *****

*/

int main()
{
    int count = 10;

    for (int i = 1; i <= count / 2; i++)
    {
        for (int j = 1; j <= count; j++)
        {
            if (i == 1 || i == count / 2)
            {
                if (j > count / 2 - i && j <= count - i)
                {
                    printf("*");
                }
                else
                {
                    printf(" ");
                }
            }
            else
            {
                int st = count / 2 - i + 1;
                int end = count - i;
                if (j == st || j == end)
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