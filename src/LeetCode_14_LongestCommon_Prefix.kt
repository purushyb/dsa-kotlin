class LeetCode_14_LongestCommon_Prefix {

    fun longestCommonPrefix(strs: Array<String>): String {
        val minStr: String = strs.minOrNull() ?: return ""
        val maxStr: String = strs.maxOrNull() ?: return ""
        var i = 0

        while (i < minStr.length && i < maxStr.length && minStr[i] == maxStr[i]) i++

        return minStr.substring(0, i)
    }

    fun longestCommonPrefixNaive(strs: Array<String>): String {
        var res = ""
        val minStr: String = strs.minBy { it.length }
        for (i in 0..<minStr.length) {
            for (j in strs) {
                if (minStr[i] != j[i]) return res
            }
            res += minStr[i]
        }
        return res
    }
}

fun main() {
    val problem = LeetCode_14_LongestCommon_Prefix()
    val input = arrayOf("flower", "flow", "flight")
    println(problem.longestCommonPrefix(input))
}