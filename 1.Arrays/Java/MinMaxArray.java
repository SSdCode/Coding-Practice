public class MinMaxArray {

    public static void main(String[] args) {
        int[] arr = {10,6,70,89,3};

        int max = arr[0], min = arr[0];
        for (int i = 0; i < 5; i++)
        {
            if (arr[i] > max){
                max = arr[i];
            }
            if (arr[i] < min){
                min = arr[i];
            }        
        }
        System.out.print("\n Max = "+max+" \n Min = "+min);
    }
}