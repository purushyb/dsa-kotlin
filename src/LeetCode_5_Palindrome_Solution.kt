object LeetCode_5_Palindrome_Solution {

    fun longestPalindromeEvenOddLength(s: String): String {
        val strSize = s.length
        var maxSize = 0
        var startIndex = 0

        for (i in 0..<strSize) {
            for (j in 0..1) {
                var low = i
                var high = low + j

                while (low >= 0 && high < strSize && s[low] == s[high]) {
                    val currSize = high - low + 1
                    if (maxSize < currSize) {
                        startIndex = low
                        maxSize = currSize
                    }

                    low--
                    high++
                }
            }
        }

        return s.substring(startIndex, startIndex + maxSize)
    }

    fun longestPalindromeDP(s: String): String {
        val strSize = s.length
        val dp = Array(strSize + 1) { Array<Int>(strSize + 1) { 0 } }
        var maxLength = 0
        var startIndex = 0

        for (i in 0..<strSize) {
            dp[i][i] = 1
        }
        maxLength = 1

        for (i in 0..<strSize - 1) {
            if (s[i] == s[i + 1]) {
                dp[i][i + 1] = 1
                startIndex = i
                maxLength = 2
            }
        }

        for (len in 3..strSize) {
            for (j in 0..strSize - len) {
                val k = j + len - 1
                if (s[j] == s[k] && dp[j + 1][k - 1] == 1) {
                    dp[j][k] = 1
                    if (maxLength < len) {
                        startIndex = j
                        maxLength = len
                    }
                }
            }
        }

        return s.substring(startIndex, startIndex + maxLength)
    }
}


fun main() {
    val input = "babd"
    val result = LeetCode_5_Palindrome_Solution.longestPalindromeDP(input)
    println(result)

    val result1 = LeetCode_5_Palindrome_Solution.longestPalindromeEvenOddLength(input)
    println(result1)
}