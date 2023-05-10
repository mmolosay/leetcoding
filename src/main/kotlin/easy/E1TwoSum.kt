package easy

/**
 * [1. Two Sum](https://leetcode.com/problems/two-sum/)
 */
fun e1twoSum(nums: IntArray, target: Int): IntArray {
    val traversed = mutableMapOf<Int, Int>()
    for (i in nums.indices) {
        val counterpart = target - nums[i]
        val index = traversed[counterpart]
        if (index != null) {
            return intArrayOf(i, index)
        } else {
            traversed[nums[i]] = i
        }
    }
    error("Unreachable")
}