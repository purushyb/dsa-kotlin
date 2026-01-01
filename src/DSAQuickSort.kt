import utils.DataBaseRecord

fun main() {
    val arr = arrayOf<Int>(8, 4, 7, 9, 10, 5)

    dsaQuickSort(arr, 0, arr.size - 1)
    println(arr.contentToString())

    val nodesToSort = arrayOf<DataBaseRecord>(
        DataBaseRecord(id = 8, name = "Anjana"),
        DataBaseRecord(id = 4, name = "Badri"),
        DataBaseRecord(id = 7, name = "Catherine"),
        DataBaseRecord(id = 9, name = "Donnie"),
        DataBaseRecord(id = 10, name = "Elene"),
        DataBaseRecord(id = 5, name = "Fatima")
    )

    dsaQuickSortGeneric(nodesToSort, 0, nodesToSort.size - 1)
    println(nodesToSort.contentToString())
}

fun partition(arr: Array<DataBaseRecord>, low: Int, high: Int): Int {
    val pivot = arr[high]
    var indexToSwap = low - 1

    for (j in low..<high) {
        if (arr[j].id < pivot.id) {
            indexToSwap++
            swap(arr, j, indexToSwap)
        }
    }

    swap(arr, indexToSwap + 1, high)
    return indexToSwap + 1
}

fun swap(arr: Array<DataBaseRecord>, i: Int, j: Int) {
    val temp = arr[i]
    arr[i] = arr[j]
    arr[j] = temp
}

fun dsaQuickSortGeneric(arr: Array<DataBaseRecord>, low: Int, high: Int) {
    if (low < high) {
        val pivotIndex = partition(arr, low, high)
        dsaQuickSortGeneric(arr, low, pivotIndex - 1)
        dsaQuickSortGeneric(arr, pivotIndex + 1, high)
    }
}


// Lomuto partition
fun partition(arr: Array<Int>, low: Int, high: Int): Int {
    val pivot = arr[high]
    var indexToSwap = low - 1

    for (j in low..<high) {
        if (arr[j] < pivot) {
            indexToSwap++
            swap(arr, indexToSwap, j)
        }
    }

    swap(arr, indexToSwap + 1, high)
    return indexToSwap + 1
}

fun swap(arr: Array<Int>, i: Int, j: Int) {
    val temp = arr[i]
    arr[i] = arr[j]
    arr[j] = temp
}

fun dsaQuickSort(arr: Array<Int>, low: Int, high: Int) {
    if (low < high) {
        val pivotIndex = partition(arr, low, high)
        dsaQuickSort(arr, low, pivotIndex - 1)
        dsaQuickSort(arr, pivotIndex + 1, high)
    }
}

