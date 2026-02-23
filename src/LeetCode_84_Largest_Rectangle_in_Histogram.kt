import java.util.ArrayDeque
class LeetCode_84_Largest_Rectangle_in_Histogram {

    fun largestRectangleArea(heights: IntArray): Int {
        var maxArea = 0
        val stack = ArrayDeque<Int>()
        val n = heights.size

        for (i in 0 until n) {
            while(stack.isNotEmpty() && heights[stack.peekLast()] >= heights[i]) {
                val top = stack.removeLast()
                val l = if(stack.isEmpty()) i else i - stack.peekLast() - 1
                maxArea = maxOf(maxArea, l * heights[top])
            }

            stack.addLast(i)
        }

        while(stack.isNotEmpty()) {
            val top = stack.removeLast()
            val l = if(stack.isEmpty()) n else n - stack.peekLast() - 1
            maxArea = maxOf(maxArea, l * heights[top])
        }

        return maxArea
    }

    fun largestRectangleAreaNaive(heights: IntArray): Int {
        var maxArea = 0

        for (i in 0 until heights.size) {
            var cA = heights[i]

            for (j in i - 1 downTo 0) {
                if (heights[j] >= heights[i]) cA += heights[i]
                else break
            }

            for (j in i + 1 until heights.size) {
                if (heights[j] >= heights[i]) cA += heights[i]
                else break
            }
            maxArea = maxOf(maxArea, cA)
        }

        return maxArea
    }
}

fun main() {
    val problem = LeetCode_84_Largest_Rectangle_in_Histogram()
    val heights = intArrayOf(2, 1, 5, 6, 2, 3)
    val result = problem.largestRectangleArea(heights)
    println(result)
}