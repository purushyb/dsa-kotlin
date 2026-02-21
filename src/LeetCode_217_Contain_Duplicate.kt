class LeetCode_217_Contain_Duplicate {
    fun containsDuplicate(nums: IntArray): Boolean {
        val hashSet = HashSet<Int>(nums.size + 1)

        for(i in nums) {
            if(!hashSet.add(i)) return true
        }

        return false
    }
}

fun main() {
    val problem = LeetCode_217_Contain_Duplicate()

    val nums = intArrayOf(1,2,3,1)
    val result = problem.containsDuplicate(nums)
    println(result)

    val nums2 = intArrayOf(1,2,3,4)
    val result2 = problem.containsDuplicate(nums2)
    println(result2)

    val nums3 = intArrayOf(1,1,1,3,3,4,3,2,4,2)
    val result3 = problem.containsDuplicate(nums3)
    println(result3)
}