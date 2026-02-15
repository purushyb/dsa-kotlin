class LeetCode_76_Minimum_Window_Substring {
    fun minWindow(s: String, t: String): String {
        val freq = IntArray(128)

        for(i in t) freq[i.code]++

        var minWindowSize = Int.MAX_VALUE
        var count = t.length
        var startIndex = 0

        var start = 0
        var end = 0

        while(end < s.length) {
            val endChar = s[end]

            if(freq[endChar.code] > 0) {
                count--
            }

            freq[endChar.code]--
            end++

            while(count == 0) {
                val windowSize = end - start
                if(windowSize < minWindowSize) {
                    minWindowSize = windowSize
                    startIndex = start
                }

                val startChar = s[start]
                freq[startChar.code]++
                if(freq[startChar.code] > 0) {
                    count++
                }

                start++
            }
        }



        return if (minWindowSize == Int.MAX_VALUE) "" else s.substring(startIndex, startIndex + minWindowSize)
    }
}

fun main() {
    val problem = LeetCode_76_Minimum_Window_Substring()

    val s = "ADOBECODEBANC"
    val t = "ABC"
    val result = problem.minWindow(s, t)
    println(result)

    val s1 = "a"
    val t1 = "a"
    val result1 = problem.minWindow(s1, t1)
    println(result1)

    val s2= "a"
    val t2 = "aa"
    val result2 = problem.minWindow(s2, t2)
    println(result2)

    val s3 = "aA"
    val t3 = "Aa"
    val result3 = problem.minWindow(s3, t3)
    println(result3)

    val s4 = "BONAC"
    val t4 = "ABC"
    val result4 = problem.minWindow(s4, t4)
    println(result4)

    val s5 = "BONACC"
    val t5 = "ABCC"
    val result5 = problem.minWindow(s5, t5)
    println(result5)
}