class LeetCode_981_Time_Based_Key_Value_Store {
    class Data(val value: String, val timeStamp: Int)

    val hMap = HashMap<String, ArrayList<Data>>()

    //    0(log(n)) Solution
    fun set(key: String, value: String, timestamp: Int) {
        if (!hMap.contains(key)) {
            hMap[key] = ArrayList<Data>()
        }
        hMap[key]?.add(Data(value, timestamp))
    }

    fun get(key: String, timestamp: Int): String {
        val list = hMap[key] ?: return ""
        var left = 0
        var right = list.size - 1
        var result = ""

        while (left <= right) {
            val mid = left + (right - left) / 2
            if (list[mid].timeStamp <= timestamp) {
                result = list[mid].value
                left =mid + 1
            } else right = mid - 1
        }
        return result
    }

    // 0(n) solution
//    class ListNode(val data: String, val timeStamp: Int) {
//        var next: ListNode? = null
//    }
//
//    private val hMap = HashMap<String, ListNode>()
//    fun set(key: String, value: String, timestamp: Int) {
//        val head = hMap[key]
//        val newNode = ListNode(value, timestamp)
//        newNode.next = head
//        hMap[key] = newNode
//    }
//
//    fun get(key: String, timestamp: Int): String {
//        var head: ListNode? = hMap[key]
//
//        while(head!= null && head.timeStamp > timestamp) {
//            head = head.next
//        }
//        return head?.data ?: ""
//    }
}

fun main() {
    val timeMap = LeetCode_981_Time_Based_Key_Value_Store()
    timeMap.set("foo", "bar", 1)  // store the key "foo" and value "bar" along with timestamp = 1.
    println(timeMap.get("foo", 1))     // return "bar"
    println(
        timeMap.get(
            "foo",
            3
        )
    )    // return "bar", since there is no value corresponding to foo at timestamp 3 and timestamp 2, then the only value is at timestamp 1 is "bar".
    timeMap.set("foo", "bar2", 4) // store the key "foo" and value "bar2" along with timestamp = 4.
    println(timeMap.get("foo", 4))        // return "bar2"
    println(timeMap.get("foo", 5))       // return "bar2"

}