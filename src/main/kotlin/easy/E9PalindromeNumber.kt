package easy

fun e9_isPalindrome_1(number: Int): Boolean {
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

fun e9_isPalindrome_2(number: Int): Boolean {
    if (number < 0 || (number % 10 == 0 && number != 0)) return false
    var copy = number
    var reverted = 0
    while (copy > reverted) {
        reverted = reverted * 10 + (copy % 10)
        copy /= 10
    }
    return (copy == reverted || copy == reverted / 10)
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