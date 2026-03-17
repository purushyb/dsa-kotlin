class LeetCode_125_Valid_Palindrome {
    fun isPalindrome(s: String): Boolean {
        var lp = 0
        var rp = s.length - 1

        while (lp < rp) {
            if (!s[lp].isLetterOrDigit()) lp++
            else if (!s[rp].isLetterOrDigit()) rp--
            else if (s[lp].equals(s[rp], ignoreCase = true)) {
                lp++
                rp--
            } else {
                return false
            }
        }

        return true
    }
}

fun main() {
    val problem = LeetCode_125_Valid_Palindrome()

    val input = "A man, a plan, a canal: Panama"
    val result = problem.isPalindrome(input)
    println(result)

    val input1 = "race a car"
    val result1 = problem.isPalindrome(input1)
    println(result1)

    val input2 = " "
    val result2 = problem.isPalindrome(input2)
    println(result2)

    val input3 = "0P"
    val result3 = problem.isPalindrome(input3)
    println(result3)
}