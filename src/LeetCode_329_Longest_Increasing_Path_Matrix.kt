class LeetCode_329_Longest_Increasing_Path_Matrix {
    fun longestIncreasingPath(matrix: Array<IntArray>): Int {
        val rl = matrix.size
        val cl = matrix[0].size

        val degree = Array(rl) { IntArray(cl) }
        val neighbors = arrayOf(0 to 1, 0 to -1, 1 to 0, -1 to 0)

        for (r in 0..<rl) {
            for (c in 0..<cl) {
                for ((ro, co) in neighbors) {
                    val nr = r + ro
                    val nc = c + co
                    if (nr >= 0 && nr < rl && nc >= 0 && nc < cl && matrix[nr][nc] < matrix[r][c])
                        degree[r][c]++
                }
            }
        }

        val q = ArrayDeque<Pair<Int, Int>>()
        for (r in 0..<rl) {
            for (c in 0..<cl) {
                if (degree[r][c] == 0)
                    q.addLast(r to c)
            }
        }

        var pathLength = 0
        while (q.isNotEmpty()) {
            pathLength++
            repeat(q.size) {
                val (r, c) = q.removeFirst()
                for ((ro, co) in neighbors) {
                    val nr = r + ro
                    val nc = c + co
                    if (nr >= 0 && nr < rl && nc >= 0 && nc < cl && matrix[nr][nc] > matrix[r][c]) {
                        degree[nr][nc]--
                        if (degree[nr][nc] == 0) {
                            q.addLast(nr to nc)
                        }
                    }
                }
            }
        }

        return pathLength
    }
}

fun main() {
    val problem = LeetCode_329_Longest_Increasing_Path_Matrix()
    val matrix = arrayOf(intArrayOf(3, 4, 5), intArrayOf(3, 2, 6), intArrayOf(2, 2, 1))
    val result = problem.longestIncreasingPath(matrix)
    println(result)
}
