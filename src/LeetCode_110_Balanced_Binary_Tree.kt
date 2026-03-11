import kotlin.math.abs

class LeetCode_110_Balanced_Binary_Tree {
    fun isBalanced(root: TreeNode?): Boolean {
        if(root == null) return true
        return checkBalanceRec(root) > 0
    }

    private fun checkBalanceRec(root: TreeNode?): Int {
        if(root == null) return 0

        val lh = checkBalanceRec(root.left)
        val rh = checkBalanceRec(root.right)

        if(lh == -1 || rh == -1 || abs(lh - rh) > 1) return -1

        return maxOf(lh, rh) + 1
    }
}

fun main() {
    val problem = LeetCode_110_Balanced_Binary_Tree()

    val root = TreeNode(3)
    root.left = TreeNode(9)
    root.right = TreeNode(20)
    root.right?.right = TreeNode(7)
    root.right?.left = TreeNode(15)

    println(problem.isBalanced(root))

}