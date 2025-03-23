#include <stdio.h>
// Palindromic pattern
/*

            1
           212
          32123
         4321234
        543212345

*/
int main()
{

    int count = 5;

    for (int i = 1; i <= count; i++)
    {
        for (int j = 1; j <= count - i; j++)
        {
            printf(" ");
        }
        for (int j = i; j >= 1; j--)
        {
            printf("%d", j);
        }
        // for (int j = 2; (i>=2) && (j<=count-(count-i)); j++)
        for (int j = 2; j<=i; j++)
        {
            printf("%d", j);
        }
        printf("\n");
    }

    return 0;
}