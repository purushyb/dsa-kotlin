object LeetCode_8_String_To_Integer {

    fun myAtoi(s: String): Int {

        val currStr = s.trimStart()
        if (currStr.isEmpty()) return 0

        var result = 0
        var lp = 0
        var multiplier = 1

        if (currStr[lp] == '-') {
            multiplier = -1
            lp++
        }
        else if (currStr[lp] == '+') {
            multiplier = 1
            lp++
        }

        while (lp < currStr.length) {
            if (currStr[lp] < '0' || currStr[lp] > '9') {
                break
            }

            val digit = currStr[lp] - '0'

            if (result > Int.MAX_VALUE / 10 ||
                (result == Int.MAX_VALUE / 10 && digit > Int.MAX_VALUE % 10)) {
                return if (multiplier == 1) Int.MAX_VALUE else Int.MIN_VALUE
            }

            result = (result * 10) + digit
            lp++
        }

        return result * multiplier
    }
}

fun main() {
    println(LeetCode_8_String_To_Integer.myAtoi("-2147483648"))
}