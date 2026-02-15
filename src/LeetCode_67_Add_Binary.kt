class LeetCode_67_Add_Binary {

    fun addBinary(a: String, b: String): String {
        var i = a.length - 1
        var j = b.length - 1

        val result = StringBuilder()
        var carry = 0

        while(i >= 0 || j >= 0 || carry == 1) {
            var tempSum = carry
            if(i >= 0) {
                tempSum += a[i] - '0'
                i--
            }

            if(j >= 0) {
                tempSum += b[j] - '0'
                j--
            }

            result.append(tempSum % 2)
            carry = tempSum / 2
        }

        return result.reverse().toString()
    }

    fun addBinaryNaive(a: String, b: String): String {
        val tempA = if (b.length > a.length) a else b
        val tempB = if (tempA == a) b else a

        val diff = tempB.length - tempA.length

        val result = StringBuilder()
        var carry = 0

        for (i in (tempA.length - 1)downTo 0) {
            val tempSum = (tempA[i] - '0') + (tempB[i + diff] - '0') + carry
            result.append(tempSum % 2)
            carry = tempSum / 2
        }

        for (i in diff - 1 downTo 0) {
            val tempSum = (tempB[i] - '0') + carry
            result.append(tempSum % 2)
            carry = (tempSum) / 2
        }

        if(carry == 1) result.append(carry)

        return result.reversed().toString()
    }
}

fun main() {
    val problem = LeetCode_67_Add_Binary()

    val a = "11"
    val b = "1"
    val result = problem.addBinary(a, b)
    println(result)

    val a1 = "1010"
    val b1 = "1011"
    val result1 = problem.addBinary(a1, b1)
    println(result1)

    val a2 = "11"
    val b2 = "1"
    val result2 = problem.addBinary(a2, b2)
    println(result2)

    val a3 = "1"
    val b3 = "1"
    val result3 = problem.addBinary(a3, b3)
    println(result3)

    val a4 = "0"
    val b4 = "0"
    val result4 = problem.addBinary(a4, b4)
    println(result4)
}