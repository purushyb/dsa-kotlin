class LeetCode_392_is_Subsequence {
    fun isSubsequence(s: String, t: String): Boolean {
        var i = 0
        var j = 0

        while(j < t.length && i < s.length) {
            if(s[i] == t[j]) i++
            j++
        }

        return i == s.length
    }
}

fun main() {
    val problem = LeetCode_392_is_Subsequence()

    val s = "abc"
    val t = "ahbgdc"
    println(problem.isSubsequence(s ,t))

    val s1 = "axc"
    val t1 = "ahbgdc"
    println(problem.isSubsequence(s1 ,t1))
}