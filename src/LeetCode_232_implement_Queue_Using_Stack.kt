import java.util.ArrayDeque

class LeetCode_232_implement_Queue_Using_Stack {
    private val inputStack = ArrayDeque<Int>()
    private val outputStack = ArrayDeque<Int>()

    private fun moveElementsToOutputStack() {
        if(outputStack.isEmpty()) {
            while(inputStack.isNotEmpty()) {
                outputStack.addLast(inputStack.removeLast())
            }
        }
    }

    fun push(x: Int) {
        inputStack.addLast(x)
    }

    fun pop(): Int {
        moveElementsToOutputStack()
        return outputStack.removeLast()
    }

    fun peek(): Int {
        moveElementsToOutputStack()
        return outputStack.peekLast()
    }

    fun empty(): Boolean {
        return inputStack.isEmpty() && outputStack.isEmpty()
    }
}

fun main() {
    val myQueue = LeetCode_232_implement_Queue_Using_Stack()
    myQueue.push(1); // queue is: [1]
    myQueue.push(2); // queue is: [1, 2] (leftmost is front of the queue)
    println(myQueue.peek()); // return 1
    println(myQueue.pop()); // return 1, queue is [2]
    println(myQueue.empty()); // return false
}