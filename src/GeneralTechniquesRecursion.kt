fun main() {
    println(sum(3))

    println(fact(10))

    println(fib(5))

    val weights = arrayOf<Int>(4, 5, 1)
    val profits = arrayOf<Int>(1, 2, 3)
    val requiredWeight = 4
    println(knapSackRecur(weights, profits, requiredWeight, weights.size))

    val sequence1 = "AGGTAB"
    val sequence2 = "GXTXAYB"

    println(longestCommonSubsequence(sequence1, sequence2, sequence1.length - 1, sequence2.length - 1))
}

fun sum(n: Int): Int {
    // Base case:
    if (n == 1) return n

    // recursive Case + Termination case
    return n + sum(n - 1)
}

fun fact(n: Int): Int {
    // Base Case:
    if (n == 1) return n

    // recursive Case + Termination case
    return n * fact(n - 1)
}

fun fib(n: Int): Int {
    // Base case:
    if (n == 1 || n == 0) return n

    return fib(n - 1) + fib(n - 2)
}

fun knapSackRecur(weights: Array<Int>, profits: Array<Int>, currWeight: Int, position: Int): Int {

    // Base case
    if (position == 0 || currWeight == 0) return 0

    var pickedProfit = 0
    val currPosition = position - 1

    // recursive Case
    if (weights[currPosition] <= currWeight) {
        pickedProfit = profits[currPosition] + knapSackRecur(
            weights,
            profits,
            currWeight - weights[currPosition],
            currPosition
        )
    }

    val notPickedProfit = knapSackRecur(weights, profits, currWeight, currPosition)

    // Termination Case
    return maxOf(pickedProfit, notPickedProfit)

}

fun longestCommonSubsequence(sequence1: String, sequence2: String, position1: Int, position2: Int): Int {

    // Base
    if (position1 == 0 || position2 == 0) return 0

    if (sequence1[position1] == sequence2[position2]) {
        return 1 + longestCommonSubsequence(
            sequence1,
            sequence2,
            position1 - 1,
            position2 - 1
        )
    } else {
        return maxOf(
            longestCommonSubsequence(
                sequence1,
                sequence2,
                position1 - 1,
                position2
            ),
            longestCommonSubsequence(
                sequence1,
                sequence2,
                position1,
                position2 - 1
            )
        )
    }
}