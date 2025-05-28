import kotlin.arrayOf

var unionCount = 0
var intersectionCount = 0

fun insertInArray(element: Int, array: IntArray, InorUni: Char)
{
    var isElementPresentInArray = false
    for (k in 0..5)
    {
        if (array[k] == element)
        {
            isElementPresentInArray = true
        }
    }
    if (!isElementPresentInArray)
    {
        if (InorUni == 'u')
        {
            array[unionCount++] = element
        }
        else
        {
            array[intersectionCount++] = element
        }
    }
}

fun main() {
    println()
    var arr1 = arrayOf(1, 3, 2, 4, 6, 7)
    var arr2 = arrayOf(4, 6, 7, 8, 9, 5)
    val unionn = IntArray(12)
    val intercection = IntArray(6)
    for (i in 0..5)
    {
        val elementArr1 = arr1[i]
        val elementArr2 = arr2[i]
        var isElementArr1PresentInArr2 = false
        var isElementArr2PresentInArr1 = false
        for (j in 0..5)
        {
            if (arr1[j] == elementArr2)
            {
                isElementArr2PresentInArr1 = true
            }
            if (arr2[j] == elementArr1)
            {
                isElementArr1PresentInArr2 = true
            }
        }
        if (isElementArr2PresentInArr1)
        {
            insertInArray(elementArr2, intercection, 'i')
        }
        if (isElementArr1PresentInArr2)
        {
            insertInArray(elementArr1, intercection, 'i')
        }
        insertInArray(elementArr2, unionn, 'u')
        insertInArray(elementArr1, unionn, 'u')
    }
    print("intersection - ")
    for (m in 0..intersectionCount-1)
    {
        print("${intercection[m]} ")
    }
    print("\n")
    print("Union - ")
    for (n in 0..unionCount-1)
    {
        print("${unionn[n]} ")
    }
    println()
}