class LeetCode_238_Product_Of_Array_Except_Self {
    fun productExceptSelf(nums: IntArray): IntArray {
        val result = IntArray(nums.size)
        var lp = 1
        for (i in 0 until nums.size) {
            result[i] = lp
            lp *= nums[i]
        }

        var rp = 1
        for (i in nums.size - 1 downTo 0) {
            result[i] *= rp
            rp *= nums[i]
        }
        return result
    }
}

fun main() {
    val problem = LeetCode_238_Product_Of_Array_Except_Self()
    val input = intArrayOf(1, 2, 3, 4)
    val result = problem.productExceptSelf(input)
    println(result.contentToString())
}