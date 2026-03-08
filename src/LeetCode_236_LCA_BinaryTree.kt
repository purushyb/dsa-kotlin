class LeetCode_236_LCA_BinaryTree {
    fun lowestCommonAncestor(root: TreeNode?, p: TreeNode?, q: TreeNode?): TreeNode? {
        if (root == null) return root

        if (root.`val` == p?.`val`
            || root.`val` == q?.`val`
        ) return root

        val ln = lowestCommonAncestor(root.left, p, q)
        val rn = lowestCommonAncestor(root.right, p, q)

        if (ln != null && rn != null) return root
        return ln ?: rn
    }
}

fun buildTree(arr: Array<Int?>): TreeNode? {
    // Edge case: Empty array or root is null
    if (arr.isEmpty() || arr[0] == null) return null

    val root = TreeNode(arr[0]!!)
    val queue = ArrayDeque<TreeNode>()
    queue.addLast(root)

    var i = 1 // Pointer to track our position in the array

    while (queue.isNotEmpty() && i < arr.size) {
        // Pop the next available parent node
        val currNode = queue.removeFirst()

        // 1. Check and assign the LEFT child
        if (i < arr.size) {
            val leftVal = arr[i]
            if (leftVal != null) {
                currNode.left = TreeNode(leftVal)
                queue.addLast(currNode.left!!) // Queue it up to be a future parent
            }
            i++
        }

        // 2. Check and assign the RIGHT child
        if (i < arr.size) {
            val rightVal = arr[i]
            if (rightVal != null) {
                currNode.right = TreeNode(rightVal)
                queue.addLast(currNode.right!!) // Queue it up to be a future parent
            }
            i++
        }
    }

    return root
}

fun main() {
    val problem = LeetCode_236_LCA_BinaryTree()

    val input = arrayOf(3, 5, 1, 6, 2, 0, 8, null, null, 7, 4)
    val root = buildTree(input)
    val result = problem.lowestCommonAncestor(root, TreeNode(5), TreeNode(1))
    println(result?.`val`)

    val input1 = arrayOf<Int?>(1, 2)
    val root1 = buildTree(input1)
    val result1 = problem.lowestCommonAncestor(root1, TreeNode(1), TreeNode(2))
    println(result1?.`val`)

    val input2 = arrayOf(3, 5, 1, 6, 2, 0, 8, null, null, 7, 4)
    val root2 = buildTree(input2)
    val result2 = problem.lowestCommonAncestor(root2, TreeNode(5), TreeNode(4))
    println(result2?.`val`)
}