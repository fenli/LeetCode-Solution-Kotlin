package p2236_maximum_twin_sum_of_a_linked_list

/**
 * Example:
 * var li = ListNode(5)
 * var v = li.`val`
 * Definition for singly-linked list.
 * class ListNode(var `val`: Int) {
 *     var next: ListNode? = null
 * }
 */
class Solution {
    fun pairSum(head: ListNode?): Int {
        var size = 0
        var current = head
        while(current != null) {
            size++
            current = current?.next
        }

        var maxSum = 0
        current = head
        var firstHalf: ListNode? = null
        var i = 0
        while(current != null) {
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
