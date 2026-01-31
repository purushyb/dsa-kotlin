class LeetCode_155_Min_Stack {
    class ListNode(val data: Int) {
        var next: ListNode? = null
        var min: Int = data
    }

    val dummy = ListNode(-1)

    fun push(`val`: Int) {
        val newNode = ListNode(`val`)

        if(dummy.next != null){
            newNode.min = minOf(newNode.min, dummy.next?.min?: Int.MAX_VALUE)
        }

        newNode.next = dummy.next
        dummy.next = newNode
    }

    fun pop() {
        dummy.next = dummy.next?.next
    }

    fun top(): Int {
        if(dummy.next == null) throw Exception("no top found")
        return dummy.next!!.data
    }

    fun getMin(): Int {
        if(dummy.next == null) throw Exception("no min found")
        return dummy.next!!.min
    }
}

fun main() {
    val minStack = LeetCode_155_Min_Stack()
    minStack.push(-2);
    minStack.push(0);
    minStack.push(-3);
    println(minStack.getMin()); // return -3
    minStack.pop();
    minStack.top();    // return 0
    println(minStack.getMin()); // return -2
}

