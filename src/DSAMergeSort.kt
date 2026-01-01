import utils.DataBaseRecord

fun main() {
    val inputArr = arrayOf<Int>(8, 4, 7, 9, 10, 5)
    dsaMergeSort(inputArr, 0, inputArr.size - 1)
    println(inputArr.contentToString())

    val nodesToSearch = arrayOf<DataBaseRecord>(
        DataBaseRecord(id = 1, name = "Apple"),
        DataBaseRecord(id = 3, name = "Badri"),
        DataBaseRecord(id = 5, name = "Catherine"),
        DataBaseRecord(id = 7, name = "Donnie"),
        DataBaseRecord(id = 9, name = "Elene"),
        DataBaseRecord(id = 11, name = "Fatima"),
        DataBaseRecord(id = 13, name = "Girish"),
        DataBaseRecord(id = 15, name = "Harry"),
        DataBaseRecord(id = 17, name = "Ishika"),
        DataBaseRecord(id = 19, name = "Jaanu")
    )

    dsaMergeSortGeneric(nodesToSearch, 0, nodesToSearch.size - 1)
    println(nodesToSearch.contentToString())
}

fun dsaMergeSortGeneric(arr: Array<DataBaseRecord>, leftIndex: Int, rightIndex: Int) {
    if (leftIndex < rightIndex) {
        val mid = leftIndex + (rightIndex - leftIndex) / 2
        dsaMergeSortGeneric(arr, leftIndex, mid)
        dsaMergeSortGeneric(arr, mid + 1, rightIndex)
        mergeDataBaseRecords(arr, leftIndex, mid, rightIndex)
    }
}

fun mergeDataBaseRecords(arr: Array<DataBaseRecord>, low: Int, mid: Int, high: Int) {
    val leftArrLength = mid - low + 1
    val rightArrLength = high - mid

    val leftArr = arr.copyOfRange(low, mid+1)
    val rightArr = arr.copyOfRange(mid + 1, high + 1)

    var leftArrIndex = 0
    var rightArrIndex = 0
    var arrIndex = low

    while (leftArrIndex < leftArrLength && rightArrIndex < rightArrLength) {
        if (leftArr[leftArrIndex].id < rightArr[rightArrIndex].id) {
            arr[arrIndex] = leftArr[leftArrIndex]
            leftArrIndex++
        } else {
            arr[arrIndex] = rightArr[rightArrIndex]
            rightArrIndex++
        }
        arrIndex++
    }

    while (leftArrIndex < leftArrLength) {
        arr[arrIndex] = leftArr[leftArrIndex]
        leftArrIndex++
        arrIndex++
    }

    while (rightArrIndex < rightArrLength) {
        arr[arrIndex] = rightArr[rightArrIndex]
        rightArrIndex++
        arrIndex++
    }
}

fun dsaMergeSort(arr: Array<Int>, leftIndex: Int, rightIndex: Int) {
    if (leftIndex < rightIndex) {
        val mid = leftIndex + (rightIndex - leftIndex) / 2
        dsaMergeSort(arr, leftIndex, mid)
        dsaMergeSort(arr, mid + 1, rightIndex)
        merge(arr, leftIndex, mid, rightIndex)
    }
}

fun merge(arr: Array<Int>, low: Int, mid: Int, high: Int) {
    val leftArrLength = mid - low + 1
    val rightArrLength = high - mid

    val leftArr = Array<Int>(leftArrLength) { 0 }
    val rightArr = Array<Int>(rightArrLength) { 0 }

    for (i in 0..<leftArrLength) {
        leftArr[i] = arr[low + i]
    }

    for (j in 0..<rightArrLength) {
        rightArr[j] = arr[mid + 1 + j]
    }

    var leftArrIndex = 0
    var rightArrIndex = 0
    var arrIndex = low

    while (leftArrIndex < leftArrLength && rightArrIndex < rightArrLength) {
        if (leftArr[leftArrIndex] < rightArr[rightArrIndex]) {
            arr[arrIndex] = leftArr[leftArrIndex]
            leftArrIndex++
        } else {
            arr[arrIndex] = rightArr[rightArrIndex]
            rightArrIndex++
        }
        arrIndex++
    }

    while (leftArrIndex < leftArrLength) {
        arr[arrIndex] = leftArr[leftArrIndex]
        leftArrIndex++
        arrIndex++
    }

    while (rightArrIndex < rightArrLength) {
        arr[arrIndex] = rightArr[rightArrIndex]
        rightArrIndex++
        arrIndex++
    }
}
