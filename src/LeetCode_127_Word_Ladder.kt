import java.util.LinkedList

class LeetCode_127_Word_Ladder {
    fun ladderLength(beginWord: String, endWord: String, wordList: List<String>): Int {
        var transformedLength = 1
        val wordSet = wordList.toMutableSet()
        val q = LinkedList<String>()
        q.offer(beginWord)

        while (q.isNotEmpty()) {
            transformedLength++
            for (i in 0..<q.size) {
                val currWord = StringBuilder(q.poll())
                for (j in 0..<currWord.length) {
                    val currChar = currWord[j]
                    for (k in 0..<26) {
                        currWord[j] = 'a' + k
                        val word = currWord.toString()
                        if (!wordSet.contains(word)) continue
                        if (word.equals(endWord)) return transformedLength
                        q.offer(word)
                        wordSet.remove(word)
                    }
                    currWord[j] = currChar
                }
            }
        }
        return 0
    }
}

fun main() {
    val problem = LeetCode_127_Word_Ladder()

    val input = listOf("hot","dot","dog","lot","log","cog")
    val beginWord = "hit"
    val endWord = "cog"
    val result = problem.ladderLength(beginWord, endWord, input)
    println(result)

    val input1 = listOf("hot","dot","dog","lot","log")
    val beginWord1 = "hit"
    val endWord1 = "cog"
    val result1 = problem.ladderLength(beginWord1, endWord1, input1)
    println(result1)
}