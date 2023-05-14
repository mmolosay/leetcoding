package easy

import utils.ListNode
import utils.value

/**
 * [21. Merge Two Sorted Lists](https://leetcode.com/problems/merge-two-sorted-lists/)
 */
fun e21_mergeTwoLists_1(list1: ListNode?, list2: ListNode?): ListNode? {
    if (list1 == null) return list2
    if (list2 == null) return list1
    var n1 = list1
    var n2 = list2
    val head = if (n1.value <= n2.value) {
        n1.also { n1 = it.next }
    } else {
        n2.also { n2 = it.next }
    }
    var tail = head
    while (n1 != null && n2 != null) {
        if (n1!!.value <= n2!!.value) {
            tail.next = n1
            tail = n1!!
            n1 = n1?.next
        } else {
            tail.next = n2
            tail = n2!!
            n2 = n2?.next
        }
    }
    if (n1 == null) {
        tail.next = n2
    } else { // n2 == null
        tail.next = n1
    }
    return head
}

fun e21_mergeTwoLists_2(list1: ListNode?, list2: ListNode?): ListNode? {
    if (list1 == null) return list2
    if (list2 == null) return list1

    return if (list1.value > list2.value) {
        ListNode(list2.value).apply {
            next = e21_mergeTwoLists_2(list1, list2.next)
        }
    } else {
        ListNode(list1.value).apply {
            next = e21_mergeTwoLists_2(list1.next, list2)
        }
    }
}