class LeetCode_104_Maximum_Depth_Of_Binary_Tree {
    fun maxDepth(root: TreeNode?): Int {
        if(root == null) return 0

        val lH = maxDepth(root.left)
        val rH = maxDepth(root.right)

        return 1 + maxOf(lH, rH)
    }
}

fun main() {
    val problem = LeetCode_104_Maximum_Depth_Of_Binary_Tree()

    val root = TreeNode(3)
    root.left = TreeNode(9)
    root.right = TreeNode(20)
    root.right?.left = TreeNode(15)
    root.right?.right = TreeNode(7)
    val result = problem.maxDepth(root)
    println(result)

    val root1 = TreeNode(1)
    root1.right = TreeNode(2)
    println(problem.maxDepth(root1))
}