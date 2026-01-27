import utils.createList
import utils.printList

object LeetCode_21_merge_two_lists {

    fun mergeTwoListsUsingDummy(list1: ListNode?, list2: ListNode?): ListNode?  {
        val dummy = ListNode(-1)
        var currNode = dummy
        var n1 = list1
        var n2 = list2

        while(n1!= null && n2 != null) {
            if(n1.`val` <= n2.`val`) {
                currNode.next = n1
                n1 = n1.next
            }
            else {
                currNode.next = n2
                n2 = n2.next
            }
            currNode = currNode.next!!
        }

        currNode.next = n1 ?: n2

        return dummy.next
    }

    fun mergeTwoLists(list1: ListNode?, list2: ListNode?): ListNode? {
        if(list1 == null) return list2
        if(list2 == null) return list1

        val head = if(list1.`val` < list2.`val`) list1 else list2

        var n1 = list1
        var n2 = list2
        var pn1: ListNode? = null


        while (n1 != null && n2 != null) {
            if (n1.`val` < n2.`val`) {
                pn1 = n1
                n1 = n1.next
            } else {
                val nxt2 = n2.next

                pn1?.next = n2
                n2.next = n1

                pn1 = n2
                n2 = nxt2
            }
        }

        if (n1 == null) {
            pn1?.next = n2
        }

        return head
    }
}



fun main() {
    val list1 = createList(intArrayOf(1,2,4))
    val list2 = createList(intArrayOf(1,3,4))

    val newHead = LeetCode_21_merge_two_lists.mergeTwoListsUsingDummy(list1, list2)
    printList(newHead)
}