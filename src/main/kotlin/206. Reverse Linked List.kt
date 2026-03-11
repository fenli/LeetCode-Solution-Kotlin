/**
 * Problem : https://leetcode.com/problems/reverse-linked-list/description/
 * Submission : https://leetcode.com/problems/reverse-linked-list/submissions/1944770249
 */

class Solution206 {

    class ListNode(var `val`: Int) {
        var next: ListNode? = null
    }

    fun reverseList(head: ListNode?): ListNode? {
        var reversed: ListNode? = null
        var current = head

        while (current != null) {
            val temp = reversed
            reversed = ListNode(current.`val`)
            reversed.next = temp

            current = current.next
        }

        return reversed
    }
}

fun main() {
    val solution = Solution206()
}
