import java.util.Scanner;

public class PrintArray {

    public static void main(String args[]){

        int[] arr = new int[5];
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter file values: ");
        for(int i = 0; i<arr.length; i++){
            arr[i] = sc.nextInt();
        }
        for(int i = 0; i<arr.length; i++){
            System.out.print(arr[i]+" ");
        }
        System.out.println();
        sc.close();
    }
}