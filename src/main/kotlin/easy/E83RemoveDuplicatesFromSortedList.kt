package easy

import utils.ListNode
import utils.value

/**
 * [83. Remove Duplicates from Sorted List](https://leetcode.com/problems/remove-duplicates-from-sorted-list/)
 */
// just as for E27
fun e83_removeDuplicates(head: ListNode?): ListNode? {
    if (head?.next == null) return head // head == null (0) or head.next == null (1), already sorted
    var insert = head // node to insert after
    var search = head // node to get from
    while (search != null) {
        if (search.value != search.next?.value) {
            insert?.next = search.next
            insert = insert?.next
        }
        search = search.next
    }
    return head
}