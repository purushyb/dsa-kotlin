import java.util.LinkedList

object LeetCode_133_clone_graph {

    class Node(var `val`: Int) {
        var neighbors: ArrayList<Node?> = ArrayList<Node?>()

        // override toString to avoid stack overflow when printing
        override fun toString(): String {
            return "Node($`val`)"
        }
    }

    fun cloneGraph(node: Node?): Node? {

        if (node == null) return null

        val map = HashMap<Int, Node>()
        val q = LinkedList<Node>()


        val rootNode = Node(node.`val`)
        map[node.`val`] = rootNode
        q.offer(node)

        while (q.isNotEmpty()) {
            val currNode = q.poll()

            currNode.neighbors.forEach { neighbor ->

                if (!map.containsKey(neighbor!!.`val`)) {
                    map[neighbor.`val`] = Node(neighbor.`val`)
                    q.offer(neighbor)
                }

                map[currNode.`val`]?.neighbors?.add(map[neighbor.`val`])
            }
        }
        return map[node.`val`]
    }

    fun createGraph(): Node? {
        // Input Adjacency List
        val adjData = arrayOf(
            listOf(2, 4), // Neighbors of Node 1
            listOf(1, 3), // Neighbors of Node 2
            listOf(2, 4), // Neighbors of Node 3
            listOf(1, 3)  // Neighbors of Node 4
        )

        if (adjData.isEmpty()) return null

        // Step 1: Create all Node objects first
        // We create an array of Nodes so we can reference them by index later.
        val nodeList = ArrayList<Node>()
        for (i in 1..adjData.size) {
            nodeList.add(Node(i))
        }

        // Step 2: Connect the neighbors
        for (i in adjData.indices) {
            val currentNode = nodeList[i] // Node 1 is at index 0

            for (neighborVal in adjData[i]) {
                // Find the neighbor node object
                // neighborVal is 1-based (e.g., 2), so we look at index 1
                val neighborNode = nodeList[neighborVal - 1]

                currentNode.neighbors.add(neighborNode)
            }
        }

        // Return the first node (Node 1) as the entry point
        return nodeList[0]
    }

    fun printGraph(node: Node) {
        val visited = HashSet<Int>()
        val queue = ArrayDeque<Node>()

        queue.add(node)
        visited.add(node.`val`)

        while (queue.isNotEmpty()) {
            val curr = queue.removeFirst()

            print("Node ${curr.`val`} is connected to: [")
            curr.neighbors.forEach { neighbor ->
                if (neighbor != null) {
                    print("${neighbor.`val`} ")
                    if (!visited.contains(neighbor.`val`)) {
                        visited.add(neighbor.`val`)
                        queue.add(neighbor)
                    }
                }
            }
            println("]")
        }
    }
}

fun main() {
    val graphRoot = LeetCode_133_clone_graph.createGraph()

    // BFS to print and verify the structure
    if (graphRoot != null) {
        LeetCode_133_clone_graph.printGraph(graphRoot)
    }

    println("== Clone Graph ==")
    val cloneGraph = LeetCode_133_clone_graph.cloneGraph(graphRoot)
    LeetCode_133_clone_graph.printGraph(cloneGraph!!)
}