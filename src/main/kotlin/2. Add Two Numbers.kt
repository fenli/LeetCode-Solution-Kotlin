/**
 * Problem : https://leetcode.com/problems/add-two-numbers/description/
 * Submission : https://leetcode.com/problems/add-two-numbers/submissions/1944741596
 */

class Solution2 {

    class ListNode(var `val`: Int) {
        var next: ListNode? = null
    }

    fun addTwoNumbers(l1: ListNode?, l2: ListNode?): ListNode? {
        var result: ListNode? = null
        var current: ListNode? = null
        var carry = 0

        var n1 = l1
        var n2 = l2

        while (n1 != null || n2 != null) {
            var sums = carry
            if (n1 != null) sums += n1.`val`
            if (n2 != null) sums += n2.`val`

            val node = if (sums >= 10) {
                carry = 1
                ListNode(sums - 10)
            } else {
                carry = 0
                ListNode(sums)
            }

            if (current == null) {
                current = node
                result = current
            } else {
                current.next = node
            }

            current = node

            n1 = n1?.next
            n2 = n2?.next
        }

        if (carry == 1) current?.next = ListNode(1)

        return result
    }
}

fun main() {
    val solution = Solution2()
}
