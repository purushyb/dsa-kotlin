class LeetCode_322_coin_change {
    val MAX_LIMIT = 1_000_000_000

    fun coinChange(coins: IntArray, amount: Int): Int {
        val maxValue = amount + 1
        val dp = IntArray(amount + 1) { maxValue }
        dp[0] = 0
        for(coin in coins) {
            for(j in coin..amount) {
                dp[j] = minOf(dp[j], dp[j - coin] + 1)
            }
        }

        return if(dp[amount] == maxValue) -1 else dp[amount]
    }

    fun coinChangeDP(coins: IntArray, amount: Int): Int {

        val dp = Array(coins.size) { IntArray(amount + 1) { -1 } }
        val result = solveDP(coins, amount, coins.size - 1, dp)

        return if (result == MAX_LIMIT) -1 else result
    }

    private fun solveDP(coins: IntArray, amount: Int, index: Int, dp: Array<IntArray>): Int {
        if (index < 0) {
            return MAX_LIMIT
        }

        if (amount == 0) {
            return 0
        }

        if (dp[index][amount] != -1) return dp[index][amount]

        var pick = MAX_LIMIT
        if (coins[index] <= amount) {
            val res = solveDP(coins, amount - coins[index], index, dp)
            if (res != MAX_LIMIT) {
                pick = 1 + solveDP(coins, amount - coins[index], index, dp)
            }
        }

        val notPick = solveDP(coins, amount, index - 1, dp)
        dp[index][amount] = minOf(pick, notPick)

        return dp[index][amount]
    }

    fun coinChangeNaiveApproach(coins: IntArray, amount: Int): Int {
        val result = solveNaiveApproach(coins, amount, coins.size - 1)

        return if (result == Int.MAX_VALUE - 1) -1 else result
    }

    private fun solveNaiveApproach(coins: IntArray, amount: Int, index: Int): Int {
        if (index < 0) {
            return Int.MAX_VALUE - 1
        }

        if (amount == 0) {
            return 0
        }

        var pick = Int.MAX_VALUE
        if (coins[index] <= amount) {
            pick = 1 + solveNaiveApproach(coins, amount - coins[index], index)
        }

        val notPick = solveNaiveApproach(coins, amount, index - 1)

        return minOf(pick, notPick)
    }
}

fun main() {
    val problem = LeetCode_322_coin_change()
    val coins = intArrayOf(1, 2, 5)
    val amount = 11
    val result = problem.coinChange(coins, amount)

    println(result)

    val coins1 = intArrayOf(2)
    val amount1 = 3
    val result1 = problem.coinChange(coins1, amount1)

    println(result1)

    val coins2 = intArrayOf(1)
    val amount2 = 0
    val result2 = problem.coinChange(coins2, amount2)

    println(result2)
}