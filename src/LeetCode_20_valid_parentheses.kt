import java.util.ArrayDeque

object LeetCode_20_valid_parentheses {

    fun isValid(s: String): Boolean {
        val stack = ArrayDeque<Char>()
        for (currBracket in s) {
            if (currBracket in arrayOf('(', '{', '[')) {
                stack.addLast(currBracket)
            } else if (currBracket == ')' && stack.peekLast() == '('
                || currBracket == '}' && stack.peekLast() == '{'
                || currBracket == ']' && stack.peekLast() == '['
            ) stack.removeLast()
            else return false
        }

        return stack.isEmpty()
    }
}


fun main() {
    val input = "([])"

    println(LeetCode_20_valid_parentheses.isValid(input))
}