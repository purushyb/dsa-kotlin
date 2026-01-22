object LeetCode_139_Word_Break {
    fun wordBreak(s: String, wordDict: List<String>): Boolean {
        val wordsSet = HashSet<String>(wordDict)
        return wordBreakRecur(s, wordsSet, 0, Array<Boolean?>(s.length) { null })
    }

    fun wordBreakRecur(s: String, wordsDict: HashSet<String>, idx: Int, memo: Array<Boolean?>): Boolean {
        if(idx == s.length) return true

        if(memo[idx] != null) return memo[idx]!!

        val currString = StringBuilder()

        for(i in idx..<s.length){
            currString.append(s[i])

            if (wordsDict.contains(currString.toString()) && wordBreakRecur(s, wordsDict, i + 1, memo)) {
                memo[idx] = true
                return memo[idx]!!
            }
        }

        memo[idx] = false
        return memo[idx]!!
    }
}

fun main() {
    val s = "leetcode"
    val wordsDict = listOf("leet","code")

    println(LeetCode_139_Word_Break.wordBreak(s, wordsDict))
}