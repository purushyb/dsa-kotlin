fun main() {
    val listToSearch = arrayOf<Int>(1, 3, 5, 7, 9, 11, 13, 15, 17, 19)
    val elementToFind = 17

    val elementIndex = dsaBinarySearch(listToSearch, elementToFind)
    println("$elementIndex")

    val nodesToSearch = arrayOf<DataBaseRecord>(
        DataBaseRecord(id = 1, name = "Anjana"),
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

    dsaBinarySearchGeneric(nodesToSearch, elementToFind)
    println("$elementIndex")

    dsaBinarySearchVisual(listToSearch, elementToFind)
    println("$elementIndex")
}

data class DataBaseRecord(val id: Int, val name: String) : Comparator<DataBaseRecord> {
    override fun compare(o1: DataBaseRecord, o2: DataBaseRecord): Int {
        return o1.id.compareTo(o2.id)
    }
}


fun dsaBinarySearchGeneric(elementsToSearch: Array<DataBaseRecord>, idToSearch: Int): Int {
    var leftIndex = 0
    var rightIndex = elementsToSearch.size - 1
    var midIndex: Int

    while (leftIndex <= rightIndex) {
        midIndex = (rightIndex + leftIndex) / 2
        if (idToSearch == elementsToSearch[midIndex].id) {
            return midIndex
        } else if (idToSearch > elementsToSearch[midIndex].id) {
            leftIndex = midIndex + 1
        } else {
            rightIndex = midIndex - 1
        }
    }
    return -1;
}


fun dsaBinarySearch(arrayToSearch: Array<Int>, elementToFind: Int): Int {

    var leftIndex = 0
    var rightIndex = arrayToSearch.size - 1
    var midIndex: Int

    while (leftIndex <= rightIndex) {
        midIndex = (rightIndex + leftIndex) / 2

        if (arrayToSearch[midIndex] == elementToFind) {
            return midIndex
        } else if (elementToFind > arrayToSearch[midIndex]) {
            leftIndex = midIndex + 1
        } else {
            rightIndex = midIndex - 1
        }
    }

    return -1
}

fun dsaBinarySearchVisual(elements: Array<Int>, target: Int): Int {
    var left = 0
    var right = elements.size - 1
    var mid: Int

    println("Target: $target")
    println("Index:  " + elements.indices.joinToString("  ") { "%2d".format(it) })
    println("Values: " + elements.joinToString("  ") { "%2d".format(it) })
    println("-".repeat(elements.size * 4 + 8))

    while (left <= right) {
        mid = (right + left) / 2

        // --- Visualization Logic ---
        val visualLine = StringBuilder("        ")
        for (i in elements.indices) {
            val marker = when (i) {
                mid -> "M " // Midpoint
                left -> "L " // Left bound
                right -> "R " // Right bound
                else -> "  "
            }
            visualLine.append(" $marker ")
        }
        println(visualLine.toString() + "  (Range: $left-$right, Mid: $mid)")
        // ---------------------------

        if (target == elements[mid]) {
            println("Found at index $mid!")
            return mid
        } else if (target > elements[mid]) {
            left = mid + 1
        } else {
            right = mid - 1
        }
    }
    return -1
}