class LeetCode_278_First_Bad_Version: VersionControl() {
    override fun firstBadVersion(n: Int) : Int {
        var low = 1
        var high = n

        while(low < high) {
            val mid = low + ( high - low) / 2

            if(isBadVersion(mid)) {
                high = mid
            }
            else {
                low = mid + 1
            }
        }

        return low

    }

    private fun binarySearchForElement(low: Int, high: Int): Int {
        if(low <= high) {
            val mid = low + (high - low) / 2
            return if(isBadVersion(mid)) {
                if(!isBadVersion(mid - 1)) mid
                else binarySearchForElement(low, mid - 1)
            } else {
                binarySearchForElement(mid + 1, high)
            }
        }
        return -1
    }
}

abstract class VersionControl {
    open fun firstBadVersion(n: Int) : Int { return 0}

    fun isBadVersion(version: Int): Boolean {
        println("Checking for $version")
        return version >= 4
    }
}

fun main() {
    println(LeetCode_278_First_Bad_Version().firstBadVersion(5))
}