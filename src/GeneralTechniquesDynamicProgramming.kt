fun main() {
    val n = 5
    val table = Array<Int?>(n + 1) { null }
    println(fibDPRecur(5, table))

    println(fibDp(5))
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