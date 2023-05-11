package easy

/**
 * [14. Longest Common Prefix](https://leetcode.com/problems/longest-common-prefix/)
 */
fun e14_longestCommonPrefix_1(strings: Array<String>): String {
    if (strings.size == 1) return strings.first()
    var length = 1
    var lastCandidate = ""
    val first = strings.first()
    while (true) {
        val candidate = if (first.length < length) return first else first.take(length++)
        for (string in strings) {
            if (string.isEmpty()) return ""
            if (!string.startsWith(candidate)) return lastCandidate
        }
        lastCandidate = candidate
    }
}

fun e14_longestCommonPrefix_2(strings: Array<String>): String {
    for (i in strings.first().indices) {
        val char = strings.first()[i]
        for (j in 1 until strings.size) {
            if (i == strings[j].length || strings[j][i] != char) {
                return strings.first().substring(0, i)
            }
        }
    }
    return strings.first()
}