class LeetCode_242_Valid_Anagram {
    fun isAnagram(s: String, t: String): Boolean {
        if(s.length != t.length) return false
        val freqMap = IntArray(26)

        for(i in s) {
            freqMap[i - 'a']++
        }

        for(i in t) {
            freqMap[i - 'a']--
            if(freqMap[i - 'a'] < 0) return false
        }

        return true
    }
}