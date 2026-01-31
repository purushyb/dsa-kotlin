class LeetCode_409_Longest_Palindrom2 {
    fun longestPalindrome(s: String): Int {
        var maxLen = 0
        val hSet = HashSet<Char>()
        for (i in s) {
            if(hSet.remove(i)) {
                maxLen +=2
            }
            else{
                hSet.add(i)
            }
        }
        return if (s.length > maxLen)  maxLen + 1 else maxLen
    }
}

fun main() {
    println(LeetCode_409_Longest_Palindrom2().longestPalindrome("bcccb"))
}