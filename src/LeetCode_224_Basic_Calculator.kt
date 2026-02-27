import java.lang.Character.isDigit

class LeetCode_224_Basic_Calculator {
    fun calculate(s: String): Int {
        val stack = ArrayDeque<Int>()
        var result = 0
        val size = s.length
        var sign = 1
        var i = 0

        while(i < size) {
            when {
                isDigit(s[i]) -> {
                    var currNum = 0
                    while(i < size && isDigit(s[i])) {
                        currNum = currNum * 10 + (s[i] - '0')
                        i++
                    }
                    result += sign * currNum
                    i--
                }
                s[i] == '+' -> sign = 1
                s[i] == '-' -> sign = -1
                s[i] == '(' -> {
                    stack.addLast(result)
                    stack.addLast(sign)
                    result = 0
                    sign = 1
                }
                s[i] == ')' -> {
                    result = (stack.removeLast() * result) + stack.removeLast()
                }
            }
            i++
        }
        return result
    }
}

fun main() {
    val problem = LeetCode_224_Basic_Calculator()

    val ip = "(1+(4+5+2)-3)+(6+8)"
    val result = problem.calculate(ip)
    println(result)
}