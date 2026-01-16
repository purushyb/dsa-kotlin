object LeetCode_1_TwoSum_Solution {
    fun twoSum(nums: IntArray, target: Int): IntArray {
        val map = mutableMapOf<Int, Int>()

        nums.forEachIndexed { i, currNum ->
            val required = target - currNum

            val targetIndex = map.getOrDefault(required, -1)
            if (targetIndex != -1) {
                return intArrayOf(targetIndex, i)
            }

            map[currNum] = i
        }

        throw Exception("No solution found")
    }
}

fun main() {
    val input1 = intArrayOf(2,7,11,15)
    val target1 = 9

    println(LeetCode_1_TwoSum_Solution.twoSum(input1, target1).contentToString())

    val input2 = intArrayOf(3,2,4)
    val target2 = 6

    println(LeetCode_1_TwoSum_Solution.twoSum(input2, target2).contentToString())

    val input3 = intArrayOf(3,3)
    val target3 = 6

    println(LeetCode_1_TwoSum_Solution.twoSum(input3, target3).contentToString())
}