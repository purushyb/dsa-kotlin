class LeetCode_33_Search_in_Rotated_Sorted_Array {
    fun search(nums: IntArray, target: Int): Int {
        return binarySearch(nums, target)
    }

    private fun binarySearch(nums: IntArray, target: Int): Int {
        var low: Int = 0
        var high: Int = nums.size - 1
        while (low <= high) {
            val mid = low + (high - low) / 2

            if (nums[mid] == target) return mid

            // find left sorted Array
            if (nums[mid] >= nums[low]) {
                if (target < nums[mid] && target >= nums[low]) {
                    high = mid - 1
                } else {
                    low = mid + 1
                }
            } else {
                if (target > nums[mid] && target <= nums[high]) {
                    low = mid + 1
                } else {
                    high = mid - 1
                }
            }
        }

        return -1
    }
}

fun main() {
    val input = intArrayOf(3, 1)
    println(LeetCode_33_Search_in_Rotated_Sorted_Array().search(input, 1))
}