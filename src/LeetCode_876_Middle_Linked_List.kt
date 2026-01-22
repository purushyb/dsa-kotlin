object LeetCode_876_Middle_Linked_List {

    fun middleNode(head: ListNode?): ListNode? {
        var currNode = head
        var llsize = 0

        while(currNode != null) {
            llsize++
            currNode = currNode.next
        }

        llsize /= 2
        currNode = head

        while(llsize != 0) {
            llsize--
            currNode = currNode?.next
        }

        return currNode
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

    println(LeetCode_876_Middle_Linked_List.middleNode(rootNode)?.`val`)

}