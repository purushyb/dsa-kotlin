import java.util.ArrayDeque

object LeetCode_150_Evaluate_Reverse_Polish_Notation {
    fun evalRPN(tokens: Array<String>): Int {
        val stack = ArrayDeque<Int>()
        for(i in tokens) {

            if(i == "*" || i == "-" || i == "+" || i == "/") {
                val num1 = stack.pop()
                val num2 = stack.pop()
                when(i) {
                    "*" -> {
                        stack.push(num2 * num1)
                    }
                    "+" -> {
                        stack.push(num2 + num1)
                    }
                    "-" -> {
                        stack.push(num2 - num1)
                    }
                    "/" -> {
                        stack.push(num2 / num1)
                    }
                }
            }
            else{
                stack.push(i.toInt())
            }

        }
        return stack.pop()
    }
}

fun main() {
    val input = arrayOf<String>("4","-2","/","2","-3","-","-")
    println(LeetCode_150_Evaluate_Reverse_Polish_Notation.evalRPN(input))
}