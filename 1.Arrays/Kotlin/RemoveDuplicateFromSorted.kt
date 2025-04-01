fun main() {
    var arr = arrayOf(12, 15, 15, 29, 37)
    var count = 0

    for (i in 0..4) {
        if (arr[i] != arr[count]) {
            arr[count++] = arr[i]
        }
    }

    // If want zero in remaining places
    while (count < 5) {
        arr[count++] = 0
    }

    for (i in 0..count - 1) {
        print("${arr[i]} ")
    }
}
