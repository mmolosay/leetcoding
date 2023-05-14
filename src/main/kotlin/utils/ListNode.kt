package utils

class ListNode(val `val`: Int) {
    var next: ListNode? = null
}

val ListNode.value: Int
    get() = `val`

fun List<Int>.toListNode(): ListNode? =
    if (isEmpty()) null
    else {
        var head = ListNode(last())
        var i = lastIndex - 1
        while (i >= 0) {
            head = ListNode(get(i)).also { it.next = head }
            i--
        }
        head
    }

fun ListNode.toList(): List<Int> {
    var tail = this
    return buildList {
        add(tail.value)
        while (tail.next != null) {
            add(tail.next!!.value)
            tail = tail.next!!
        }
    }
}