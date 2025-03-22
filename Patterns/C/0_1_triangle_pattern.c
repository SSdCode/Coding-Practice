#include<stdio.h>

// 0-1 triangle pattern
/*

         1
         01
         101
         0101
         10101

* */
int main(){

    for (int i = 1; i <=5; i++)
    {
        for (int j = 1; j <= 5; j++)
        {
            if (j<=i)
            {
                if(i%2 == 1){
                    if(j%2 == 0){
                        printf("0");
                    }else{
                        printf("1");
                    }
                }
                
                if(i%2 == 0){
                    if(j%2 == 0){
                        printf("1");
                    }else{
                        printf("0");
                    }
                }
            }
        }
        printf("\n");
        
    }
    
    return 0;
}