import java.util.LinkedList

object LeetCode_17_Letter_Combination_Phone_number {
    fun letterCombinations(digits: String): List<String> {
        val digitsMap = arrayOf("abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz")
        var results = listOf<String>("")

        for (digit in digits) {
            val currLetters = digitsMap[digit - '2']
            val temp = mutableListOf<String>()

            for (prefix in results) {
                for (letter in currLetters) {
                    temp.add(prefix + letter)
                }
            }

            results = temp
        }
        return results
    }

    fun letterCombinationsBFSStyle(digits: String): List<String> {
        val digitsMap = arrayOf("abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz")

        val queue = LinkedList<String>()

        queue.offer("")

        for (currLevel in 0..<digits.length) {
            val currPrefixIndex = digits[currLevel] - '2'

            while(queue.peek().length == currLevel){
                val currPrefix = queue.poll()
                for (i in digitsMap[currPrefixIndex]) {
                    queue.add(currPrefix + i)
                }
            }
        }

        return queue
    }
}

fun main() {
    val digits = "234"
    println(LeetCode_17_Letter_Combination_Phone_number.letterCombinationsBFSStyle(digits))
}