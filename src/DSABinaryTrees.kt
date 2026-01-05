import utils.BinaryTreeNode

fun main() {
    val binaryTreeRoot = BinaryTreeNode(1)
    binaryTreeRoot.left = BinaryTreeNode(2)
    binaryTreeRoot.right = BinaryTreeNode(3)
    binaryTreeRoot.left?.left = BinaryTreeNode(4)
    binaryTreeRoot.left?.right = BinaryTreeNode(5)
    binaryTreeRoot.right?.left = BinaryTreeNode(6)

    println("DFS order for preOrder")
    dfsPrintPreOrder(binaryTreeRoot)
    println()

    println("DFS order for inOrder")
    dfsPrintInOrder(binaryTreeRoot)
    println()

    println("DFS order for postOrder")
    dfsPrintPostOrder(binaryTreeRoot)
    println()

    println("BFS Order")
    println(bfsReturnOrder(binaryTreeRoot))

    println("BFS Recursion Order")
    println(bfsRecursiveTraversal(binaryTreeRoot))
}

fun dfsPrintPreOrder(node: BinaryTreeNode?) {
    if (node == null) return

    print("${node.data} ")
    dfsPrintPreOrder(node.left)
    dfsPrintPreOrder(node.right)
}

fun dfsPrintInOrder(node: BinaryTreeNode?) {
    if (node == null) return

    dfsPrintInOrder(node.left)
    print("${node.data} ")
    dfsPrintInOrder(node.right)
}

fun dfsPrintPostOrder(node: BinaryTreeNode?) {
    if (node == null) return

    dfsPrintInOrder(node.left)
    dfsPrintInOrder(node.right)

    print("${node.data} ")
}

fun bfsReturnOrder(root: BinaryTreeNode): List<List<Int>> {
    val queue = ArrayDeque<BinaryTreeNode>()
    val outputList = mutableListOf<List<Int>>()

    queue.add(root)

    while (queue.isNotEmpty()) {
        val currQueueLength = queue.size

        val list = mutableListOf<Int>()
        for (i in 0..<currQueueLength) {
            val currNode = queue.removeFirst()
            list.add(currNode.data)

            if (currNode.left != null) {
                queue.add(currNode.left!!)
            }

            if (currNode.right != null) {
                queue.add(currNode.right!!)
            }
        }
        outputList.add(list)
    }

    return outputList
}


fun bfsRecursiveTraversal(root: BinaryTreeNode): List<List<Int>> {
    val output = mutableListOf<MutableList<Int>>()
    bfsLevelOrderRecursion(root, 0, output)
    return output
}

fun bfsLevelOrderRecursion(root: BinaryTreeNode?, level: Int, output: MutableList<MutableList<Int>>) {
    if (root == null) return

    if (output.size <= level) output.add(mutableListOf())

    output[level].add(root.data)

    bfsLevelOrderRecursion(root.left, level + 1, output)
    bfsLevelOrderRecursion(root.right, level + 1, output)
}