package easy

/**
 * [88. Merge Sorted Array](https://leetcode.com/problems/merge-sorted-array/)
 */
fun e88_merge(nums1: IntArray, m: Int, nums2: IntArray, n: Int): Unit {
    if (n == 0) return
    var i = m + n - 1 // end of nums1, index in nums1 we insert into
    var j = m - 1 // true end of nums1, index in nums1 we take from
    var k = n - 1 // true end of nums2, index in nums2 we take from
    if (j == -1) {
        while (k >= 0) {
            nums1[i--] = nums2[k--]
        }
    } else {
        while (i >= 0) {
            if (j >= 0 && k >= 0) { // while we haven't reached the end of any array
                if (nums1[j] > nums2[k]) {
                    nums1[i--] = nums1[j--]
                } else {
                    nums1[i--] = nums2[k--]
                }
            } else { // when we had
                if (j < 0) { // if elements left in nums2, copy them in nums1
                    nums1[i--] = nums2[k--]
                } else { // else, if elements left in nums1, they are already where they are supposed to be
                    break
                }
            }
        }
    }
}