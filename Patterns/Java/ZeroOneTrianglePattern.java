// 0-1 triangle pattern
/*

         1
         01
         101
         0101
         10101

* */

public class ZeroOneTrianglePattern {

    public static void main(String[] args) {
        for (int i = 1; i <=5; i++)
        {
            for (int j = 1; j <= 5; j++)
            {
                if (j<=i)
                {
                    if(i%2 == 1){
                        if(j%2 == 0){
                            System.out.print("0");
                        }else{
                            System.out.print("1");
                        }
                    }
                    
                    if(i%2 == 0){
                        if(j%2 == 0){
                            System.out.print("1");
                        }else{
                            System.out.print("0");
                        }
                    }
                }
            }
            System.out.println();
            
        }
    }
}
