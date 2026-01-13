fun main() {
    val n = 5
    val table = Array<Int?>(n + 1) { null }
    println(fibDPRecur(5, table))

    println(fibDp(5))

    val weights = arrayOf<Int>(4, 5, 1)
    val profits = arrayOf<Int>(1, 2, 3)
    val requiredWeight = 4
    val noOfElement = weights.size
    val memo = Array<Array<Int>>(noOfElement + 1) { Array<Int>(size = requiredWeight + 1) { -1 } }
    println(knapSackDpRecur(weights, profits, requiredWeight, noOfElement, memo))

    val sequence1 = "AGGTAB"
    val sequence2 = "GXTXAYB"
    val memoForLcs = Array<Array<Int>>(sequence1.length + 1) { Array<Int>(size = sequence1.length + 1) { -1 } }

    println(longestCommonSubsequenceDp(sequence1, sequence2, sequence1.length - 1, sequence2.length - 1, memoForLcs))
}

// Top down
fun fibDPRecur(n: Int, table: Array<Int?>): Int {

    // Dp Table Look Up
    if (table[n] != null) return table[n]!!

    // Base condition
    if (n == 0 || n == 1) table[n] = n
    else table[n] = fib(n - 1) + fib(n - 2)

    return table[n]!!
}

// Bottom up
fun fibDp(n: Int): Int {

    if (n <= 1) return n

    val table = Array<Int?>(n + 1) { null }
    table[0] = 0
    table[1] = 1

    for (i in 2..n) {
        table[i] = table[i - 1]!! + table[i - 2]!!
    }

    return table[n]!!
}

fun knapSackDpRecur(
    weights: Array<Int>,
    profits: Array<Int>,
    currWeight: Int,
    position: Int,
    memo: Array<Array<Int>>
): Int {

    // Base case
    if (position == 0 || currWeight == 0) return 0

    if (memo[position][currWeight] != -1) {
        return memo[position][currWeight]
    }

    var pickedProfit = 0
    val currPosition = position - 1

    // recursive Case
    if (weights[currPosition] <= currWeight) {
        pickedProfit = profits[currPosition] + knapSackDpRecur(
            weights,
            profits,
            currWeight - weights[currPosition],
            currPosition,
            memo
        )
    }

    val notPickedProfit = knapSackDpRecur(weights, profits, currWeight, currPosition, memo)

    // Termination Case
    val result = maxOf(pickedProfit, notPickedProfit)
    memo[position][currWeight] = result


    return result
}

fun longestCommonSubsequenceDp(
    sequence1: String,
    sequence2: String,
    position1: Int,
    position2: Int,
    memo: Array<Array<Int>>
): Int {

    // Base
    if (position1 == 0 || position2 == 0) return 0

    if (memo[position1][position2] != -1) return memo[position1][position2]

    if (sequence1[position1] == sequence2[position2]) {
        memo[position1 - 1][position2 - 1] = 1 + longestCommonSubsequenceDp(
            sequence1,
            sequence2,
            position1 - 1,
            position2 - 1,
            memo
        )
        return memo[position1 - 1][position2 - 1]
    } else {
        memo[position1][position2] =  maxOf(
            longestCommonSubsequenceDp(
                sequence1,
                sequence2,
                position1 - 1,
                position2,
                memo
            ),
            longestCommonSubsequenceDp(
                sequence1,
                sequence2,
                position1,
                position2 - 1,
                memo
            )
        )

        return memo[position1][position2]
    }
}