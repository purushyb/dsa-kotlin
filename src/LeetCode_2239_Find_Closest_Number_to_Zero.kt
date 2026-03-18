import kotlin.math.abs

class LeetCode_2239_Find_Closest_Number_to_Zero {
    fun findClosestNumber(nums: IntArray): Int {
        var nn = Int.MAX_VALUE
        var d = Int.MAX_VALUE

        nums.forEach {
            val nd = abs(0 - it)
            if(nd < d || nd == d && it > nn) {
                nn = it
                d = nd
            }
        }

        return nn
    }
}

fun main() {
    val problem = LeetCode_2239_Find_Closest_Number_to_Zero()
    val input = intArrayOf(-4,-2,1,4,8)
    val result = problem.findClosestNumber(input)
    println(result)
}