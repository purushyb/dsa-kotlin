class LeetCode_57_Insert_Interval {
    fun insertMySolution(intervals: Array<IntArray>, newInterval: IntArray): Array<IntArray> {
        val op = mutableListOf<IntArray>()
        var index = 0

        while (index < intervals.size && intervals[index][1] < newInterval[0]) {
            op.add(intervals[index])
            index++
        }

        op.add(newInterval)

        for (i in index..<intervals.size) {
            val lastInterval = op.last()
            val currInterval = intervals[i]
            if (currInterval[0] <= lastInterval[1]) {
                lastInterval[0] = minOf(lastInterval[0], currInterval[0])
                lastInterval[1] = maxOf(lastInterval[1], currInterval[1])
            } else {
                op.add(intervals[i])
            }
        }

        return op.toTypedArray()
    }


    fun insert(intervals: Array<IntArray>, newInterval: IntArray): Array<IntArray> {
        val op = mutableListOf<IntArray>()
        var index = 0

        while (index < intervals.size && intervals[index][1] < newInterval[0]) {
            op.add(intervals[index])
            index++
        }

        var currStart = newInterval[0]
        var currEnd = newInterval[1]

        while(index < intervals.size && intervals[index][0] <= currEnd) {
            currStart = minOf(currStart, intervals[index][0])
            currEnd = maxOf(currEnd, intervals[index][1])
            index++
        }

        op.add(intArrayOf(currStart, currEnd))

        while(index < intervals.size) {
            op.add(intervals[index])
            index++
        }

        return op.toTypedArray()
    }
}


fun main() {
    val problem = LeetCode_57_Insert_Interval()

    println("===================")
    // insert and merge condition
    val input0 = arrayOf<IntArray>()
    val newInterval0 = intArrayOf(4, 8)
    val result0 = problem.insert(input0, newInterval0)

    result0.forEach {
        println(it.contentToString())
    }

    println("===================")

    // insert condition
    val input = arrayOf(intArrayOf(1, 3), intArrayOf(6, 9))
    val newInterval = intArrayOf(2, 5)
    val result = problem.insert(input, newInterval)

    result.forEach {
        println(it.contentToString())
    }

    println("===================")
    // insert and merge condition
    val input1 = arrayOf(intArrayOf(1, 2), intArrayOf(3, 5), intArrayOf(6, 7), intArrayOf(8, 10), intArrayOf(12, 16))
    val newInterval1 = intArrayOf(4, 8)
    val result1 = problem.insert(input1, newInterval1)

    result1.forEach {
        println(it.contentToString())
    }

    println("===================")
    // insert Before Condition
    val input2 = arrayOf(intArrayOf(2, 3))
    val newInterval2 = intArrayOf(1, 1)
    val result2 = problem.insert(input2, newInterval2)

    result2.forEach {
        println(it.contentToString())
    }

    println("===================")
    // insert After Condition
    val input3 = arrayOf(intArrayOf(1, 2))
    val newInterval3 = intArrayOf(3, 4)
    val result3 = problem.insert(input3, newInterval3)

    result3.forEach {
        println(it.contentToString())
    }


    println("===================")
    // insert Before Condition
    val input4 = arrayOf(intArrayOf(3, 4))
    val newInterval4 = intArrayOf(1, 2)
    val result4 = problem.insert(input4, newInterval4)

    result4.forEach {
        println(it.contentToString())
    }

}
