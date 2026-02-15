class LeetCode_70_Climbing_Steps {

    fun climbStairs(n: Int): Int {
        if(n <= 2) return n

        var a = 1
        var b = 2

        for(i in 3..n) {
            val temp = a + b
            a = b
            b = temp
        }

        return b
    }

    fun climbStairsCombinations(n: Int): Int {
        var res = 0L

        for(i in 0..n/2) {
            val totalMoves = n - i

            res += ncr(totalMoves, i)
        }

        return res.toInt()
    }

    private fun ncr(n: Int, r: Int): Int {
        if(n == r || r == 0) return 1
        if(r > n/2) ncr(n, n-r)

        var res = 1L
        for(i in 0..<r) {
            res *= (n - i)
            res /= (i + 1)
        }

        return res.toInt()
    }
}

fun main() {
    val problem = LeetCode_70_Climbing_Steps()

    val stairs = 3
    val result = problem.climbStairs(stairs)
    println(result)

    val stairs1 = 2
    val result1 = problem.climbStairs(stairs1)
    println(result1)


    val stairs2 = 5
    val result2 = problem.climbStairs(stairs2)
    println(result2)

}