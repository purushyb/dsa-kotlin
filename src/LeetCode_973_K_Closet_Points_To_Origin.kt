import java.util.PriorityQueue
import kotlin.math.pow
import kotlin.math.sqrt

class LeetCode_973_K_Closet_Points_To_Origin {
    fun kClosest(points: Array<IntArray>, k: Int): Array<IntArray> {
        val pq = PriorityQueue<IntArray>({ a, b ->
            (b[0] * b[0] + b[1] * b[1]) - (a[0] * a[0] + a[1] * a[1])
        })

        points.forEach { point ->
            pq.offer(point)
            if (pq.size > k) pq.poll()
        }

        return pq.toTypedArray()
    }

    fun kClosestNaive(points: Array<IntArray>, k: Int): Array<IntArray> {
        val pq = PriorityQueue<Pair<Double, Int>>(k, compareByDescending { it.first })
        val result = Array(k) { intArrayOf() }

        points.forEachIndexed { i, (x, y) ->
            val d = sqrt(x.toDouble().pow(2) + y.toDouble().pow(2))
            pq.offer(d to i)
            if (pq.size > k) pq.poll()
        }

        for (i in 0 until k) {
            val point = points[pq.poll().second]
            result[i] = point
        }

        return result
    }
}

fun main() {
    val problem = LeetCode_973_K_Closet_Points_To_Origin()
    val input = arrayOf(intArrayOf(3, 3), intArrayOf(5, -1), intArrayOf(-2, 4))
    val result = problem.kClosest(input, 2)
    result.forEach {
        println(it.contentToString())
    }
}