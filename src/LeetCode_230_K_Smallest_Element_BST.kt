class LeetCode_230_K_Smallest_Element_BST {
    fun kthSmallest(root: TreeNode?, k: Int): Int {
        val result = intArrayOf(-1)
        findNodeInorder(root, k, intArrayOf(0), result)
        return result[0]
    }

    private fun findNodeInorder(node: TreeNode?, k: Int, ci: IntArray, result: IntArray) {
        if (node == null || ci[0] >= k) return


        findNodeInorder(node = node.left, k, ci, result)

        ci[0]++
        if (ci[0] == k) {
            result[0] = node.`val`
            return
        }
        findNodeInorder(node.right, k, ci, result)
    }
}


fun main() {
    val problem = LeetCode_230_K_Smallest_Element_BST()

//    val root = TreeNode(3)
//    root.left = TreeNode(1)
//    root.right = TreeNode(4)
//    root.left?.right = TreeNode(2)
//    val result = problem.kthSmallest(root, 1)
//    println(result)

    val root1 = TreeNode(5)
    root1.left = TreeNode(3)
    root1.left?.right = TreeNode(4)
    root1.left?.left = TreeNode(2)
    root1.left?.left?.left = TreeNode(1)
    root1.right = TreeNode(6)
    val result1 = problem.kthSmallest(root1, 3)
    println(result1)
}