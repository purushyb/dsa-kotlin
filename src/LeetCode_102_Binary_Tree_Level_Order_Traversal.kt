import java.util.LinkedList

class LeetCode_102_Binary_Tree_Level_Order_Traversal {
    fun levelOrder(root: TreeNode?): List<List<Int>> {
        val result = mutableListOf<List<Int>>()
        if (root == null) return result

        val q = LinkedList<TreeNode>()
        q.offer(root)

        while (q.isNotEmpty()) {
            val res = mutableListOf<Int>()
            for (i in 0..<q.size) {
                val cn = q.poll()
                res.add(cn.`val`)
                if (cn.left != null) q.offer(cn.left)
                if (cn.right != null) q.offer(cn.right)
            }
            result.add(res)
        }
        return result
    }
}

fun main() {
    val problem = LeetCode_102_Binary_Tree_Level_Order_Traversal()

    val root = TreeNode(3)
    root.left = TreeNode(9)
    root.right = TreeNode(20)
    root.right?.left = TreeNode(15)
    root.right?.right = TreeNode(7)
    val result = problem.levelOrder(root)
    println(result)
}