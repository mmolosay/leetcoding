package easy

/**
 * [26. Remove Duplicates from Sorted Array](https://leetcode.com/problems/remove-duplicates-from-sorted-array/)
 */
fun e26_removeDuplicates(nums: IntArray): Int {
    var i = 1 // insert index
    var j = 1 // search index
    while (j < nums.size) {
        if (nums[j - 1] != nums[j]) {
            nums[i] = nums[j]
            i++
        }
        j++
    }
    return i
}