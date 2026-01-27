import utils.createList
import utils.printList
import java.util.PriorityQueue

object LeetCode_23_Merge_K_Sorted_Lists {

    fun mergeKLists(lists: Array<ListNode?>): ListNode? {
        val dummy = ListNode(-1)
        val pq = PriorityQueue<ListNode> { a, b -> a.`val` - b.`val` }
        var cN = dummy

        for (i in 0..<lists.size) {
            val currEle = lists[i]
            if (currEle != null) {
                pq.offer(currEle)
            }
        }

        while (pq.isNotEmpty()) {
            val minNode = pq.poll()

            cN.next = minNode
            cN = cN.next!!

            if(minNode.next != null){
                pq.offer(minNode.next!!)
            }
        }

        return dummy.next
    }

    fun mergeKListsNaiveApproach(lists: Array<ListNode?>): ListNode? {

        var isNodesActive = true

        val dummy = ListNode(-1)
        var cN = dummy

        while (isNodesActive) {
            isNodesActive = false
            var cMPos = -1
            for (i in 0..<lists.size) {
                if (lists[i] == null) continue
                isNodesActive = true
                if (cMPos == -1) {
                    cMPos = i
                } else if (lists[cMPos]!!.`val` > lists[i]!!.`val`) {
                    cMPos = i
                }
            }

            if (isNodesActive) {
                cN.next = lists[cMPos]
                lists[cMPos] = lists[cMPos]?.next
                cN = cN.next!!
            }
        }

        return dummy.next
    }
}


fun main() {
    val list1 = createList(intArrayOf(1, 2, 4))
    val list2 = createList(intArrayOf(1, 3, 4))

    val newHead = LeetCode_23_Merge_K_Sorted_Lists.mergeKLists(arrayOf(list1, list2))
    printList(newHead)
}