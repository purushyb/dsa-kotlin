fun main() {
    val edges = arrayOf(
        arrayOf<Int>(0, 1, 10),
        arrayOf<Int>(1, 3, 15),
        arrayOf<Int>(2, 3, 4),
        arrayOf<Int>(2, 0, 6),
        arrayOf<Int>(0, 3, 5)
    )
    println(kruskalsMinimumSpanningTree(edges, 4))
}

fun kruskalsMinimumSpanningTree(edges: Array<Array<Int>>, noOfVertices: Int): Int {
    // Disjoint Sets Union impl

    val parents = Array<Int>(noOfVertices) { it }
    val ranks = Array<Int>(noOfVertices) { 0 }

    edges.sortWith(Comparator<Array<Int>> { o1, o2 -> o1[2].compareTo(o2[2]) })

    var totalCost = 0

    for (i in edges) {
        val e1 = i[0]
        val e2 = i[1]
        val weight = i[2]

        if (find(parents, e1) != find(parents, e2)) {
            totalCost += weight
            union(parents, ranks, e1, e2)
            println("$e1 -> $e2")
        }
    }

    return totalCost
}

fun union(parentsArray: Array<Int>, ranks: Array<Int>, element1: Int, element2: Int) {
    val parent1 = find(parentsArray, element1)
    val parent2 = find(parentsArray, element2)

    if (parent1 == parent2) return

    if (ranks[parent1] > ranks[parent2]) {
        parentsArray[parent2] = parent1
    } else if (ranks[parent1] < ranks[parent2]) {
        parentsArray[parent1] = parent2
    } else {
        ranks[parent1] += 1
        parentsArray[parent1] = parent2
    }
}

fun find(parentsArray: Array<Int>, currentElement: Int): Int {
    // Base
    if (parentsArray[currentElement] == currentElement) return currentElement

    return find(parentsArray, parentsArray[currentElement])
}