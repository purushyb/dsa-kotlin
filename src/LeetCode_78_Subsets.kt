class LeetCode_78_Subsets {
    fun subsets(nums: IntArray): List<List<Int>> {
        val result = mutableListOf<List<Int>>()
        subsetsRecur(0, nums, mutableListOf<Int>(), result)
        return result
    }

    private fun subsetsRecur(
        index: Int,
        nums: IntArray,
        subsets: MutableList<Int>,
        result: MutableList<List<Int>>
    ) {

        if (index == nums.size) {
            result.add(subsets.toList())
            return
        }

        subsets.add(nums[index])
        subsetsRecur(index + 1, nums, subsets, result)

        subsets.removeLast()
        subsetsRecur(index + 1, nums, subsets, result)
    }
}

fun main() {
    val problem = LeetCode_78_Subsets()
    val input = intArrayOf(1,2,3)
    val result = problem.subsets(input)

    println(result)
}