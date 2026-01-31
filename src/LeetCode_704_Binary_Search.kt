class LeetCode_704_Binary_Search {
    fun search(nums: IntArray, target: Int): Int {
        var low = 0
        var high = nums.size - 1

        while(low <= high) {
            val mid = low + (high - low) / 2
            when {
                target == nums[mid] -> return mid
                nums[mid] < target -> low = mid + 1
                else -> high = mid - 1
            }
        }

        return -1
    }
}

fun main() {
   println(LeetCode_704_Binary_Search().search(intArrayOf(-1,0,3,5,9,12), 9))
}