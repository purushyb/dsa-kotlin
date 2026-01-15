fun main() {
//    val opList = mutableListOf<String>()
//    val ip = "ABC"
//    permutationsRecur(StringBuilder(ip), 0, opList)
//    print(opList)
//

    // sudoku solve
//
    val matrix = arrayOf(
        arrayOf(3, 0, 6, 5, 0, 8, 4, 0, 0),
        arrayOf(5, 2, 0, 0, 0, 0, 0, 0, 0),
        arrayOf(0, 8, 7, 0, 0, 0, 0, 3, 1),
        arrayOf(0, 0, 3, 0, 1, 0, 0, 8, 0),
        arrayOf(9, 0, 0, 8, 6, 3, 0, 0, 5),
        arrayOf(0, 5, 0, 0, 9, 0, 6, 0, 0),
        arrayOf(1, 3, 0, 0, 0, 0, 2, 5, 0),        arrayOf(0, 0, 0, 0, 0, 0, 0, 7, 4),
        arrayOf(0, 0, 5, 2, 0, 6, 3, 0, 0)
    )

    println(sudokuSolverRecur(matrix, 0, 0))
    print("Sudoku OP")
    for (i in 0..<matrix.size) {
        println(matrix[i].contentToString())
    }

    val noOfQueens = 4
    val queensMatrix = Array(noOfQueens) { Array<Int>(noOfQueens) { 0 } }
    val op = mutableListOf<Array<Int>>()
    nQueens(queensMatrix, op, 0)
    println("N Queens OP")
    for (i in 0..<op.size) {
        println(op[i].contentToString())
    }
}

// NQueens
fun nQueens(matrix: Array<Array<Int>>, output: MutableList<Array<Int>>, row: Int) {
    val queensCount = matrix.size

    // Base case
    if (row == queensCount) {
        val newCombination = Array<Int>(queensCount) { 0 }
        for (i in 0..<queensCount) {
            for (j in 0..<queensCount) {
                if (matrix[i][j] == 1) {
                    newCombination[i] = j + 1
                }
            }
        }
        output.add(newCombination)
//        return
    }

    for (i in 0..<queensCount) {
        if (isSafePosition(matrix, row, i)) {
            matrix[row][i] = 1
            nQueens(matrix, output, row + 1)
            // Backtracking step
            matrix[row][i] = 0
        }
    }
}

fun isSafePosition(matrix: Array<Array<Int>>, row: Int, column: Int): Boolean {
    // check column
    for (i in 0..<row) {
        if (matrix[i][column] == 1) return false
    }

    // check left top diagonal
    var i = row - 1
    var j = column - 1
    while (i >= 0 && j >= 0) {
        if (matrix[i][j] == 1) {
            return false
        }

        i--
        j--
    }

    // check right top diagonal
    i = row - 1
    j = column + 1
    while (i >= 0 && j < matrix.size) {
        if (matrix[i][j] == 1) {
            return false
        }

        i--
        j++
    }

    return true
}

// sudoku solver
fun sudokuSolverRecur(matrix: Array<Array<Int>>, row: Int, column: Int): Boolean {
    var currRow = row
    var currColumn = column

    if (row == 8 && column == 9) {
        return true
    }

    if (column == 9) {
        currRow++
        currColumn = 0
    }

    if (matrix[currRow][currColumn] != 0) {
        return sudokuSolverRecur(matrix, currRow, currColumn + 1)
    }

    for (i in 1..9) {
        if (isSafeSudoku(matrix, currRow, currColumn, i)) {
            matrix[currRow][currColumn] = i
            if (sudokuSolverRecur(matrix, currRow, currColumn + 1))
                return true
            matrix[currRow][currColumn] = 0
        }
    }

    return false
}

fun isSafeSudoku(matrix: Array<Array<Int>>, row: Int, column: Int, currNumber: Int): Boolean {
    // check number does not exist in row

    for (i in 0..<9) {
        if (matrix[i][column] == currNumber) {
            return false
        }
    }

    for (i in 0..<9) {
        if (matrix[row][i] == currNumber) {
            return false
        }
    }

    val currStartRow = row - (row % 3)
    val currStartColumn = column - (column % 3)
    for (i in currStartRow..<currStartRow + 3) {
        for (j in currStartColumn..<currStartColumn + 3) {
            if (matrix[i][j] == currNumber) {
                return false
            }
        }
    }

    return true
}


fun permutationsRecur(str: StringBuilder, index: Int, op: MutableList<String>) {
    // Base Case
    if (index == str.length) {
        op.add(str.toString())
        return
    }

    for (i in index..<str.length) {
        swapStr(str, index, i)
        permutationsRecur(str, index + 1, op)
        swapStr(str, i, index)
    }
}

fun permutationsRecurWithoutSpecificChars(str: StringBuilder, index: Int, op: MutableList<String>) {
    // Base Case
    if (index == str.length) {
        op.add(str.toString())
        return
    }

    for (i in index..<str.length) {
        swapStr(str, index, i)
        permutationsRecur(str, index + 1, op)
        swapStr(str, i, index)
    }
}

// Check this one
fun isSafe(str: StringBuilder, i: Int): Boolean {
    if (str[i] != 'B' && str[i + 1] == 'A') {
        return false
    }

    if (str[i] != 'A' && str[i - 1] != 'B') {
        return false
    }

    return true
}

fun swapStr(str: StringBuilder, i: Int, j: Int) {
    val temp = str[i]
    str.setCharAt(i, str[j])
    str.setCharAt(j, temp)
}