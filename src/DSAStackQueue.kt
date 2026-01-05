fun main() {
    // use ArrayDeque in kotlin for both stack and queue implementations

    val stack = CustomStack<Int>()
    stack.push(2)
    stack.push(3)
    stack.push(4)

    println(stack.pop())

    // By default, kotlin provides implementation of queue with double linked list
    val queue = ArrayDeque<Int>()
    queue.addLast(2)
    queue.addLast(3)
    queue.addLast(4)

    println(queue.removeFirst())
}

interface Stack<T> {
    fun push(element: T)
    fun pop(): T?
    fun peek(): T?
}

class CustomStack<T> : Stack<T> {

    private val stackElements = ArrayDeque<T>()

    override fun push(element: T) {
        stackElements.addLast(element)
    }

    override fun pop(): T? {
        return stackElements.removeLast()
    }

    override fun peek(): T? {
        return stackElements.first()
    }

}