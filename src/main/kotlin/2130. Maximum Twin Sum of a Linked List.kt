/**
 * Problem : https://leetcode.com/problems/maximum-twin-sum-of-a-linked-list/description/
 * Submission : https://leetcode.com/problems/maximum-twin-sum-of-a-linked-list/submissions/1960905755
 */

class Solution2130 {
    data class ListNode(var `val`: Int, var next: ListNode? = null)

    fun pairSum(head: ListNode?): Int {
        var size = 0
        var current = head
        while (current != null) {
            size++
            current = current?.next
        }

        var maxSum = 0
        current = head
        var firstHalf: ListNode? = null
        var i = 0
        while (current != null) {
            if (i < size / 2) {
                // reverse
                val next = current?.next
                if (firstHalf == null) {
                    firstHalf = current
                    firstHalf?.next = null
                } else {
                    current?.next = firstHalf
                    firstHalf = current
                }

                current = next
                i++
            } else {
                // start counting
                val sum = current!!.`val` + firstHalf!!.`val`
                if (sum > maxSum) maxSum = sum

                current = current?.next
                firstHalf = firstHalf?.next
            }
        }

        return maxSum
    }
}

fun main() {
    fun List<Int>.toListNode(): Solution2130.ListNode? {
        if (isEmpty()) return null
        return Solution2130.ListNode(first(), drop(1).toListNode())
    }

    val solution = Solution2130()
    check(solution.pairSum(listOf(5, 4, 2, 1).toListNode()) == 6)
    check(solution.pairSum(listOf(4, 2, 2, 3).toListNode()) == 7)
    check(solution.pairSum(listOf(1, 100000).toListNode()) == 100001)
}
