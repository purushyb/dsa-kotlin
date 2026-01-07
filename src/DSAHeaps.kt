import java.util.PriorityQueue

fun main() {
    val inputArray = arrayOf(7, 10, 11, 5, 2, 5, 5, 7, 11, 8, 9)
    val k = 4

    println(topKElements(inputArray, k))

    val inputArray1 = arrayOf(1, 23, 12, 9, 30, 2, 50)
    println(firstKLargestElements(inputArray1, 4))
    println(firstKSmallestElements(inputArray1, 4))

}

fun topKElements(inputArray: Array<Int>, k: Int): List<Int> {

    val frequencyTable = mutableMapOf<Int, Int>()

    for (element in inputArray) {
        frequencyTable[element] = frequencyTable.getOrDefault(element, 0) + 1
    }

    val pq = PriorityQueue<Pair<Int, Int>> { a, b ->
        if (a.second == b.second) a.first.compareTo(b.first) else a.second.compareTo(b.second)
    }

    frequencyTable.forEach { (key, value) ->

        pq.add(Pair(key, value))

        if (pq.size > k) {
            pq.poll()
        }
    }
    val op = mutableListOf<Int>()

    while (pq.isNotEmpty()) {
        op.add(pq.poll().first)
    }

    return op.reversed()
}

fun firstKLargestElements(inputArray: Array<Int>, k: Int): List<Int> {

    if (k >= inputArray.size) return listOf<Int>()

    // Min priority Queue
    val pq = PriorityQueue<Int>(k)
    for (i in 0..<k) {
        pq.add(inputArray[i])
    }

    for (i in k..<inputArray.size) {
        if (pq.peek() < inputArray[i]) {
            pq.poll()
            pq.add(inputArray[i])
        }
    }

    val opList = mutableListOf<Int>()

    while (pq.isNotEmpty()) {
        opList.add(pq.poll())
    }

    return opList.reversed()
}

fun firstKSmallestElements(inputArray: Array<Int>, k: Int): List<Int> {

    if (k >= inputArray.size) return listOf<Int>()

    // Min priority Queue
    val pq = PriorityQueue<Int>(k, reverseOrder())
    for (i in 0..<k) {
        pq.add(inputArray[i])
    }

    for (i in k..<inputArray.size) {
        if (pq.peek() > inputArray[i]) {
            pq.poll()
            pq.add(inputArray[i])
        }
    }

    val opList = mutableListOf<Int>()

    while (pq.isNotEmpty()) {
        opList.add(pq.poll())
    }

    return opList.reversed()
}