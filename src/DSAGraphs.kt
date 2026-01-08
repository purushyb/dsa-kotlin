fun main() {
    val adjList =
        arrayOf(arrayOf<Int>(1, 2), arrayOf<Int>(0, 2), arrayOf<Int>(0, 1, 3, 4), arrayOf<Int>(2), arrayOf<Int>(2))

    println(dfs(adjList))
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