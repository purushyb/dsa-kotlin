class LeetCode_42_Trapping_Rain_Water {
    fun trap(height: IntArray): Int {
        var wc = 0
        var l = 0
        var r = height.size - 1
        var lMax = 0
        var rMax = 0

        while (l < r) {
            if (height[l] < height[r]) {
                if (height[l] >= lMax) {
                    lMax = height[l]
                } else {
                    wc += lMax - height[l]
                }
                l++
            } else {
                if (height[r] >= rMax) {
                    rMax = height[r]
                } else {
                    wc += rMax - height[r]
                }
                r--
            }
        }
        return wc
    }
}

fun main() {
    val input = intArrayOf(0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1)
    println(LeetCode_42_Trapping_Rain_Water().trap(input))
}