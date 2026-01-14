fun main() {
    val rootNode = TrieNode()

    insert("help", rootNode)
    insert("hello", rootNode)
    insert("cat", rootNode)

    println(search("hello", rootNode))

    println(isPrefix("hell", rootNode))
    println(getSuggestions("hel", rootNode))
}

data class TrieNode(
    val children: MutableMap<Char, TrieNode> = sortedMapOf<Char, TrieNode>(),
    var isEndOfWord: Boolean = false
)

fun insert(word: String, root: TrieNode) {
    var current = root
    for (char in word) {
        current = current.children.getOrPut(char) { TrieNode() }
    }
    current.isEndOfWord = true
}

fun search(word: String, root: TrieNode): Boolean {
    var currNode = root

    for(i in word) {
        if(currNode.children[i] != null) {
            currNode = currNode.children[i]!!
        }
    }
    return currNode.isEndOfWord
}

fun isPrefix(word: String, root: TrieNode): Boolean {
    var currNode = root

    for(i in word) {
        if(currNode.children[i] == null) {
            return false
        }
        currNode = currNode.children[i]!!
    }
    return true
}

fun getSuggestions(prefix: String, root: TrieNode): List<String> {
    var current = root

    for (char in prefix) {
        val node = current.children[char] ?: return emptyList()
        current = node
    }

    val results = mutableListOf<String>()
    collectWords(current, StringBuilder(prefix), results)
    return results
}

private fun collectWords(node: TrieNode, currentWord: StringBuilder, results: MutableList<String>) {
    if (node.isEndOfWord) {
        results.add(currentWord.toString())
    }

    for ((char, childNode) in node.children) {
        currentWord.append(char)
        collectWords(childNode, currentWord, results)
        currentWord.deleteCharAt(currentWord.length - 1)
    }
}