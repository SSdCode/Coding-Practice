#include <stdio.h>
// Diamond pattern
//Number pyramid pattern
/*
            1
           2 2
          3 3 3
         4 4 4 4
        5 5 5 5 5

*/

int main()
{

    int i,j,count = 5;
    for (i = 1; i <= count; i++)
    {
        for (j = 1; j <= count-i; j++)
        {
            printf(" ");
        }

        for (j = 1; j <= i; j++)
        {
            printf("%d ",i);
        }

        printf("\n");
    }
    return 0;
}