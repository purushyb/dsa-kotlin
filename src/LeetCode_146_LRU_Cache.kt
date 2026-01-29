class LeetCode_146_LRU_Cache(val capacity: Int) {

    data class DLQNode(val key: Int, val data: Int, var next: DLQNode? = null, var prev: DLQNode? = null)

    private val hMap = HashMap<Int, DLQNode>()
    private val maxSize = capacity

    val head = DLQNode(-1, -1)
    val tail = DLQNode(-1, -1)

    init {
        head.next = tail
        tail.prev = head
    }

    fun get(key: Int): Int {
        if(!hMap.contains(key)) return -1

        val node = hMap[key]!!
        removeNode(node)
        addToHead(node)

        return node.data
    }

    fun put(key: Int, value: Int) {
        if (hMap.contains(key)) {
            removeNode(hMap[key]!!)
        }

        val newNode = DLQNode(key, value)
        addToHead(newNode)
        hMap[key] = newNode

        if(hMap.size > capacity) {
            val lastNode = tail.prev!!
            removeNode(lastNode)
            hMap.remove(lastNode.key)
        }
    }

    private fun removeNode(node: DLQNode) {
        val prevNode = node.prev
        val nextNode = node.next

        prevNode?.next = nextNode
        nextNode?.prev = prevNode
    }

    private fun addToHead(node: DLQNode) {
        val firstNode = head.next

        node.next = firstNode
        node.prev = head

        firstNode?.prev = node
        head.next = node

    }
}

class LRUCache(capacity: Int): LinkedHashMap<Int, Int>(capacity, 0.75f, true) {
    override fun removeEldestEntry(eldest: Map.Entry<Int?, Int?>?): Boolean {
        return super.removeEldestEntry(eldest)
    }

    override fun get(key: Int): Int {
        return this.getOrDefault(key, -1)
    }
}

fun main() {
    val capacity = 2
    val lRUCache = LeetCode_146_LRU_Cache(capacity)
    lRUCache.put(1, 1); // cache is {1=1}
    lRUCache.put(2, 2); // cache is {1=1, 2=2}
    println(lRUCache.get(1));    // return 1
    lRUCache.put(3, 3); // LRU key was 2, evicts key 2, cache is {1=1, 3=3}
    println(lRUCache.get(2));    // returns -1 (not found)
    lRUCache.put(4, 4) // LRU key was 1, evicts key 1, cache is {4=4, 3=3}
    lRUCache.put(4, 2)
    println(lRUCache.get(1));    // return -1 (not found)
    println(lRUCache.get(3));    // return 3
    println(lRUCache.get(4));    // return 4

}