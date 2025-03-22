#include<stdio.h>
// Inverted - half pyramid
        /*

         12345
         1234
         123
         12
         1

         * */

int main(){
    int count = 5;

    for (int i = count; i >= 1; i--)
    {
        for (int j = 1; j <= count; j++)
        {
            if (j<=i)
            {
                printf("%d",j);
            }
        }
        printf("\n");
    }
    
}