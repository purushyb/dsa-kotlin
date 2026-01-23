object LeetCode_15_Three_Sum {

    fun threeSum(nums: IntArray): List<List<Int>> {
        val result = mutableListOf<List<Int>>()

        nums.sort()

        for (currPos in 0..<nums.size - 2) {

            if (nums[currPos] > 0) break

            if (currPos > 0 && nums[currPos] == nums[currPos - 1]) continue

            var low = currPos + 1
            var high = nums.size - 1
            val compliment = nums[currPos]

            while (low < high) {
                val sum = (compliment + nums[low] + nums[high])
                when {

                    sum > 0 -> {
                        high--
                    }

                    sum < 0 -> {
                        low++
                    }

                    else -> {
                        result.add(listOf(nums[currPos], nums[low], nums[high]))

                        while ( high > low && nums[high] == nums[high - 1]) high--
                        while ( high > low &&  nums[low] == nums[low + 1]) low++

                        high--
                        low++
                    }
                }

            }
        }

        return result
    }

}


fun main() {
    val ip = intArrayOf(-1, 0, 1, 2, -1, -4)

    println(LeetCode_15_Three_Sum.threeSum(ip))
}