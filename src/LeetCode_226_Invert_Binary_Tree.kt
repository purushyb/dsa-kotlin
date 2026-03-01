class LeetCode_226_Invert_Binary_Tree {
    fun invertTree(root: TreeNode?): TreeNode? {

        if(root == null) return root

        val leftNode = invertTree(root.left)
        val rightNode = invertTree(root.right)

        root.left = rightNode
        root.right = leftNode

        return root
    }
}

fun printPreOrderTree(root: TreeNode?) {
    if(root == null) return

    print("${root.`val`}, ")
    printPreOrderTree(root.left)
    printPreOrderTree(root.right)
}

fun printTree(root: TreeNode?) {
    printPreOrderTree(root)
    println()
}

fun main() {
    val problem = LeetCode_226_Invert_Binary_Tree()

    val root = TreeNode(2)
    root.left = TreeNode(1)
    root.right = TreeNode(3)
    printTree(root)

    val result = problem.invertTree(root)
    printTree(result)
}