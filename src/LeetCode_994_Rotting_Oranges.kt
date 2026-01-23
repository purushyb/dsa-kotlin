import java.util.LinkedList

object LeetCode_994_Rotting_Oranges {

    fun orangesRotting(grid: Array<IntArray>): Int {
        val q = LinkedList<Pair<Int, Int>>()
        val rowSize = grid.size
        val colSize = grid.first().size
        var freshOranges = 0

        // find all rotted oranges and add it to queue
        for (row in 0..<rowSize) {
            for (col in 0..<colSize) {
                if (grid[row][col] == 2) {
                    q.offer(Pair(row, col))
                }
                else if (grid[row][col] == 1) {
                    freshOranges++
                }
            }
        }

        if(freshOranges == 0) return 0

        var minute = 0

        val directions = arrayOf(
            intArrayOf(-1, 0), intArrayOf(1, 0),
            intArrayOf(0, -1), intArrayOf(0, 1)
        )

        // Multi BFS
        while (q.isNotEmpty()) {
            val size = q.size // FREEZE the size for this minute level
            var infectedThisRound = false

            for (i in 0 until size) {
                val (currR, currC) = q.poll()

                for (d in directions) {
                    val newR = currR + d[0]
                    val newC = currC + d[1]

                    // Check bounds and if fresh
                    if (newR >= 0 && newR < rowSize &&
                        newC >= 0 && newC < colSize &&
                        grid[newR][newC] == 1) {

                        // Rot the orange
                        grid[newR][newC] = 2
                        freshOranges--
                        q.offer(Pair(newR, newC))
                        infectedThisRound = true
                    }
                }
            }

            if (infectedThisRound) minute++
        }
        return if(freshOranges == 0) minute else -1
    }
}

fun main() {
    val grid = arrayOf(intArrayOf(2, 1, 1), intArrayOf(1, 1, 0), intArrayOf(0, 1, 1))

    println(LeetCode_994_Rotting_Oranges.orangesRotting(grid))
}