class LeetCode_121_Best_Time_To_Buy_And_Sell_Stock {
    fun maxProfit(prices: IntArray): Int {
        var ce = prices[0]
        var p = 0

        for(i in 1 until prices.size) {
            if(ce > prices[i]) ce = prices[i]
            else p = maxOf(p, prices[i] - ce)
        }

        return p
    }
}

fun main() {
    val problem = LeetCode_121_Best_Time_To_Buy_And_Sell_Stock()

    val input = intArrayOf(7,1,5,3,6,4)
    val result = problem.maxProfit(input)
    println(result)

    val input1 = intArrayOf(7,6,4,3,1)
    val result1 = problem.maxProfit(input1)
    println(result1)
}