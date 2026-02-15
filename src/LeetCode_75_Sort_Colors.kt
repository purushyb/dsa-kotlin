class LeetCode_75_Sort_Colors {
    fun sortColors(nums: IntArray): Unit {
        val freqArray = IntArray(3)

        for(i in nums) {
            freqArray[i]++
        }

        var indx = 0
        for(i in 0..2) {
            while(freqArray[i] != 0) {
                nums[indx] = i
                indx++
                freqArray[i]--
            }
        }
    }
}

fun main() {
    val problem = LeetCode_75_Sort_Colors()

    val input = intArrayOf(2,0,2,1,1,0)
    problem.sortColors(input)
    println(input.contentToString())

    val input1 = intArrayOf(0)
    problem.sortColors(input1)
    println(input1.contentToString())

    val input2 = intArrayOf(2,0,1)
    problem.sortColors(input2)
    println(input2.contentToString())
}