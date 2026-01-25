import java.util.ArrayDeque

object LeetCode_20_valid_parentheses {

    fun isValid(s: String): Boolean {
        val stack = ArrayDeque<Char>()
        for (currBracket in s) {

            when(currBracket) {
                '(', '{', '[' -> stack.addLast(currBracket)

                ')' -> if(stack.peekLast() == '(') stack.removeLast() else return false
                '}' -> if(stack.peekLast() == '{') stack.removeLast() else return false
                ']' -> if(stack.peekLast() == '[') stack.removeLast() else return false
                else -> return false
            }
        }

        return stack.isEmpty()
    }
}


fun main() {
    val input = "([])"

    println(LeetCode_20_valid_parentheses.isValid(input))
}