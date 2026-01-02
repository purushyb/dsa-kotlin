fun main() {
    val inputArray = arrayOf<Int>(1, 4, 2, 10, 23, 3, 1, 0, 20)
    val subArraySize = 4

    println(maxSubArraySum(inputArray, subArraySize))

    val inputArrayForProduct = arrayOf<Int>(1, 9, 2, 8, 6, 4, 3)
    val desiredProduct = 100

    println(subArraysWithProductLessThanDesiredProduct(inputArrayForProduct, desiredProduct))
}

fun maxSubArraySum(arr: Array<Int>, subArraySize: Int): Int {
    var maxSum = 0

    for (i in 0..<subArraySize) {
        maxSum += arr[i]
    }

    var currentSum = maxSum

    for (i in subArraySize..<arr.size) {
        currentSum = currentSum - arr[i - subArraySize] + arr[i]
        maxSum = maxOf(currentSum, maxSum)
    }

    return maxSum
}

fun subArraysWithProductLessThanDesiredProduct(arr: Array<Int>, productDesired: Int): Int {

    if (productDesired <= 1) return 0

    var subArrayCount = 0
    var windowProduct = 1
    var leftIndex = 0

    for (rightIndex in 0..<arr.size) {
        windowProduct *= arr[rightIndex]

        while (windowProduct >= productDesired) {
            windowProduct /= arr[leftIndex]
            leftIndex++
        }

        subArrayCount += (rightIndex - leftIndex) + 1
    }
    return subArrayCount
}