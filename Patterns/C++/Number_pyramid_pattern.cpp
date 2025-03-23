#include <iostream>
//Number pyramid pattern
/*
            1
           2 2
          3 3 3
         4 4 4 4
        5 5 5 5 5

*/
using namespace std;
int main()
{

    int count = 5;
    for (int i = 1; i <= count; i++)
    {
        for (int j = 1; j <= count-i; j++)
        {
            printf(" ");
        }

        for (int j = 1; j <= i; j++)
        {
            printf("%d ",i);
        }
        printf("\n");
    }
    

    return 0;
}