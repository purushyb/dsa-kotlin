class LeetCode_79_Word_Search {
    private val neighbors = arrayOf(arrayOf(-1, 0), arrayOf(1, 0), arrayOf(0, 1), arrayOf(0, -1))

    fun exist(board: Array<CharArray>, word: String): Boolean {
        for (r in 0..<board.size) {
            for (c in 0..<board[0].size) {
                if (board[r][c] == word[0]) {
                    val temp =  board[r][c]
                    board[r][c] = '#'
                    if (dfsFindNodeOptimal(board, r, c, word, 1)) {
                        return true
                    }
                    board[r][c] = temp
                }
            }
        }

        return false
    }

    fun dfsFindNodeOptimal(board: Array<CharArray>, r: Int, c: Int, word: String, i: Int): Boolean {
        if (i == word.length) return true

        for ((or, oc) in neighbors) {
            val nr = r + or
            val nc = c + oc

            if (nr < board.size
                && nr >= 0
                && nc < board[0].size
                && nc >= 0
                && board[nr][nc] != '#'
                && board[nr][nc] == word[i]
            ) {
                val temp = board[nr][nc]
                board[nr][nc] = '#'
                val result = dfsFindNodeOptimal(board, nr, nc, word, i + 1)
                if (result) return result
                board[nr][nc] = temp
            }
        }
        return false
    }

    fun existNaive(board: Array<CharArray>, word: String): Boolean {
        val visited = Array(board.size) { IntArray(board[0].size) }

        for (r in 0..<board.size) {
            for (c in 0..<board[0].size) {
                if (board[r][c] == word[0]) {
                    visited[r][c] = 1
                    if (dfsFindNodeNaive(board, visited, r, c, word, 1)) {
                        return true
                    } else {
                        visited[r][c] = 0
                    }
                }
            }
        }

        return false
    }

    fun dfsFindNodeNaive(board: Array<CharArray>, visited: Array<IntArray>, r: Int, c: Int, word: String, i: Int): Boolean {
        if (i == word.length) return true

        for ((or, oc) in neighbors) {
            val nr = r + or
            val nc = c + oc

            if (nr < board.size
                && nr >= 0
                && nc < board[0].size
                && nc >= 0
                && visited[nr][nc] == 0
                && board[nr][nc] == word[i]
            ) {
                visited[nr][nc] = 1
                val result = dfsFindNodeNaive(board, visited, nr, nc, word, i + 1)
                if (result) return result
                visited[nr][nc] = 0
            }
        }
        return false
    }
}

fun main() {
    val problem = LeetCode_79_Word_Search()
//    val board: Array<CharArray> = arrayOf(
//        charArrayOf('A', 'B', 'C', 'E'),
//        charArrayOf('S', 'F', 'C', 'S'),
//        charArrayOf('A', 'D', 'E', 'E')
//    )
//    val word = "ABCCED"
//    val result = problem.existOptimal(board, word)
//    println(result)
//
//    val board1: Array<CharArray> = arrayOf(
//        charArrayOf('A', 'B', 'C', 'E'),
//        charArrayOf('S', 'F', 'C', 'S'),
//        charArrayOf('A', 'D', 'E', 'E')
//    )
//    val word1 = "SEE"
//    val result1 = problem.existOptimal(board1, word1)
//    println(result1)
//
//    val board2: Array<CharArray> = arrayOf(
//        charArrayOf('A', 'B', 'C', 'E'),
//        charArrayOf('S', 'F', 'C', 'S'),
//        charArrayOf('A', 'D', 'E', 'E')
//    )
//    val word2 = "ABCB"
//    val result2 = problem.existOptimal(board2, word2)
//    println(result2)

    val board3: Array<CharArray> = arrayOf(
        charArrayOf('a', 'a'),
    )
    val word3 = "aaa"
    val result3 = problem.exist(board3, word3)
    println(result3)
}