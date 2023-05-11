package easy

/**
 * [13. Roman to Integer](https://leetcode.com/problems/roman-to-integer/)
 */
fun e13_romanToInt_1(s: String): Int {
    var i = 0
    var int = 0
    val map = mapOf(
        'I' to 1,
        'V' to 5,
        'X' to 10,
        'L' to 50,
        'C' to 100,
        'D' to 500,
        'M' to 1000,
    )
    while (i < s.length) {
        val current = map.getValue(s[i])
        if (i != s.lastIndex) {
            val next = map.getValue(s[i + 1])
            if (current < next) { // surrogate pair
                int += (next - current)
                i++
            } else {
                int += current
            }
        } else {
            int += current
        }
        i++
    }
    return int
}

fun e13_romanToInt_2(s: String): Int {
    var int = s.last().romanToInt()
    var i = s.lastIndex - 1
    while (i >= 0) {
        val current = s[i].romanToInt()
        val next = s[i + 1].romanToInt()
        if (current < next) {
            int -= current
        } else {
            int += current
        }
        i--
    }
    return int
}

private fun Char.romanToInt(): Int =
    when (this) {
        'I' -> 1
        'V' -> 5
        'X' -> 10
        'L' -> 50
        'C' -> 100
        'D' -> 500
        'M' -> 1000
        else -> error("Illegal symbol")
    }