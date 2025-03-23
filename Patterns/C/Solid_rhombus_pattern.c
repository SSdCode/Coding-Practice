#include <stdio.h>

// Solid rhombus pattern
/*
             *****
            *****
           *****
          *****
         *****

*/

int main()
{

    int count = 10;

    for (int i = 1; i <= count / 2; i++)
    {
        for (int j = 1; j < count; j++)
        {
            if (j > (count / 2) - i && j <= count - i)
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