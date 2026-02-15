import utils.buildTree
import java.util.LinkedList
import java.util.Queue

class TreeNode(var `val`: Int) {
    var left: TreeNode? = null
    var right: TreeNode? = null
}

class LeetCode_297_serialize_and_desearlize_binary_tree {

    // Encodes a URL to a shortened URL.
    fun serialize(root: TreeNode?): String {
        val result = StringBuilder()
        dfsSerialize(root, result)
        return result.toString()
    }

    private fun dfsSerialize(node: TreeNode?, result: StringBuilder) {
        if (node == null) {
            result.append("#")
            return
        }

        result.append(node.`val`).append(',')
        dfsSerialize(node.left, result)
        dfsSerialize(node.right, result)
    }

    private fun dfsDeSerialize(serializedString: String, pos: Array<Int>): TreeNode? {
        if (serializedString[pos[0]] == '#') {
            pos[0]++
            return null
        }

        var multiplier = 1
        if (serializedString[pos[0]] == '-') {
            multiplier = -1
            pos[0]++
        }

        var currDigit = 0
        while(serializedString[pos[0]] != ',') {
            currDigit = currDigit * 10 + (serializedString[pos[0]] - '0')
            pos[0]++
        }
        pos[0]++
        currDigit *= multiplier

        val newNode = TreeNode(currDigit)

        newNode.left = dfsDeSerialize(serializedString, pos)
        newNode.right = dfsDeSerialize(serializedString, pos)

        return newNode
    }

    // Decodes your encoded data to tree.
    fun deserialize(data: String): TreeNode? {
        val result = dfsDeSerialize(data, arrayOf(0))
        return result
    }
}


fun main() {
    // The input array (Use null for empty spots)
    val input = arrayOf(1, 223, 31, null, null, 44, 5)

    val root = buildTree(input)
    val problem = LeetCode_297_serialize_and_desearlize_binary_tree()
    val serializeString = problem.serialize(root)
    println(serializeString)
    val newRoot = problem.deserialize(serializeString)
    println(problem.serialize(newRoot))
}