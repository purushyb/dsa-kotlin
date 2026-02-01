class LeetCode_543_diameter_of_a_binary_tree {
    private var maxDiameter = 0
    fun diameterOfBinaryTree(root: TreeNode?): Int {
        diameter(root)
        return maxDiameter
    }

    private fun diameter(root: TreeNode?): Int {
        if (root == null) return 0

        val lheight = diameter(root.left)
        val rheight = diameter(root.right)

        maxDiameter = maxOf(maxDiameter, lheight + rheight)

        return 1 + maxOf(lheight, rheight)
    }
}

fun main() {
    val rootNode = TreeNode(1)
    rootNode.left = TreeNode(2)
    rootNode.right = TreeNode(3)

    rootNode.left?.left = TreeNode(4)
    rootNode.left?.right = TreeNode(5)

    val problem = LeetCode_543_diameter_of_a_binary_tree()
    val result = problem.diameterOfBinaryTree(rootNode)
    println(result)
}