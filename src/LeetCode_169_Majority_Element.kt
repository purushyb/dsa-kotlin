class LeetCode_169_Majority_Element {
    val hMap = HashMap<Int, Int>()
    fun majorityElementWithHMap(nums: IntArray): Int {
        var currMax = Int.MIN_VALUE
        for (i in nums) {
            hMap[i] = (hMap.getOrDefault(i, 0) + 1)
            if (hMap[i]!! > nums.size / 2) currMax = i
        }
        return currMax
    }

    fun majorityElement(nums: IntArray): Int {
        var cMax = nums[0]
        var c = 1
        for (i in 1..<nums.size) {
            if(nums[i] == cMax) {
                c++
            }
            else{
                c--
                if(c == 0) {
                    cMax = nums[i]
                    c = 1
                }
            }
        }
        return cMax
    }
}

fun main() {
    val input = intArrayOf(2)
    println(LeetCode_169_Majority_Element().majorityElement(input))
}