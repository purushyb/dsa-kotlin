object LeetCode_383_Ransome_Note {

    fun canConstruct(ransomNote: String, magazine: String): Boolean {
        val table = HashMap<Char, Int>()

        for(i in magazine) {
            table[i] = table.getOrDefault(i, 0) + 1
        }

        for(i in ransomNote) {
            val temp = table.getOrDefault(i, 0)
            if(temp == 0) return false
            else table[i] = temp - 1
        }

        return true

    }

    fun canConstructOptimized(ransomNote: String, magazine: String): Boolean {
        val table = IntArray(26) {0}

        for(i in magazine) {
            table[i - 'a']++
        }

        for(i in ransomNote) {
            val temp = table[i - 'a']
            if(temp == 0) return false
            else table[i - 'a']--
        }

        return true

    }
}

fun main() {
    val ransomNote = "aa"
    val magazine = "aab"

    println(LeetCode_383_Ransome_Note.canConstructOptimized(ransomNote, magazine))
}