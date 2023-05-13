package easy

/**
 * [58. Length of Last Word](https://leetcode.com/problems/length-of-last-word/)
 */
fun e58_lengthOfLastWord_1(s: String): Int {
    var i = s.lastIndex
    var wordStart: Int? = null
    while (i >= 0) {
        if (s[i] == ' ') {
            if (wordStart != null) return wordStart - i
        } else {
            if (wordStart == null) wordStart = i
        }
        i--
    }
    return (wordStart ?: 0) + 1
}

fun e58_lengthOfLastWord_2(s: String): Int {
    var length = 0
    for (i in s.lastIndex downTo 0) {
        if (s[i] != ' ') {
            length++
        } else {
            if (length != 0) return length
        }
    }
    return length
}