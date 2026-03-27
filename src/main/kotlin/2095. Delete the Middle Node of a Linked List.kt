/**
 * Problem : https://leetcode.com/problems/delete-the-middle-node-of-a-linked-list/description/
 * Submission : https://leetcode.com/problems/delete-the-middle-node-of-a-linked-list/submissions/1960761709
 */

class Solution2095 {
    data class ListNode(var `val`: Int, var next: ListNode? = null)

    fun deleteMiddle(head: ListNode?): ListNode? {
        if (head?.next == null) return null

        var mid: ListNode? = null
        var current = head
        var moveMid = false
        while (current != null) {
            current = current.next
            if (moveMid) mid = if (mid == null) head else mid?.next
            moveMid = !moveMid
        }
        mid?.next = mid?.next?.next

        return head
    }
}

fun main() {
    fun List<Int>.toListNode(): Solution2095.ListNode? {
        if (isEmpty()) return null
        return Solution2095.ListNode(first(), drop(1).toListNode())
    }

    val solution = Solution2095()
    check(solution.deleteMiddle(listOf(1, 3, 4, 7, 1, 2, 6).toListNode()) == listOf(1, 3, 4, 1, 2, 6).toListNode())
    check(solution.deleteMiddle(listOf(1, 2, 3, 4).toListNode()) == listOf(1, 2, 4).toListNode())
    check(solution.deleteMiddle(listOf(2, 1).toListNode()) == listOf(2).toListNode())
}
