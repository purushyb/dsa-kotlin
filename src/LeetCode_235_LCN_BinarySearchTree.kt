class LeetCode_235_LCN_BinarySearchTree {
    fun lowestCommonAncestor(root: TreeNode?, p: TreeNode?, q: TreeNode?): TreeNode? {
        var cn = root

        while(cn!= null && p!= null && q!= null) {
            if(cn.`val` < p.`val` && cn.`val` < q.`val`) {
                cn = cn.right
            }
            else if(cn.`val` > p.`val` && cn.`val` > q.`val`) {
                cn = cn.left
            }
            else return cn
        }

        return null

    }

    fun lowestCommonAncestorNaive(root: TreeNode?, p: TreeNode?, q: TreeNode?): TreeNode? {
        if (p == null) return q
        if (q == null) return p
        val s1 = arrayListOf<Int>()
        val s2 = arrayListOf<Int>()
        val nodesRef = HashMap<Int, TreeNode?>()

        dfs(root, p.`val`, s1, nodesRef)
        dfs(root, q.`val`, s2, nodesRef)

        return if (s1.size < s2.size) findCommonAncestor(s1, s2, nodesRef) else findCommonAncestor(s2, s1, nodesRef)

    }


    private fun findCommonAncestor(s1: ArrayList<Int>, s2: ArrayList<Int>, hMap: HashMap<Int, TreeNode?>): TreeNode? {
        for (i in (s1.size - 1) downTo 0) {
            if (s2[i] == s1[i]) return hMap[s1[i]]
        }

        throw Exception("No such ancestor exists")
    }

    private fun dfs(r: TreeNode?, n: Int, hs: ArrayList<Int>, hMap: HashMap<Int, TreeNode?>) {
        if (r == null) throw Exception("Element not found in the tree")
        if (r.`val` == n) {
            hs.add(r.`val`)
            return
        }

        hs.add(r.`val`)
        hMap[r.`val`] = r
        if (n < r.`val`) dfs(r.left, n, hs, hMap)
        else dfs(r.right, n, hs, hMap)
    }
}

fun buildBinarySearchTree(arr: Array<Int?>): TreeNode? {
    if (arr.isEmpty() || arr[0] == null) return null

    val root = TreeNode(arr[0]!!)
    val queue = ArrayDeque<TreeNode>()
    queue.addLast(root)

    var i = 1 // Pointer for iterating through the array

    while (queue.isNotEmpty() && i < arr.size) {
        // Get the next available parent from the queue
        val currNode = queue.removeFirst()

        // 1. Process the Left Child
        if (i < arr.size) {
            val leftVal = arr[i]
            if (leftVal != null) {
                currNode.left = TreeNode(leftVal)
                queue.addLast(currNode.left!!) // Queue it up to be a future parent
            }
            i++ // Move to the next element in the array
        }

        // 2. Process the Right Child
        if (i < arr.size) {
            val rightVal = arr[i]
            if (rightVal != null) {
                currNode.right = TreeNode(rightVal)
                queue.addLast(currNode.right!!) // Queue it up to be a future parent
            }
            i++ // Move to the next element in the array
        }
    }

    return root
}

fun main() {
    val problem = LeetCode_235_LCN_BinarySearchTree()

    val ip = arrayOf(6,2,8,0,4,7,9,null,null,3,5)
    val root = buildBinarySearchTree(ip)
    val result = problem.lowestCommonAncestor(root, TreeNode(2), TreeNode(8))
    println(result?.`val`)

    val ip1 = arrayOf(6,2,8,0,4,7,9,null,null,3,5)
    val root1 = buildBinarySearchTree(ip1)
    val result1 = problem.lowestCommonAncestor(root1, TreeNode(2), TreeNode(4))
    println(result1?.`val`)

    val ip2 = arrayOf<Int?>(2, 1)
    val root2 = buildBinarySearchTree(ip2)
    val result2 = problem.lowestCommonAncestor(root2, TreeNode(2), TreeNode(1))
    println(result2?.`val`)
}