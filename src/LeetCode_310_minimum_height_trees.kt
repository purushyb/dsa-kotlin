class LeetCode_310_minimum_height_trees {
    fun findMinHeightTrees(n: Int, edges: Array<IntArray>): List<Int> {

        if (n == 1) {
            return listOf(0)
        }

        val degree = IntArray(n) { 0 }
        val adjList = Array(n) { mutableListOf<Int>() }

        for ((edge1, edge2) in edges) {
            adjList[edge1].add(edge2)
            degree[edge1]++

            adjList[edge2].add(edge1)
            degree[edge2]++
        }

        var leaves = mutableListOf<Int>()

        for (i in 0..<n) {
            if (degree[i] == 1) {
                leaves.add(i)
            }
        }

        var vertexTracker = n

        while (vertexTracker > 2) {
            vertexTracker -= leaves.size

            val newLeaves = mutableListOf<Int>()

            for (leaf in leaves) {
                for (neighbor in adjList[leaf]) {
                    degree[neighbor]--
                    if (degree[neighbor] == 1) {
                        newLeaves.add(neighbor)
                    }
                }
            }
            leaves = newLeaves
        }
        return leaves
    }
}

fun main() {
    val problem = LeetCode_310_minimum_height_trees()

    val input = arrayOf(intArrayOf(1, 0), intArrayOf(1, 2), intArrayOf(1, 3))
    val result = problem.findMinHeightTrees(4, input)
    println(result)

    val input1 = arrayOf(intArrayOf(3, 0), intArrayOf(3, 1), intArrayOf(3, 2), intArrayOf(3, 4), intArrayOf(5, 4))
    val result1 = problem.findMinHeightTrees(6, input1)
    println(result1)

    val input2 = arrayOf(intArrayOf(1, 0))
    val result2 = problem.findMinHeightTrees(2, input2)
    println(result2)

    val input3 = arrayOf<IntArray>()
    val result3 = problem.findMinHeightTrees(1, input3)
    println(result3)
}