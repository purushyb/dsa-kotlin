class LeetCode_208_implement_Trie {
    private class TrieNode {
        var isEow: Boolean = false
        val children = Array<TrieNode?>(26) { null }
    }

    private val rootNode = TrieNode()

    fun insert(word: String) {
        var cNode = rootNode
        for (currChar in word) {
            val currIdx = currChar - 'a'
            if (cNode.children[currIdx] == null) {
                cNode.children[currIdx] = TrieNode()
            }
            cNode = cNode.children[currIdx]!!
        }

        cNode.isEow = true
    }

    fun search(word: String): Boolean {
        var cNode = rootNode

        for (i in 0..<word.length) {
            val currChar = word[i] - 'a'
            if (cNode.children[currChar] == null) {
                return false
            }
            cNode = cNode.children[currChar]!!
        }

        return cNode.isEow
    }

    fun startsWith(prefix: String): Boolean {
        var cNode = rootNode

        for (i in 0..<prefix.length) {
            val currChar = prefix[i] - 'a'
            if (cNode.children[currChar] == null) {
                return false
            }
            cNode = cNode.children[currChar]!!
        }
        return true
    }
}

fun main() {
    val problem = LeetCode_208_implement_Trie()
    problem.insert("apple")
    println(problem.search("apple"))
    println(problem.search("app"))
    println(problem.startsWith("app"))
    problem.insert("app")
    println(problem.search("app"))
}