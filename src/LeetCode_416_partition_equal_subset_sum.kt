class LeetCode_416_partition_equal_subset_sum {
    fun canPartition(nums: IntArray): Boolean {
        var sum = nums.sum()

        if(sum % 2 != 0) {
            return false
        }

        sum = sum / 2
        val dpTable = Array(nums.size) {Array(sum+1) {-1}}

        return isPartitionPossible(nums, nums.size ,sum, dpTable)
    }

    private fun isPartitionPossible(nums: IntArray, n: Int, sum: Int, dpTable: Array<Array<Int>>):Boolean {

        if(sum == 0) return true
        if(n == 0) return false

        if(dpTable[n-1][sum]!= -1) return dpTable[n-1][sum] == 1

        if(nums[n-1] > sum) return isPartitionPossible(nums, n-1, sum, dpTable)

        dpTable[n-1][sum] = if(isPartitionPossible(nums, n-1, sum, dpTable) || isPartitionPossible(nums, n-1, sum - nums[n-1], dpTable)) 1 else 0

        return dpTable[n-1][sum] == 1
    }
}


fun main() {
    val input = intArrayOf(1,5,11,5)
    println(LeetCode_416_partition_equal_subset_sum().canPartition(input))

    val input1 = intArrayOf(1,2,3,5)
    println(LeetCode_416_partition_equal_subset_sum().canPartition(input1))
}