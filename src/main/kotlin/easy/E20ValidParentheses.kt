package easy

/**
 * [20. Valid Parentheses](https://leetcode.com/problems/valid-parentheses/)
 */
fun e20_isValid(s: String): Boolean {
    val opened = ArrayDeque<Char>(s.length / 2)
    for (char in s) {
        if (char.isOpeningParentheses) {
            opened.addLast(char)
        } else {
            val lastOpened = if (opened.isEmpty()) return false else opened.removeLast()
            if (!lastOpened.isParenthesesCounterpartTo(char)) return false
        }
    }
    return opened.isEmpty()
}

private val Char.isOpeningParentheses: Boolean
    get() = (this == '(' || this == '{' || this == '[')

private fun Char.isParenthesesCounterpartTo(other: Char): Boolean =
    when (this) {
        '(' -> other == ')'
        '{' -> other == '}'
        '[' -> other == ']'
        else -> error("Illegal char")
    }