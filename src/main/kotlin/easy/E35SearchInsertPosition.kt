package easy

/**
 * [35. Search Insert Position](https://leetcode.com/problems/search-insert-position/)
 */
fun e35_searchInsert_1(nums: IntArray, target: Int): Int {
    return searchInsertRecursively(
        nums = nums,
        target = target,
        leftInclusive = 0,
        rightExclusive = nums.size,
    )
}

fun e35_searchInsert_2(nums: IntArray, target: Int): Int {
    var left = 0
    var right = nums.size - 1
    while (left <= right) {
        val mid = (left + right) / 2
        if (nums[mid] == target) return mid
        if (nums[mid] > target) {
            right = mid - 1
        } else {
            left = mid + 1
        }
    }
    return left
}

private fun searchInsertRecursively(
    nums: IntArray,
    target: Int,
    leftInclusive: Int,
    rightExclusive: Int,
): Int {
    if (leftInclusive == rightExclusive) return leftInclusive
    val middle = leftInclusive + (rightExclusive - leftInclusive) / 2
    if (nums[middle] == target) return middle
    return if (nums[middle] < target) {
        searchInsertRecursively(nums, target, middle + 1, rightExclusive)
    } else {
        searchInsertRecursively(nums, target, 0, middle)
    }
}