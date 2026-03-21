class LeetCode_13_Roman_To_Integer {
    val map = mapOf('I' to 1, 'V' to 5, 'X' to 10, 'L' to 50, 'C' to 100, 'D' to 500, 'M' to 1000)

    fun romanToInt(s: String): Int {
        var res = 0
        var prev = 0

        for(i in s.indices.reversed()) {
            val curr = map[s[i]]!!
            if(curr < prev) {
                res -= curr
            }
            else {
                res += curr
            }
            prev = curr
        }
        return res
    }


    fun romanToIntNaive(s: String): Int {
        var res = 0

        var i = 0
        while (i < s.length) {
            var setback = 0
            while (i < (s.length - 1) && map[s[i]]!! < map[s[i + 1]]!!) {
                setback += map[s[i]]!!
                i++
            }
            res += map[s[i]]!! - setback
            i++
        }
        return res
    }
}

fun main() {
    val problem = LeetCode_13_Roman_To_Integer()
    val input = "MCMXCIV"
    val res = problem.romanToInt(input)
    println(res)
}