class LeetCode_167_Two_Sum_Input_Array_Sorted {
    fun twoSum(numbers: IntArray, target: Int): IntArray {
        var lp = 0
        var rp = numbers.size - 1

        while (lp < rp) {
            val currSum = numbers[lp] + numbers[rp]

            when {
                currSum > target -> rp--
                currSum < target -> lp++
                else -> return intArrayOf(lp + 1, rp + 1)
            }
        }

        throw Exception("No such element exists")
    }
}

fun main() {
    val problem = LeetCode_167_Two_Sum_Input_Array_Sorted()

    val input = intArrayOf(2, 7, 11, 15)
    val result = problem.twoSum(input, 9)
    println(result.contentToString())

    val input1 = intArrayOf(2, 3, 4)
    val result1 = problem.twoSum(input1, 6)
    println(result1.contentToString())

    val input2 = intArrayOf(-1, 0)
    val result2 = problem.twoSum(input2, -1)
    println(result2.contentToString())
}