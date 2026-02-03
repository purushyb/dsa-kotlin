class LeetCode_39_combination_sum {
    fun combinationSum(candidates: IntArray, target: Int): List<List<Int>> {
        val op = mutableListOf<List<Int>>()

        findCombinations(candidates, target, op, mutableListOf<Int>(), 0)

        return op
    }

    private fun findCombinations(candidates: IntArray, target: Int, op: MutableList<List<Int>>, cOp: MutableList<Int>, indx: Int) {

        if(target == 0) {
            op.add(cOp.toList())
            return
        }

        if(target < 0 || indx >= candidates.size) return

        cOp.add(candidates[indx])
        findCombinations(candidates, target - candidates[indx], op, cOp, indx)

        cOp.removeAt(cOp.size - 1)
        findCombinations(candidates, target, op, cOp, indx + 1)
    }
}

fun main() {
    val input = intArrayOf(1, 2,3)

    println(LeetCode_39_combination_sum().combinationSum(input, 5))
}