class LeetCode_62_unique_paths {
    fun uniquePaths(m: Int, n: Int): Int {
        val totalSteps = m + n - 2

        val r = minOf(n - 1, m - 1)
        var result = 1L

        for (i in 1..r) {
            result = (result * (totalSteps - r + i) )/ i
        }

        return result.toInt()
    }
}

fun main() {
    val problem = LeetCode_62_unique_paths()
    val m = 3
    val n = 7
    val result = problem.uniquePaths(m, n)
    println(result)

    val m1 = 4
    val n1 = 4
    val result1 = problem.uniquePaths(m1, n1)
    println(result1)
}