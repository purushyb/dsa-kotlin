class LeetCode_46_Permutations {
    fun permute(nums: IntArray): List<List<Int>> {
        val op = mutableListOf<List<Int>>()
        genPermutations(nums, op, 0)
        return op
    }

    private fun genPermutations(nums: IntArray, op: MutableList<List<Int>>, indx: Int) {
        if (indx == nums.size) {
            op.add(nums.toList())
            return
        }

        for (i in indx..<nums.size) {
            swap(nums, indx, i)
            genPermutations(nums, op, indx + 1)
            swap(nums, indx, i)
        }
    }

    private fun swap(arr: IntArray, indx1: Int, indx2: Int) {
        val temp = arr[indx1]
        arr[indx1] = arr[indx2]
        arr[indx2] = temp
    }
}

fun main() {
    val problem = LeetCode_46_Permutations()
    val input = intArrayOf(1, 2, 3)
    val result = problem.permute(input)
    println(result)
}