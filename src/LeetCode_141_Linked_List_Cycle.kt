class ListNode(var `val`: Int) {
    var next: ListNode? = null
}

object LeetCode_141_Linked_List_Cycle {

    fun hasCycle(head: ListNode?): Boolean {

        if (head == null) return false

        var slowPointer = head
        var fastPointer = head.next

        while (slowPointer != null && fastPointer != null && fastPointer.next != null) {

            if (fastPointer == slowPointer) return true

            fastPointer = fastPointer.next?.next
            slowPointer = slowPointer.next

        }

        return false
    }
}

fun main() {
    val rootNode = ListNode(3)
    val firstNode = ListNode(2)
    val secondNode = ListNode(0)
    val thirdNode = ListNode(-4)
    rootNode.next = firstNode
    firstNode.next = secondNode
    secondNode.next = thirdNode
    thirdNode.next = firstNode

    println(LeetCode_141_Linked_List_Cycle.hasCycle(rootNode))
}