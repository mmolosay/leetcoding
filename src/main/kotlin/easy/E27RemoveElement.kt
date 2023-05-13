package easy

/**
 * [27. Remove Element](https://leetcode.com/problems/remove-element/)
 */
fun e27_removeElement(nums: IntArray, element: Int): Int {
    var size = nums.size
    var i = 0
    while (i < size) {
        if (nums[i] == element) {
            size--
            nums[i] = nums[size]
        } else {
            i++
        }
    }
    return size
}