import java.util.LinkedList

class LeetCode_542_01_Matrix {
    val neighbors = arrayOf(arrayOf(-1, 0), arrayOf(1, 0), arrayOf(0, -1), arrayOf(0, 1))

    fun updateMatrix(mat: Array<IntArray>): Array<IntArray> {
        val rSize = mat.size
        val cSize = mat[0].size
        val q = LinkedList<Pair<Int, Int>>()

        for (r in 0..<rSize) {
            for (c in 0..<cSize) {
                if (mat[r][c] == 0) {
                    q.offer(Pair(r, c))
                } else {
                    mat[r][c] = -1
                }
            }
        }

        while (q.isNotEmpty()) {
            for (i in 0..<q.size) {
                val (r, c) = q.poll()
                for ((rOffset, cOffset) in neighbors) {
                    val newRow = r + rOffset
                    val newCol = c + cOffset

                    if (newRow < rSize && newRow >= 0 && newCol < cSize && newCol >= 0 && mat[newRow][newCol] == -1) {
                        mat[newRow][newCol] = mat[r][c] + 1
                        q.offer(Pair(newRow, newCol))
                    }
                }
            }
        }

        return mat
    }
}

fun main() {
    val input = arrayOf(intArrayOf(0, 0, 0), intArrayOf(0, 1, 0), intArrayOf(1, 1, 1))
    val result = LeetCode_542_01_Matrix().updateMatrix(input)
    for (i in result) {
        println(i.contentToString())
    }
}