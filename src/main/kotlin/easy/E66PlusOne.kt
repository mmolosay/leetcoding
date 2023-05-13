package easy

/**
 * [66. Plus One](https://leetcode.com/problems/plus-one/)
 */
fun e66_plusOne(digits: IntArray): IntArray {
    if (digits.last() != 9) {
        return digits.also { it[it.lastIndex] = digits.last() + 1 }
    } else {
        var first9Index = digits.size // index of first 9 in a sequence of trailing 9s: =3 in 1239999
        while (first9Index > 0) {
            if (digits[first9Index - 1] != 9) break
            first9Index--
        }
        return if (first9Index != 0) {
            for (i in first9Index..digits.lastIndex) {
                digits[i] = 0
            }
            digits.also { it[first9Index - 1] = it[first9Index - 1] + 1 }
        } else {
            IntArray(digits.size + 1) { i ->
                if (i == 0) 1
                else 0
            }
        }
    }
}