class LeetCode_438_Find_All_Anagrams {
    fun findAnagrams(s: String, p: String): List<Int> {
        val op = mutableListOf<Int>()
        if (p.length > s.length) return op

        val wCount = IntArray(256)
        val pCount = IntArray(256)

        for (i in 0..<p.length) {
            pCount[p[i].code]++
            wCount[s[i].code]++
        }

        if (pCount.contentEquals(wCount)) {
            op.add(0)
        }

        for (i in p.length..<s.length) {
            wCount[s[i - p.length].code]--
            wCount[s[i].code]++

            if (pCount.contentEquals(wCount)) {
                op.add(i - p.length + 1)
            }
        }

        return op
    }
}

fun main() {
    val problem = LeetCode_438_Find_All_Anagrams()


    val s = "cbaebabacd"
    val p = "abc"
    val result = problem.findAnagrams(s, p)
    println(result)

    val s4 = "abab"
    val p4 = "ab"
    val result4 = problem.findAnagrams(s4, p4)
    println(result4)

    val s1 = "a"
    val p1 = "a"
    val result1 = problem.findAnagrams(s1, p1)
    println(result1)

    val s2 = "a"
    val p2 = "ab"
    val result2 = problem.findAnagrams(s2, p2)
    println(result2)

    val s3 = "aa"
    val p3 = "a"
    val result3 = problem.findAnagrams(s3, p3)
    println(result3)

    val s5 = "abab"
    val p5 = "ab"
    val result5 = problem.findAnagrams(s5, p5)
    println(result5)

    val s6 = "aa"
    val p6 = "bb"
    val result6 = problem.findAnagrams(s6, p6)
    println(result6)
}