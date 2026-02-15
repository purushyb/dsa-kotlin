import utils.buildTree
import java.util.ArrayDeque

class LeetCode_199_BinaryTree_Right_Side_View {

    fun rightSideView(root: TreeNode?): List<Int> {

        val op = mutableListOf<Int>()
        if (root == null) return op

        val q = ArrayDeque<TreeNode>()
        q.add(root)

        while (q.isNotEmpty()) {
            val currLen = q.size
            op.add(q.peekLast().`val`)

            for (i in 0..<currLen) {
                val currEle = q.removeFirst()
                currEle.left?.let { q.addLast(it) }
                currEle.right?.let { q.addLast(it) }
            }
        }

        return op
    }

    fun rightSideViewNaive(root: TreeNode?): List<Int> {

        val op = mutableListOf<Int>()
        if (root == null) return op

        val q = ArrayDeque<TreeNode>()
        q.add(root)

        while (q.isNotEmpty()) {
            val currLen = q.size
            op.add(q.last().`val`)

            for (i in 0..<currLen) {
                val currEle = q.removeFirst()
                currEle.left?.let { q.addLast(it) }
                currEle.right?.let { q.addLast(it) }
            }
        }

        return op
    }
}

fun main() {
    val problem = LeetCode_199_BinaryTree_Right_Side_View()

    val treeRoot = buildTree(arrayOf(1, 2, 3, null, 5, null, 4))
    val result = problem.rightSideView(treeRoot)
    println(result)

    val treeRoot1 = buildTree(arrayOf(1, 2, 3, 4, null, null, null, 5))
    val result1 = problem.rightSideView(treeRoot1)
    println(result1)

    val treeRoot2 = buildTree(arrayOf())
    val result2 = problem.rightSideView(treeRoot2)
    println(result2)

    val treeRoot3 = buildTree(arrayOf(1, null, 3))
    val result3 = problem.rightSideView(treeRoot3)
    println(result3)
}