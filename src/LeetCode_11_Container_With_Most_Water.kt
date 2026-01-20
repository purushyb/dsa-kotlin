object LeetCode_11_Container_With_Most_Water {
    fun maxArea(height: IntArray): Int {
        var lp = 0
        var rp = height.size - 1
        var maxArea = 0

        while (lp < rp) {
            val currArea = minOf(height[lp], height[rp]) * (rp - lp)

            if (currArea > maxArea) maxArea = currArea

            if (height[lp] > height[rp]) rp--
            else lp++
        }

        return maxArea
    }
}

fun main() {
    val ip = intArrayOf(1, 8, 6, 2, 5, 4, 8, 3, 7)

    println(LeetCode_11_Container_With_Most_Water.maxArea(ip))
}