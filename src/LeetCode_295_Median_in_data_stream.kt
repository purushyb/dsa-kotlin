import java.util.Collections
import java.util.PriorityQueue

class LeetCode_295_Median_in_data_stream {
    private val minPQ = PriorityQueue<Int>()
    private val maxPQ = PriorityQueue<Int>(Collections.reverseOrder())

    fun addNum(num: Int) {
        maxPQ.offer(num)
        val temp = maxPQ.poll()
        minPQ.offer(temp)

        if (minPQ.size > maxPQ.size) {
            maxPQ.offer(minPQ.poll())
        }
    }

    fun findMedian(): Double {
        if (minPQ.size != maxPQ.size) {
            return maxPQ.peek().toDouble()
        } else {
            return (minPQ.peek() + maxPQ.peek()) / 2.0
        }
    }
}

fun main() {
    val medianFinder = LeetCode_295_Median_in_data_stream()
    medianFinder.addNum(-1);    // arr = [1]
    medianFinder.addNum(-2);    // arr = [1, 2]
    println(medianFinder.findMedian()); // return 1.5 (i.e., (1 + 2) / 2)
    medianFinder.addNum(-3);    // arr[1, 2, 3]
    println(medianFinder.findMedian()); // return 2.0
}