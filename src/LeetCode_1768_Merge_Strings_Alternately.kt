class LeetCode_1768_Merge_Strings_Alternately {

    fun mergeAlternately(word1: String, word2: String): String {
        val result = StringBuilder()
        val min = minOf(word1.length, word2.length)
        for (i in 0..<min) {
            result.append(word1[i])
            result.append(word2[i])
        }

        result.append(word1.substring(min))
        result.append(word2.substring(min))

        return result.toString()
    }

    fun mergeAlternatelyNaive(word1: String, word2: String): String {
        val s1 = word1.length
        val s2 = word2.length
        var l = 0
        var r = 0
        val result = StringBuilder()
        while (l < s1 && r < s2) {
            if ((((l + r) % 2) == 0)) {
                result.append(word1[l])
                l++
            } else {
                result.append(word2[r])
                r++
            }
        }

        while (l < s1) {
            result.append(word1[l])
            l++
        }

        while (r < s2) {
            result.append(word2[r])
            r++
        }

        return result.toString()
    }
}

fun main() {
    val problem = LeetCode_1768_Merge_Strings_Alternately()
    val w1 = "abc"
    val w2 = "pqr"
    println(problem.mergeAlternately(w1, w2))
}