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
}

fun dfs(adjList: Array<Array<Int>>): List<Int> {
    val result = mutableListOf<Int>()
    dfsRecursion(adjList, mutableMapOf<Int, Boolean>(), result, 0)
    return result
}

fun dfsRecursion(
    adjList: Array<Array<Int>>,
    visitedNodes: MutableMap<Int, Boolean>,
    output: MutableList<Int>,
    currentNode: Int
) {

    visitedNodes[currentNode] = true
    output.add(currentNode)

    for (i in adjList[currentNode]) {
        if (!visitedNodes.getOrDefault(i, false)) {
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

        if(currentSmallestDistance > distances[currentSmallestElement]) continue

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