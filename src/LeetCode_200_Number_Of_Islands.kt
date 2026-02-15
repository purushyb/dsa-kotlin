import java.util.LinkedList

class LeetCode_200_Number_Of_Islands {
    private val neighborGenerator = listOf(Pair(0, 1), Pair(1, 0), Pair(0, -1), Pair(-1, 0))

    fun dfsSink(grid: Array<CharArray>, r: Int, c: Int) {

        if (r !in 0..<grid.size || c !in 0..<grid[0].size || grid[r][c] == '0') {
            return
        }

        grid[r][c] = '0'

        dfsSink(grid, r - 1, c)
        dfsSink(grid, r + 1, c)
        dfsSink(grid, r, c + 1)
        dfsSink(grid, r, c - 1)

    }

    fun numIslands(grid: Array<CharArray>): Int {
        var isLandCount = 0
        for(row in 0..<grid.size) {
            for(col in 0..<grid[0].size) {
                if(grid[row][col] == '1') {
                    isLandCount++
                    dfsSink(grid, row, col)
                }
            }
        }
        return isLandCount
    }

    fun numIslandsBFS(grid: Array<CharArray>): Int {
        var islandCount = 0
        val rowsCount = grid.size
        val colsCount = grid[0].size

        for (row in 0..<rowsCount) {
            for (col in 0..<colsCount) {
                if (grid[row][col] == '1') {
                    islandCount++
                    // Do BFS
                    val queue = ArrayDeque<Pair<Int, Int>>()
                    queue.add(row to col)
                    grid[row][col] = '0'

                    while (queue.isNotEmpty()) {
                        val (cr, cc) = queue.removeFirst()
                        for ((r, c) in neighborGenerator) {
                            val nr = cr + r
                            val nc = cc + c

                            if (nr in 0..<rowsCount
                                && nc in 0..<colsCount
                                && grid[nr][nc] == '1'
                            ) {
                                queue.add(Pair(nr, nc))
                                grid[nr][nc] = '0'
                            }
                        }
                    }
                }
            }
        }
        return islandCount
    }

    fun numIslandsNaive(grid: Array<CharArray>): Int {
        var islandCount = 0
        val rowsCount = grid.size
        val colsCount = grid[0].size
        val visited = Array(rowsCount) { IntArray(colsCount) }

        for (row in 0..<rowsCount) {
            for (col in 0..<colsCount) {
                if (visited[row][col] != 1 && grid[row][col] != '0') {
                    islandCount++
                    // Do BFS
                    val queue = LinkedList<Pair<Int, Int>>()
                    queue.offer(Pair(row, col))
                    visited[row][col] = 1

                    while (queue.isNotEmpty()) {
                        val (cr, cc) = queue.poll()
                        for ((r, c) in neighborGenerator) {
                            val nr = cr + r
                            val nc = cc + c
                            if (nr >= 0 && nc >= 0 &&
                                nr < rowsCount && nc < colsCount && visited[nr][nc] == 0
                            ) {
                                visited[nr][nc] = 1
                                if (grid[nr][nc] == '1') {
                                    queue.offer(Pair(nr, nc))
                                }
                            }
                        }
                    }
                }
            }
        }
        return islandCount
    }
}

fun main() {
    val problem = LeetCode_200_Number_Of_Islands()

    val grid: Array<CharArray> = arrayOf(
        charArrayOf('1', '1', '1', '1', '0'),
        charArrayOf('1', '1', '0', '1', '0'),
        charArrayOf('1', '1', '0', '0', '0'),
        charArrayOf('0', '0', '0', '0', '0')
    )
    val result = problem.numIslands(grid)
    println(result)

    val grid2: Array<CharArray> = arrayOf(
        charArrayOf('1', '1', '0', '1', '0'),
        charArrayOf('1', '1', '0', '1', '0'),
        charArrayOf('0', '0', '1', '0', '0'),
        charArrayOf('0', '0', '0', '1', '1')
    )
    val result2 = problem.numIslands(grid2)
    println(result2)

    val grid3: Array<CharArray> = arrayOf(
        charArrayOf('1')
    )
    val result3 = problem.numIslands(grid3)
    println(result3)

    val grid4: Array<CharArray> = arrayOf(
        charArrayOf('0')
    )
    val result4 = problem.numIslands(grid4)
    println(result4)

    val grid5: Array<CharArray> = arrayOf(
        charArrayOf('1', '1', '1'),
        charArrayOf('0', '1', '0'),
        charArrayOf('1', '1', '1'),
    )
    val result5 = problem.numIslands(grid5)
    println(result5)
}