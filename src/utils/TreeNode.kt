package utils

import TreeNode
import java.util.LinkedList
import java.util.Queue

data class TreeNode(
    val data: Int,
    val children: MutableList<TreeNode> = mutableListOf()
)


fun buildTree(values: Array<Int?>): TreeNode? {
    if (values.isEmpty() || values[0] == null) return null

    // 1. Create the root
    val root = TreeNode(values[0]!!)

    // 2. Use a Queue to keep track of nodes waiting for children
    val queue: Queue<TreeNode> = LinkedList()
    queue.offer(root)

    var i = 1
    while (i < values.size) {
        // Get the parent node
        val current = queue.poll()

        // --- Process Left Child ---
        if (i < values.size && values[i] != null) {
            val leftNode = TreeNode(values[i]!!)
            current.left = leftNode
            queue.offer(leftNode)
        }
        i++

        // --- Process Right Child ---
        if (i < values.size && values[i] != null) {
            val rightNode = TreeNode(values[i]!!)
            current.right = rightNode
            queue.offer(rightNode)
        }
        i++
    }

    return root
}