class LeetCode_56_Merge_Intervals {
    fun merge(intervals: Array<IntArray>): Array<IntArray> {
        val sortedValues = intervals.sortedBy { it.first() }
        val op = mutableListOf<IntArray>()
        op.add(sortedValues[0])

        for (i in 1..<sortedValues.size) {
            val currentInterval = op.last()
            val nextInterval = sortedValues[i]

            val currentEnd = currentInterval[1]
            val nextStart = nextInterval[0]
            val nextEnd = nextInterval[1]

            if (nextStart <= currentEnd) {
                currentInterval[1] = maxOf(currentEnd, nextEnd)
            } else {
                op.add(nextInterval)
            }
        }

        return op.toTypedArray()
    }
}

fun main() {
    val problem = LeetCode_56_Merge_Intervals()
    val input = arrayOf(intArrayOf(1, 3), intArrayOf(2, 6), intArrayOf(8, 10), intArrayOf(15, 18))
    val result = problem.merge(input)
    result.forEach {
        println(it.contentToString())
    }

    val input1 = arrayOf(intArrayOf(1, 4), intArrayOf(4, 5))
    val result1 = problem.merge(input1)
    result1.forEach {
        println(it.contentToString())
    }

    val input2 = arrayOf(intArrayOf(4, 7), intArrayOf(1, 4))
    val result2 = problem.merge(input2)
    result2.forEach {
        println(it.contentToString())
    }

    val input3 = arrayOf(intArrayOf(4, 7))
    val result3 = problem.merge(input3)
    result3.forEach {
        println(it.contentToString())
    }

    val input4 = arrayOf(intArrayOf(4, 7), intArrayOf(4, 7))
    val result4 = problem.merge(input4)
    result4.forEach {
        println(it.contentToString())
    }

    val input5 = arrayOf(intArrayOf(1, 4), intArrayOf(2, 3))
    val result5 = problem.merge(input5)
    result5.forEach {
        println(it.contentToString())
    }

    val input6 = arrayOf(intArrayOf(1, 4), intArrayOf(0, 0))
    val result6 = problem.merge(input6)
    result6.forEach {
        println(it.contentToString())
    }
}