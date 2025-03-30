import java.util.Scanner;

public class ReverseArray {

    public static void main(String[] args) {
        int[] arr = new int[5];
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter five numbers:");

        for (int i = 0; i < arr.length; i++){
            arr[i] = sc.nextInt();
        }

        System.out.println("Reversed array: ");

        for (int i = arr.length-1; i >=0 ; i--){
            System.out.print(arr[i]+" ");
        }
        System.out.println();
        sc.close();
    }
}