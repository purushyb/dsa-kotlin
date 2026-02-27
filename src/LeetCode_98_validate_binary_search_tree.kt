class LeetCode_98_validate_binary_search_tree {
    fun isValidBST(root: TreeNode?): Boolean {
        return dfsCheckBST(root,  arrayOf(null))
    }

    private fun dfsCheckBST(node: TreeNode?, prevData: Array<Int?>): Boolean {
        if(node == null) return true
        if(!dfsCheckBST(node.left, prevData)) return false

        if(prevData[0]!= null && prevData[0]!! >= node.`val`) return false
        prevData[0] = node.`val`

        if(!dfsCheckBST(node.right, prevData)) return false

        return true
    }
}

fun main() {
    val problem = LeetCode_98_validate_binary_search_tree()

    val root = TreeNode(2)
    root.left = TreeNode(1)
    root.right = TreeNode(3)
    println(problem.isValidBST(root))

    val root1 = TreeNode(5)
    root1.left = TreeNode(1)
    root1.right = TreeNode(4)
    root1.right?.left = TreeNode(3)
    root1.right?.right = TreeNode(6)
    println(problem.isValidBST(root1))

    val root2 = TreeNode(5)
    root2.left = TreeNode(1)
    root2.right = TreeNode(6)
    root2.right?.left = TreeNode(3)
    root2.right?.right = TreeNode(7)
    println(problem.isValidBST(root2))

    val root3 = TreeNode(2)
    root3.left = TreeNode(2)
    root3.right = TreeNode(2)
    println(problem.isValidBST(root3))

    val root4 = TreeNode(Int.MIN_VALUE)
    println(problem.isValidBST(root4))
}