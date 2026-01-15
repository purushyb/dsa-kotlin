data class DSANode(val data: Int, var next: DSANode? = null)

fun main() {
    var head: DSANode? = DSANode(data = 1)
    head?.next = DSANode(data = 2)
    head?.next?.next = DSANode(data = 3)
    head?.next?.next?.next = DSANode(data = 4)

    println(getLinkedListLength(head))
    printLinkedList(head)

    head = insertAtFirst(head, 0)
    println("List after inserting key 0 at head")
    printLinkedList(head)

    insertAtEnd(head, 5)
    println("List after inserting key 5 at end")
    printLinkedList(head)

    head = insertAfterElement(head, 3, 10)
    println("List after inserting key 3 after 10")
    printLinkedList(head)

    head = insertAfterPosition(head, position = 1, 15)
    println("List after inserting key 15 after position 2")
    printLinkedList(head)

    head = deleteNodeAtStart(head)
    println("List after deleting at start position")
    printLinkedList(head)

    head = deleteNodeAtEnd(head)
    println("List after deleting at end position")
    printLinkedList(head)

    head = deleteNodeAtPosition(head, 2)
    println("List after deleting at position 2")
    printLinkedList(head)

    head = reverseLinkedList(head)
    println("List after reversing")
    printLinkedList(head)

    val cyclicLinkedListHead = DSANode(1)
    cyclicLinkedListHead.next = DSANode(3)
    cyclicLinkedListHead.next?.next = DSANode(4)
    cyclicLinkedListHead.next?.next?.next = cyclicLinkedListHead.next

    println("Is cycle found ${floydCycleDetection(cyclicLinkedListHead)}")

}

fun floydCycleDetection(head: DSANode?): Boolean {
    var slowPointer: DSANode? = head?.next
    var fastPointer: DSANode? = head?.next?.next

    while (slowPointer != null && fastPointer != null && fastPointer.next != null) {
        if (slowPointer == fastPointer) return true

        slowPointer = slowPointer.next
        fastPointer = fastPointer.next?.next
    }

    return false
}

fun reverseLinkedList(head: DSANode?): DSANode? {
    if (head == null) return head

    var current: DSANode? = head
    var prev: DSANode? = null
    var next: DSANode? = null

    while (current != null) {
        next = current.next
        current.next = prev

        prev = current
        current = next
    }

    return prev

}

fun deleteNodeAtStart(head: DSANode?): DSANode? {
    if (head == null) return head
    val currHead = head.next
    head.next = null
    return currHead
}

fun deleteNodeAtEnd(head: DSANode?): DSANode? {
    if (head == null) return head

    if (head.next == null) return null

    var currNode = head

    while (currNode?.next?.next != null) {
        currNode = currNode.next
    }

    currNode?.next = null

    return head
}

fun deleteNodeAtPosition(head: DSANode?, position: Int): DSANode? {
    if (head == null) return head

    if (position == 1) {
        val newHead = head.next
        head.next = null
        return newHead
    }

    var currNode = head
    for (i in 1..<position - 1) {

        if (currNode == null) {
            break
        }

        currNode = currNode.next
    }

    if (currNode == null) return head

    currNode.next = currNode.next?.next

    return head
}

fun insertAfterPosition(head: DSANode, position: Int, newData: Int): DSANode {
    if (position < 1) return head

    var currentDSANode: DSANode? = head

    if (position == 1) {
        val newDSANode = DSANode(data = newData)
        newDSANode.next = head
        return newDSANode
    }

    for (i in 1..<position - 1) {
        if (currentDSANode == null) {
            break
        }
        currentDSANode = currentDSANode.next
    }

    if (currentDSANode == null) return head

    val newDSANode = DSANode(data = newData)
    newDSANode.next = currentDSANode.next
    currentDSANode.next = newDSANode

    return head
}

fun insertAfterElement(head: DSANode, key: Int, newData: Int): DSANode {
    var currDSANode: DSANode? = head

    while (currDSANode != null) {
        if (currDSANode.data == key) {
            break
        }
        currDSANode = currDSANode.next
    }

    if (currDSANode == null) {
        println("Unable to insert")
        return head
    }

    val newDSANode = DSANode(data = newData)

    newDSANode.next = currDSANode.next
    currDSANode.next = newDSANode
    return head
}

fun insertAtEnd(head: DSANode, key: Int): DSANode {
    val newDSANode = DSANode(data = key)
    var currDSANode: DSANode? = head

    while (currDSANode?.next != null) {
        currDSANode = currDSANode.next
    }

    currDSANode?.next = newDSANode
    return head
}

fun getLinkedListLength(head: DSANode?): Int {
    if (head == null) return 0
    var count = 0
    var currentDSANode: DSANode? = head

    while (currentDSANode != null) {
        currentDSANode = currentDSANode.next
        count++
    }

    return count
}

fun printLinkedList(head: DSANode?) {
    if (head == null) return
    var currentDSANode: DSANode? = head

    while (currentDSANode != null) {
        print(currentDSANode.data)

        if (currentDSANode.next != null) {
            print(" -> ")
        }
        currentDSANode = currentDSANode.next
    }
    println()
}

fun insertAtFirst(head: DSANode?, key: Int): DSANode {
    val newDSANode = DSANode(data = key)
    newDSANode.next = head
    return newDSANode
}