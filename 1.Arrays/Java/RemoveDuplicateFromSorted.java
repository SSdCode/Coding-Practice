public class RemoveDuplicateFromSorted {
    public static void main(String[] args) {
        int[] arr = {12, 15, 15, 29, 37};
        int count = 0;

        for (int i = 0; i < 5; i++) {
            if (arr[i] != arr[count]) {
                arr[count++] = arr[i];
            }
        }

        // Fill remaining places with zero
        while (count < 5) {
            arr[count++] = 0;
        }

        // Print the array
        for (int i = 0; i < count; i++) {
            System.out.print(arr[i] + " ");
        }
    }
}