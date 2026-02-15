class LeetCode_1235_Maximum_profit_in_job_scheduling {
    private lateinit var jobs: Array<IntArray>
    private lateinit var memo: IntArray

    fun jobScheduling(startTime: IntArray, endTime: IntArray, profit: IntArray): Int {
        jobs = Array(startTime.size) { IntArray(3) }
        memo = IntArray(startTime.size)

        for (i in 0..<startTime.size) {
            jobs[i] = intArrayOf(startTime[i], endTime[i], profit[i])
        }

        jobs.sortBy { it[0] }

        return dfs(0)
    }

    private fun dfs(index: Int): Int {
        if (index >= jobs.size) return 0
        if (memo[index] != 0) return memo[index]

        val currProfit = jobs[index][2]
        val endTime = jobs[index][1]

        val nI = search(endTime, index + 1)
        memo[index] = maxOf((currProfit + dfs(nI)), dfs(index + 1))
        return memo[index]
    }

    private fun search(target: Int, sI: Int): Int {
        var low = sI
        var high = jobs.size

        while (low < high) {
            val mid = low + ((high - low) / 2)
            if (jobs[mid][0] >= target) {
                high = mid
            } else {
                low = mid + 1
            }
        }
        return low
    }
}

fun main() {
    val problem = LeetCode_1235_Maximum_profit_in_job_scheduling()

    val startTimes = intArrayOf(1, 2, 3, 3)
    val endTimes = intArrayOf(3, 4, 5, 6)
    val profits = intArrayOf(50, 10, 40, 70)
    val result = problem.jobScheduling(startTimes, endTimes, profits)

    println(result)
}