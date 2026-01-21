import java.util.LinkedList
import java.util.PriorityQueue

fun main() {
    val adjList =
        arrayOf(arrayOf<Int>(1, 2), arrayOf<Int>(0, 2), arrayOf<Int>(0, 1, 3, 4), arrayOf<Int>(2), arrayOf<Int>(2))

    println(dfs(adjList))
    println(bfs(adjList))

    val unDirectedWeightedGraph = arrayOf(
        arrayOf(arrayOf(1, 4), arrayOf(2, 8)),                 // Node 0
        arrayOf(arrayOf(0, 4), arrayOf(4, 6), arrayOf(2, 3)), // Node 1
        arrayOf(arrayOf(0, 8), arrayOf(3, 2), arrayOf(1, 3)), // Node 2
        arrayOf(arrayOf(2, 2), arrayOf(4, 10)),                // Node 3
        arrayOf(arrayOf(1, 6), arrayOf(3, 10))                 // Node 4
    )
    println(dijkstraShortestPath(unDirectedWeightedGraph, 0).contentToString())

    val cyclicDirectedGraph = arrayOf(
        arrayOf(1),
        arrayOf(2),
        arrayOf(0, 3),
        arrayOf()
    )

    println(isCycleExists(cyclicDirectedGraph))
}

fun dfs(adjList: Array<Array<Int>>): List<Int> {
    val result = mutableListOf<Int>()
    dfsRecursion(adjList, Array<Boolean>(adjList.size) { false }, result, 0)
    return result
}

fun dfsRecursion(
    adjList: Array<Array<Int>>,
    visitedNodes: Array<Boolean>,
    output: MutableList<Int>,
    currentNode: Int
) {
    if (visitedNodes[currentNode] == true) return
    output.add(currentNode)

    for (i in adjList[currentNode]) {
        if (!visitedNodes[i]) {
            visitedNodes[currentNode] = true
            dfsRecursion(adjList, visitedNodes, output, i)
        }
    }

}

fun bfs(adj: Array<Array<Int>>): List<Int> {
    val output = mutableListOf<Int>()
    val queue = LinkedList<Int>()
    val visited = BooleanArray(adj.size) { false }

    visited[0] = true
    queue.offer(0)

    while (queue.isNotEmpty()) {
        val currentElement = queue.poll()
        output.add(currentElement)

        for (element in adj[currentElement]) {
            if (!visited[element]) {
                visited[element] = true
                queue.offer(element)
            }
        }
    }

    return output
}

fun dijkstraShortestPath(adj: Array<Array<Array<Int>>>, startNode: Int): Array<Int> {

    val distances = Array<Int>(adj.size) { Int.MAX_VALUE }
    val pq = PriorityQueue<Pair<Int, Int>> { a, b -> a.first.compareTo(b.first) }

    // initial case
    val startNodeDistance = 0
    pq.offer(Pair(startNode, startNodeDistance))
    distances[startNode] = startNodeDistance

    while (pq.isNotEmpty()) {
        val (currentSmallestElement, currentSmallestDistance) = pq.poll()

        if (currentSmallestDistance > distances[currentSmallestElement]) continue

        for ((neighbor, neighborWeight) in adj[currentSmallestElement]) {
            val newDistance = currentSmallestDistance + neighborWeight
            if (newDistance < distances[neighbor]) {
                distances[neighbor] = newDistance
                pq.offer(Pair(neighbor, newDistance))
            }
        }
    }
    return distances
}

fun dfsCycleDetection(
    adj: Array<Array<Int>>,
    visited: Array<Boolean>,
    recurStack: Array<Boolean>,
    currElement: Int
): Boolean {
    if (recurStack[currElement]) return true

    if (visited[currElement]) return false

    visited[currElement] = true
    recurStack[currElement] = true

    for (i in adj[currElement]) {
        if (dfsCycleDetection(adj, visited, recurStack, i)) return true
    }
    recurStack[currElement] = false
    return false

}

fun isCycleExists(adj: Array<Array<Int>>): Boolean {

    val visitedArray = Array(adj.size) { false }
    val recurArray = Array(adj.size) { false }

    for (i in 0..<adj.size) {
        if (!visitedArray[i] && dfsCycleDetection(adj, visitedArray, recurArray, i)) return true
    }
    return false

}