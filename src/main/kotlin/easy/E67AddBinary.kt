package easy

/**
 * [67. Add Binary](https://leetcode.com/problems/add-binary/)
 */
fun e67_addBinary_1(a: String, b: String): String {
    if (a == "0") return b
    if (b == "0") return a
    var shouldIncrement = false
    val maxLength = maxOf(a.length, b.length)
    val builder = StringBuilder(maxLength + 1) // 11 + 11 == 110
    var i = 0

    while (i != maxLength) {
        val c1 = a.getOrNull(a.lastIndex - i) ?: '0'
        val c2 = b.getOrNull(b.lastIndex - i) ?: '0'
        if (c1 == c2 && c1 == '1') {
            builder.insert(0, if (shouldIncrement) '1' else '0')
            shouldIncrement = true
        }
        if (c1 == c2 && c1 == '0') {
            builder.insert(0, if (shouldIncrement) '1' else '0')
            shouldIncrement = false
        }
        if (c1 != c2) {
            builder.insert(0, if (shouldIncrement) '0' else '1')
        }
        i++
    }
    if (shouldIncrement) builder.insert(0, '1')
    return builder.toString()
}

fun e67_addBinary_2(a: String, b: String): String {
    return (a.toBigInteger(2) + b.toBigInteger(2)).toString(2)
}