package easy

fun e9isPalindrome(number: Int): Boolean {
    if (number < 0) return false
    if (number == 0) return true
    var copy = number
    var totalDigits = 0
    while (copy != 0) {
        copy /= 10
        totalDigits++
    }

    var l = 0
    var r = totalDigits - 1
    while (l < r) {
        if (number.digitAt(l++, totalDigits) != number.digitAt(r--, totalDigits)) return false
    }
    return true
}

private fun Int.digitAt(index: Int, totalDigits: Int): Int {
    val power = totalDigits - index - 1
    return (this / tenInPower(power)) % 10
}

private fun tenInPower(n: Int): Int {
    var result = 1
    for (i in 0 until n) {
        result *= 10
    }
    return result
}