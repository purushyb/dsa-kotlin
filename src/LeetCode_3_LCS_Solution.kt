object LeetCode_3_LCS_Solution {

    fun lengthOfLongestSubstring(s: String): Int {
        val map = mutableMapOf<Char, Int>()
        var maxLength = 0
        var leftPointer = 0

        s.forEachIndexed { rightPointer, currChar ->

            leftPointer = maxOf(leftPointer, map.getOrDefault(currChar, - 1) + 1)

            map[currChar] = rightPointer

            maxLength = maxOf(maxLength, rightPointer - leftPointer + 1)

        }

        return maxLength
    }
}

fun main() {
    val input1 = "abcabcbb"
    println(LeetCode_3_LCS_Solution.lengthOfLongestSubstring(input1))

    val input2 = "bbbbb"
    println(LeetCode_3_LCS_Solution.lengthOfLongestSubstring(input2))

    val input3 = "pwwkew"
    println(LeetCode_3_LCS_Solution.lengthOfLongestSubstring(input3))
}