data class Node(val data: Int, var next: Node? = null)

fun main() {
    var head: Node? = Node(data = 1)
    head?.next = Node(data = 2)
    head?.next?.next = Node(data = 3)
    head?.next?.next?.next = Node(data = 4)

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

    val cyclicLinkedListHead = Node(1)
    cyclicLinkedListHead.next = Node(3)
    cyclicLinkedListHead.next?.next = Node(4)
    cyclicLinkedListHead.next?.next?.next = cyclicLinkedListHead.next

    println("Is cycle found ${floydCycleDetection(cyclicLinkedListHead)}")

}

fun floydCycleDetection(head: Node?): Boolean {
    var slowPointer: Node? = head?.next
    var fastPointer: Node? = head?.next?.next

    while (slowPointer != null && fastPointer != null && fastPointer.next != null) {
        if (slowPointer == fastPointer) return true

        slowPointer = slowPointer.next
        fastPointer = fastPointer.next?.next
    }

    return false
}

fun reverseLinkedList(head: Node?): Node? {
    if (head == null) return head

    var current: Node? = head
    var prev: Node? = null
    var next: Node? = null

    while (current != null) {
        next = current.next
        current.next = prev

        prev = current
        current = next
    }

    return prev

}

fun deleteNodeAtStart(head: Node?): Node? {
    if (head == null) return head
    val currHead = head.next
    head.next = null
    return currHead
}

fun deleteNodeAtEnd(head: Node?): Node? {
    if (head == null) return head

    if (head.next == null) return null

    var currNode = head

    while (currNode?.next?.next != null) {
        currNode = currNode.next
    }

    currNode?.next = null

    return head
}

fun deleteNodeAtPosition(head: Node?, position: Int): Node? {
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

fun insertAfterPosition(head: Node, position: Int, newData: Int): Node {
    if (position < 1) return head

    var currentNode: Node? = head

    if (position == 1) {
        val newNode = Node(data = newData)
        newNode.next = head
        return newNode
    }

    for (i in 1..<position - 1) {
        if (currentNode == null) {
            break
        }
        currentNode = currentNode.next
    }

    if (currentNode == null) return head

    val newNode = Node(data = newData)
    newNode.next = currentNode.next
    currentNode.next = newNode

    return head
}

fun insertAfterElement(head: Node, key: Int, newData: Int): Node {
    var currNode: Node? = head

    while (currNode != null) {
        if (currNode.data == key) {
            break
        }
        currNode = currNode.next
    }

    if (currNode == null) {
        println("Unable to insert")
        return head
    }

    val newNode = Node(data = newData)

    newNode.next = currNode.next
    currNode.next = newNode
    return head
}

fun insertAtEnd(head: Node, key: Int): Node {
    val newNode = Node(data = key)
    var currNode: Node? = head

    while (currNode?.next != null) {
        currNode = currNode.next
    }

    currNode?.next = newNode
    return head
}

fun getLinkedListLength(head: Node?): Int {
    if (head == null) return 0
    var count = 0
    var currentNode: Node? = head

    while (currentNode != null) {
        currentNode = currentNode.next
        count++
    }

    return count
}

fun printLinkedList(head: Node?) {
    if (head == null) return
    var currentNode: Node? = head

    while (currentNode != null) {
        print(currentNode.data)

        if (currentNode.next != null) {
            print(" -> ")
        }
        currentNode = currentNode.next
    }
    println()
}

fun insertAtFirst(head: Node?, key: Int): Node {
    val newNode = Node(data = key)
    newNode.next = head
    return newNode
}