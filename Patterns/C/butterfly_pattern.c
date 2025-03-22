#include<stdio.h> 
 // Butterfly pattern
 /*

         *      *
         **    **
         ***  ***
         ********
         ********
         ***  ***
         **    **
         *      *

*/
int main(){

    int count = 8;

    for (int i = 1; i <= count/2; i++)
    {
        for (int j = 1; j <= count; j++)
        {
            if (j<=i || j>=count-i+1)
            {
                printf("*");
            }else{
                printf(" ");
            }
        }
        printf("\n");
    }
    
    for (int i = 1; i <= count/2; i++)
    {
        for (int j = 1; j <= count; j++)
        {
            if (j<=count/2-i+1 || j>=count/2+i)
            {
                printf("*");
            }else{
                printf(" ");
            }
        }
        printf("\n");
    }

    return 0;
}