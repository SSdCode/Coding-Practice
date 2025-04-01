fun main() {
        var arr = arrayOf(1, 3, 2, 4, 6, 7);
        var n = 7;
        var origionalsum = n * (n + 1) / 2;
        var actualSum = 0;

        for (i in 0..5) {
            actualSum += arr[i];
        }

        System.out.println("Missing number is " + (origionalsum - actualSum));
    }
