fun main() {
    var arr = arrayOf(20, 0, 60, 0, 8)
    var count = 0

    for (i in 0..4) {
        if (arr[i] != 0) {
            arr[count++] = arr[i]
        }
    }

    while (count < 5) {
        arr[count++] = 0
    }

    print("Now array elements are: ")
    println()
    for (i in 0..4) {
        print("${arr[i]} ")
    }
    println()
}
