class LeetCode_54_spiral_matrix {
    fun spiralOrder(matrix: Array<IntArray>): List<Int> {
        val op = mutableListOf<Int>()
        var startRow = 0
        var startCol = 0
        var endRow = matrix.size - 1
        var endCol = matrix[0].size - 1

        while(startRow <= endRow && startCol <= endCol) {
            for(col in startCol..endCol) {
                op.add(matrix[startRow][col])
            }
            startRow++
            if(startRow > endRow) break

            for(row in startRow..endRow) {
                op.add(matrix[row][endCol])
            }
            endCol--
            if (startCol > endCol) break

            for(col in (startCol..endCol).reversed()) {
                op.add(matrix[endRow][col])
            }
            endRow--

            for(row in (startRow..endRow).reversed()) {
                op.add(matrix[row][startCol])
            }
            startCol++
        }

        return op
    }
}

fun main() {
    val problem = LeetCode_54_spiral_matrix()
    val input = arrayOf(intArrayOf(1,2,3), intArrayOf(4,5,6), intArrayOf(7,8,9))
    val result = problem.spiralOrder(input)
    println(result)

    val input1 = arrayOf(intArrayOf(1,2,3,4), intArrayOf(5,6,7,8), intArrayOf(9,10,11,12))
    val result1 = problem.spiralOrder(input1)
    println(result1)

    val input2 = arrayOf(intArrayOf(1,2,3), intArrayOf(5,6,7), intArrayOf(9,10,11), intArrayOf(12,13,14))
    val result2 = problem.spiralOrder(input2)
    println(result2)

    val input3 = arrayOf(intArrayOf(1))
    val result3 = problem.spiralOrder(input3)
    println(result3)

    val input4 = arrayOf(intArrayOf(1,2,3,4), intArrayOf(5,6,7,8), intArrayOf(9,10,11,12), intArrayOf(13,14,15,16))
    val result4 = problem.spiralOrder(input4)
    println(result4)

    val input5 = arrayOf(intArrayOf(7), intArrayOf(9), intArrayOf(6))
    val result5 = problem.spiralOrder(input5)
    println(result5)
}