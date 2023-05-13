package easy

/**
 * [28. Find the Index of the First Occurrence in a String](https://leetcode.com/problems/find-the-index-of-the-first-occurrence-in-a-string/)
 */
fun e28_firstIndex(haystack: String, needle: String): Int {
    if (needle.length > haystack.length) return -1
    var i = 0
    outer@ while (i < haystack.length - needle.lastIndex) {
        if (haystack[i] == needle.first()) {
            var ii = i + 1
            for (j in 1 until needle.length) {
                if (haystack[ii++] != needle[j]) {
                    i++
                    continue@outer
                }
            }
            return i
        }
        i++
    }
    return -1
}