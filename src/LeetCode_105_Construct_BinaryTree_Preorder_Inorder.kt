class LeetCode_105_Construct_BinaryTree_Preorder_Inorder {
    fun buildTree(preorder: IntArray, inorder: IntArray): TreeNode? {
        val inorderMap = HashMap<Int, Int>()
        inorder.forEachIndexed { index, value -> inorderMap[value] = index }
        return buildTreeRecur(preorder, inorderMap, intArrayOf(0), 0, preorder.size - 1)
    }

    private fun buildTreeRecur(
        preorder: IntArray,
        inorderMap: HashMap<Int, Int>,
        ci: IntArray,
        l: Int,
        r: Int
    ): TreeNode? {
        if (l > r) return null

        val root = TreeNode(preorder[ci[0]])
        val index = inorderMap.getValue(root.`val`)
        ci[0]++

        root.left = buildTreeRecur(preorder, inorderMap, ci, l, index - 1)
        root.right = buildTreeRecur(preorder, inorderMap, ci, index + 1, r)

        return root
    }
}

fun printPreorder(root: TreeNode?) {
    if(root == null) {
        print("null, ")
        return
    }

    print("${root.`val`}, ")
    printPreorder(root.left)
    printPreorder(root.right)
}

fun main() {
    val problem = LeetCode_105_Construct_BinaryTree_Preorder_Inorder()
    val root = TreeNode(3)
    root.left = TreeNode(9)
    root.right = TreeNode(20)
    root.right?.left = TreeNode(15)
    root.right?.right = TreeNode(7)
    val preOrder = intArrayOf(3, 9, 20, 15, 7)
    val inorder = intArrayOf(9, 3, 15, 20, 7)

    val resultRoot = problem.buildTree(preOrder, inorder)
    printPreorder(resultRoot)
    println()
}