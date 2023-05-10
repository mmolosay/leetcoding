package medium

/**
 * [59. Spiral Matrix II](https://leetcode.com/problems/spiral-matrix-ii/)
 */
fun m59_makeSpiralMatrix(order: Int): Array<IntArray> {
    val result = Array(order) { IntArray(order) }
    val total = order * order
    var ordinal = 1
    var r = 0
    var c = 0
    var leftToRight = true
    var topToBottom = true
    var fillingHorizontally = true
    while (ordinal <= total) {
        if (fillingHorizontally) {
            if (leftToRight) {
                if (c + 1 <= order && result[r][c] == 0) {
                    result[r][c++] = ordinal++
                } else {
                    fillingHorizontally = false
                    leftToRight = false
                    r++
                    c--
                }
            } else {
                if (c >= 0 && result[r][c] == 0) {
                    result[r][c--] = ordinal++
                } else {
                    fillingHorizontally = false
                    leftToRight = true
                    r--
                    c++
                }
            }
        } else {
            if (topToBottom) {
                if (r + 1 <= order && result[r][c] == 0) {
                    result[r++][c] = ordinal++
                } else {
                    fillingHorizontally = true
                    topToBottom = false
                    c--
                    r--
                }
            } else {
                if (r - 1 >= 0 && result[r][c] == 0) {
                    result[r--][c] = ordinal++
                } else {
                    fillingHorizontally = true
                    topToBottom = true
                    c++
                    r++
                }
            }
        }
    }
    return result
}