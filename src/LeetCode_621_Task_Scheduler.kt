class LeetCode_621_Task_Scheduler {
    fun leastInterval(tasks: CharArray, n: Int): Int {
        var maxFreq = 0
        val freqArr = IntArray(26)

        tasks.forEach {
            freqArr[it - 'A']++
            maxFreq = maxOf(maxFreq, freqArr[it - 'A'])
        }

        var maxFreqElementsCount = 0
        freqArr.forEach {
            if (it == maxFreq) maxFreqElementsCount++
        }

        val interval = ((maxFreq - 1) * (n + 1)) + maxFreqElementsCount
        return maxOf(tasks.size, interval)
    }
}

fun main() {
    val problem = LeetCode_621_Task_Scheduler()
    val input = charArrayOf('A', 'A', 'A', 'B', 'B', 'B')
    val result = problem.leastInterval(input, 2)
    println(result)
}