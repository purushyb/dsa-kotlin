class LeetCode_206_Reverse_LInked_List {
    fun reverseList(head: ListNode?): ListNode? {
        var n0: ListNode? = null
        var cn = head

        while(cn != null) {
            val temp = cn.next
            cn.next = n0
            n0 = cn
            cn = temp
        }

        return n0
    }
}

fun printLinkedList(head: ListNode?) {
    var cn = head

    while(cn!= null) {
        print(" -> ${cn.`val`}")
        cn = cn.next
    }
    println()
}

fun main() {
    val problem = LeetCode_206_Reverse_LInked_List()

    val head = ListNode(1)
    head.next = ListNode(2)
    head.next?.next = ListNode(3)
    head.next?.next?.next = ListNode(4)
    head.next?.next?.next?.next = ListNode(5)
    printLinkedList(head)

    val resultHead = problem.reverseList(head)
    printLinkedList(resultHead)

    val head2 = ListNode(1)
    printLinkedList(head2)

    val resultHead2 = problem.reverseList(head2)
    printLinkedList(resultHead2)

    val head3 = ListNode(1)
    head3.next = ListNode(2)
    printLinkedList(head3)

    val resultHead3 = problem.reverseList(head3)
    printLinkedList(resultHead3)
}