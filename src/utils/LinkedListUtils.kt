package utils

import ListNode

fun createList(nums: IntArray): ListNode? {
    if (nums.isEmpty()) return null

    // Create the head (first node)
    val head = ListNode(nums[0])
    var current = head

    // Loop through the rest and link them
    for (i in 1 until nums.size) {
        val newNode = ListNode(nums[i])
        current.next = newNode
        current = newNode
    }

    return head
}

fun printList(head: ListNode?) {
    var current = head
    while (current != null) {
        print("${current.`val`} -> ")
        current = current.next
    }
    println("null")
}