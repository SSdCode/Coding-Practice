public class ZeroToEnd {

    public static void main(String[] args) {
        int[] arr = {20,0,60,0,8};
        int count = 0;
        
        for (int i = 0; i < 5; i++)
        {
            if (arr[i] != 0)
            {
                arr[count++] = arr[i];
            }
        }

        while (count < 5){
            arr[count++] = 0;
        }    

        System.out.print("Now array elements are: ");
        System.out.println();
        for (int i = 0; i < 5; i++) {
            System.out.print(arr[i]+" ");
        }
        System.out.println();
    }
}