// Follows two pointer manipulation
fun main() {
    val inputArray = arrayOf(1, 3, 4, 5, 6, 7)
    reverseArray(inputArray)
    println(inputArray.contentToString())

    val sortedArrayWithDuplicates = arrayOf(1, 1, 2, 2, 2, 3, 3, 3, 3, 4, 5)
    val arrEndIndex = removeDuplicates(sortedArrayWithDuplicates)
    println(sortedArrayWithDuplicates.copyOfRange(0, arrEndIndex + 1).contentToString())
}

fun reverseArray(arr: Array<Int>) {
    var leftPointer = 0
    var rightPointer = arr.size - 1

    while (leftPointer < rightPointer) {
        swap(arr, leftPointer, rightPointer)
        leftPointer++
        rightPointer--
    }
}

fun removeDuplicates(arr: Array<Int>): Int {
    var leftPointer = 0

    for (rightPointer in 1..<arr.size) {
        if (arr[rightPointer] != arr[rightPointer - 1]) {
            leftPointer++
            arr[leftPointer] = arr[rightPointer]
        }
    }
    return leftPointer
}