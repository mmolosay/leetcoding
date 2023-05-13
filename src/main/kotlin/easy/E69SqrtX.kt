package easy

/**
 * [69. Sqrt(x)](https://leetcode.com/problems/sqrtx/)
 */
fun e69_mySqrt_1(x: Int): Int {
    // binary search
    var left = 0
    var right = x
    while (left <= right) {
        val mid = left + (right - left) / 2
        val squared = mid.toLong() * mid // prevent falling out of Int's bounds
        when {
            squared > x -> right = mid - 1
            squared < x -> left = mid + 1
            else -> return mid
        }
    }
    return right // left > right at this point
}

fun e69_mySqrt_2(x: Int): Int {
    // Newton's method
    if (x == 0) return 0
    var result = x.toLong()
    while (result * result - x >= 1) {
        result = (result + x / result) / 2
    }
    return result.toInt()
}